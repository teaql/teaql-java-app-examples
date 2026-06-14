package com.teaql.taskboard.ui;

import com.teaql.taskboard.R;
import com.teaql.taskboard.logic.LogEntry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.LogViewHolder> {

    private List<LogEntry> logs;

    public LogAdapter(List<LogEntry> logs) {
        this.logs = logs;
    }

    public void updateLogs(List<LogEntry> newLogs) {
        this.logs = newLogs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_log, parent, false);
        return new LogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogViewHolder holder, int position) {
        LogEntry log = logs.get(position);
        holder.tvLogQuery.setText(log.getQuery());
        holder.tvLogTime.setText(log.getTimestamp());
    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    static class LogViewHolder extends RecyclerView.ViewHolder {
        TextView tvLogQuery, tvLogTime;

        public LogViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLogQuery = itemView.findViewById(R.id.tvLogQuery);
            tvLogTime = itemView.findViewById(R.id.tvLogTime);
        }
    }
}
