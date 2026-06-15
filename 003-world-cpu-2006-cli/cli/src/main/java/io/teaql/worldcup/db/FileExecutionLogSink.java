package io.teaql.worldcup.db;

import io.teaql.core.ExecutionLogSink;
import io.teaql.core.ExecutionMetadata;
import io.teaql.core.UserContext;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class FileExecutionLogSink implements ExecutionLogSink {

    private static final String LOG_FILE = "teaql-execution.log";
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
            .withZone(ZoneId.systemDefault());

    @Override
    public void log(UserContext ctx, ExecutionMetadata meta) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String time = meta.getStartedAt() != null ? FMT.format(meta.getStartedAt()) : "";
            long elapsedUs = meta.getElapsedUs();
            String comment = meta.getComment() != null ? meta.getComment() : "Query";
            
            String summary = meta.getResultSummary() != null ? meta.getResultSummary() : "";
            if (summary.isEmpty() && meta.getResultCount() != null) {
                summary = "Fetched " + meta.getResultCount() + " rows";
            }
            if (summary.isEmpty() && meta.getAffectedRows() != null) {
                summary = "Affected " + meta.getAffectedRows() + " rows";
            }
            
            out.printf("[%s]-[%5dµs]-[DEBUG]-ExecutionLog - [%s] - [%s]%n",
                    time, elapsedUs, comment, summary);
            if (meta.getDebugQuery() != null) {
                out.println("          " + meta.getDebugQuery());
            }
        } catch (IOException e) {
            // Ignore log writing errors to not disrupt execution
        }
    }
}
