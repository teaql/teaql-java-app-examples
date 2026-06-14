package com.teaql.taskboard.logic;

import com.example.robottaskboardservice.task.Task;

public class BusinessTask extends Task {

    public void transitStatus(String newStatusCode) {
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
    }
}
