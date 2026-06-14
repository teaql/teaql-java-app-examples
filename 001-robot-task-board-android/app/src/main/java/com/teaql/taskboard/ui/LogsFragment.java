package com.teaql.taskboard.ui;

import com.teaql.taskboard.R;
import com.teaql.taskboard.logic.TeaQLLogSinkImpl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LogsFragment extends Fragment {

    private RecyclerView recyclerView;
    private LogAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logs, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewLogs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        adapter = new LogAdapter(TeaQLLogSinkImpl.getInstance().getLogs());
        recyclerView.setAdapter(adapter);
        
        TeaQLLogSinkImpl.getInstance().setListener(() -> {
            if (getActivity() != null) {
                getActivity().runOnUiThread(() -> {
                    adapter.updateLogs(TeaQLLogSinkImpl.getInstance().getLogs());
                    recyclerView.scrollToPosition(adapter.getItemCount() - 1);
                });
            }
        });
        
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.updateLogs(TeaQLLogSinkImpl.getInstance().getLogs());
        }
    }
}
