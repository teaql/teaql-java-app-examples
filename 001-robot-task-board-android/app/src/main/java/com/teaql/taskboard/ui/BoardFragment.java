package com.teaql.taskboard.ui;

import com.teaql.taskboard.R;
import com.teaql.taskboard.logic.TeaQLManager;
import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.taskstatus.TaskStatus;
import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.Q;
import io.teaql.core.UserContext;
import io.teaql.core.SmartList;
import com.teaql.taskboard.logic.TaskLogic;
import com.teaql.taskboard.logic.BusinessTask;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.List;

@SuppressWarnings("deprecation")
public class BoardFragment extends Fragment {

    private LinearLayout colTodo, colInProgress, colDone;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        colTodo = view.findViewById(R.id.colTodo);
        colInProgress = view.findViewById(R.id.colInProgress);
        colDone = view.findViewById(R.id.colDone);

        Button btnAddTask = view.findViewById(R.id.btnAddTask);
        btnAddTask.setOnClickListener(v -> {
            UserContext ctx = TeaQLManager.getCtx();
            String taskName = "New Task " + (System.currentTimeMillis() % 1000);
            TaskLogic.createNewTask(ctx, taskName);
            refreshBoard();
        });

        setupDragListener(colTodo, "TODO");
        setupDragListener(colInProgress, "IN_PROGRESS");
        setupDragListener(colDone, "DONE");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshBoard();
    }

    private void refreshBoard() {
        // Clear all views except the first one (header)
        clearColumn(colTodo);
        clearColumn(colInProgress);
        clearColumn(colDone);

        UserContext ctx = TeaQLManager.getCtx();
        if (ctx == null) return;
        SmartList<BusinessTask> tasks = TaskLogic.getAllTasks(ctx);
        for (Task task : tasks) {
            View taskView = LayoutInflater.from(getContext()).inflate(R.layout.item_task, null);
            TextView tvName = taskView.findViewById(R.id.tvTaskName);
            tvName.setText(task.getName());
            taskView.setTag(task.getId());

            taskView.setOnLongClickListener(v -> {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(taskView);
                v.startDragAndDrop(dragData, myShadow, v, 0);
                return true;
            });

            String statusCode = task.getStatus() != null ? task.getStatus().getCode() : "";
            switch (statusCode) {
                case "TODO":
                    colTodo.addView(taskView);
                    break;
                case "IN_PROGRESS":
                    colInProgress.addView(taskView);
                    break;
                case "DONE":
                    colDone.addView(taskView);
                    break;
            }
        }
    }

    private void clearColumn(LinearLayout column) {
        int childCount = column.getChildCount();
        if (childCount > 1) {
            column.removeViews(1, childCount - 1);
        }
    }

    private void setupDragListener(LinearLayout column, String targetStatus) {
        column.setOnDragListener((v, event) -> {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    return event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN);
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundColor(Color.LTGRAY);
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundColor(Color.parseColor("#F0F0F0"));
                    return true;
                case DragEvent.ACTION_DROP:
                    ClipData.Item item = event.getClipData().getItemAt(0);
                    String taskId = item.getText().toString();
                    
                    // Call the logic layer
                    UserContext ctx = TeaQLManager.getCtx();
                    TaskLogic.updateTaskStatus(ctx, taskId, targetStatus);
                    
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    
                    Toast.makeText(getContext(), "Migrated to " + targetStatus, Toast.LENGTH_SHORT).show();
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundColor(Color.parseColor("#F0F0F0"));
                    return true;
                default:
                    break;
            }
            return false;
        });
    }
}
