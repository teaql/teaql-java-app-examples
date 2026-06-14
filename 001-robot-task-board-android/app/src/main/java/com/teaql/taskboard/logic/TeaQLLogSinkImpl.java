package com.teaql.taskboard.logic;

import io.teaql.core.log.CustomLogSink;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TeaQLLogSinkImpl implements CustomLogSink {
    private static final TeaQLLogSinkImpl INSTANCE = new TeaQLLogSinkImpl();
    private final List<LogEntry> logs = new ArrayList<>();
    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
    
    // UI listeners
    public interface LogListener {
        void onLogAdded();
    }
    private LogListener listener;

    private TeaQLLogSinkImpl() {}

    public static TeaQLLogSinkImpl getInstance() {
        return INSTANCE;
    }
    
    public void setListener(LogListener listener) {
        this.listener = listener;
    }

    @Override
    public void onLog(String formattedLogContent) {
        synchronized (logs) {
            String time = sdf.format(new Date());
            logs.add(new LogEntry(formattedLogContent, time));
            if (listener != null) {
                listener.onLogAdded();
            }
        }
    }
    
    public List<LogEntry> getLogs() {
        synchronized (logs) {
            return new ArrayList<>(logs);
        }
    }
}
