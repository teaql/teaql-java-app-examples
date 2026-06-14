package io.teaql.worldcup.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class LogInterceptor extends PrintStream {

    private final PrintStream originalOut;
    private PrintWriter logFile;

    public LogInterceptor(PrintStream originalOut) {
        super(originalOut, true);
        this.originalOut = originalOut;
        try {
            this.logFile = new PrintWriter(new FileWriter("teaql-execution.log", true), true);
        } catch (IOException e) {
            // Ignore
        }
    }

    @Override
    public void print(String s) {
        if (s != null && s.contains("-ExecutionLog - ")) {
            if (logFile != null) {
                logFile.print(s);
                logFile.flush();
            }
        } else if (s != null && s.trim().startsWith("SELECT id,")) {
            if (logFile != null) {
                logFile.print(s);
                logFile.flush();
            }
        } else if (s != null && s.trim().startsWith("INSERT INTO")) {
             if (logFile != null) {
                 logFile.print(s);
                 logFile.flush();
             }
        } else if (s != null && s.trim().startsWith("UPDATE ")) {
             if (logFile != null) {
                 logFile.print(s);
                 logFile.flush();
             }
        } else if (s != null && s.trim().startsWith("DELETE ")) {
             if (logFile != null) {
                 logFile.print(s);
                 logFile.flush();
             }
        } else {
            originalOut.print(s);
        }
    }

    @Override
    public void println(String x) {
        if (x != null && x.contains("-ExecutionLog - ")) {
            if (logFile != null) {
                logFile.println(x);
                logFile.flush();
            }
        } else if (x != null && x.trim().startsWith("SELECT id,")) {
            if (logFile != null) {
                logFile.println(x);
                logFile.flush();
            }
        } else if (x != null && x.trim().startsWith("INSERT INTO")) {
             if (logFile != null) {
                 logFile.println(x);
                 logFile.flush();
             }
        } else if (x != null && x.trim().startsWith("UPDATE ")) {
             if (logFile != null) {
                 logFile.println(x);
                 logFile.flush();
             }
        } else if (x != null && x.trim().startsWith("DELETE ")) {
             if (logFile != null) {
                 logFile.println(x);
                 logFile.flush();
             }
        } else {
            originalOut.println(x);
        }
    }
}
