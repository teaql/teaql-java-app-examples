package com.teaql.taskboard.logic;

public class LogEntry {
    private String query;
    private String timestamp;

    public LogEntry(String query, String timestamp) {
        this.query = query;
        this.timestamp = timestamp;
    }

    public String getQuery() { return query; }
    public String getTimestamp() { return timestamp; }
}
