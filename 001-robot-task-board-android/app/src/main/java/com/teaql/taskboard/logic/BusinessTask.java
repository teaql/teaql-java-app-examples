package com.teaql.taskboard.logic;

import com.example.robottaskboardservice.task.Task;
import io.teaql.core.UserContext;

public class BusinessTask extends Task {

    public void transitStatus(UserContext ctx, String newStatusCode) {
        switch (newStatusCode) {
            case "TODO":
                this.updateStatusToTodo();
                break;
            case "IN_PROGRESS":
                this.updateStatusToInProgress();
                break;
            case "DONE":
                this.updateStatusToDone();
                break;
            default:
                return;
        }
        this.auditAs("Moved task status from drag-and-drop").save(ctx);
    }
}
