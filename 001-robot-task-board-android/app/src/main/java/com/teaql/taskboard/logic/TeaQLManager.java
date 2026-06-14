package com.teaql.taskboard.logic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.robottaskboardservice.EntityMetaRegistry;
import com.example.robottaskboardservice.platform.Platform;

import io.teaql.android.AndroidSqliteDataServiceExecutor;
import io.teaql.core.UserContext;
import io.teaql.core.log.CustomLogSink;
import io.teaql.core.meta.SimpleEntityMetaFactory;
import io.teaql.dataservice.sql.SqlDataServiceExecutor;
import io.teaql.runtime.DefaultUserContext;
import io.teaql.runtime.TeaQLRuntime;

public class TeaQLManager {
    private static UserContext userContext;
    private static CustomLogSink customLogSink;
    
    private static class TeaQLDbHelper extends SQLiteOpenHelper {
        public TeaQLDbHelper(Context context) {
            super(context, "taskboard_teaql.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Schema creation is now handled dynamically by TeaQL via ensureSchema()
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Handled by TeaQL
        }
    }

    public static synchronized void init(Context context, CustomLogSink sink) {
        if (userContext != null) return;
        customLogSink = sink;

        // 1. Setup SQLite Database
        TeaQLDbHelper dbHelper = new TeaQLDbHelper(context);
        SQLiteDatabase sqliteDb = dbHelper.getWritableDatabase();

        // 2. Setup Entity Metadata
        SimpleEntityMetaFactory metaFactory = new SimpleEntityMetaFactory();
        new EntityMetaRegistry().assemble(metaFactory);

        // 3. Setup SQL Data Service Provider using Execution Adapter pattern
        SqlDataServiceExecutor dataService = new AndroidSqliteDataServiceExecutor(
                "default",
                sqliteDb
        );

        // 4. Setup TeaQL Runtime
        TeaQLRuntime runtime = new TeaQLRuntime.Builder()
                .metadata(metaFactory)
                .dataService("default", dataService)
                .build();

        // 5. Setup UserContext
        DefaultUserContext ctx = new DefaultUserContext(runtime);
        ctx.registerCustomSink(sink);

        // 6. Ensure Schema and Initial Data
        dataService.ensureSchema(ctx);
        initializeDataIfEmpty(ctx);

        userContext = ctx;
    }

    private static void initializeDataIfEmpty(UserContext ctx) {
        try {
            int count = com.example.robottaskboardservice.Q.platforms().comment("Init").purpose("Check").executeForList(ctx).size();
            if (count == 0) {
                // Insert Platform
                Platform platform = new Platform();
                platform.updateId(1L);
                platform.updateName("Android Local Platform");
                platform.auditAs("Init").save(ctx);

                // Insert Constants for Task Status
                com.example.robottaskboardservice.taskstatus.TaskStatus todo = new com.example.robottaskboardservice.taskstatus.TaskStatus();
                todo.updateId(1001L);
                todo.updateName("TODO");
                todo.updateCode("TODO");
                todo.updatePlatform(platform);
                todo.auditAs("Init").save(ctx);

                com.example.robottaskboardservice.taskstatus.TaskStatus inProgress = new com.example.robottaskboardservice.taskstatus.TaskStatus();
                inProgress.updateId(1002L);
                inProgress.updateName("In Progress");
                inProgress.updateCode("IN_PROGRESS");
                inProgress.updatePlatform(platform);
                inProgress.auditAs("Init").save(ctx);

                com.example.robottaskboardservice.taskstatus.TaskStatus done = new com.example.robottaskboardservice.taskstatus.TaskStatus();
                done.updateId(1003L);
                done.updateName("Done");
                done.updateCode("DONE");
                done.updatePlatform(platform);
                done.auditAs("Init").save(ctx);
                
                // Insert Sample Tasks
                com.example.robottaskboardservice.task.Task task1 = new com.example.robottaskboardservice.task.Task();
                task1.updateId(1L);
                task1.updateName("Setup Database");
                task1.updatePlatform(platform);
                task1.updateStatusToDone();
                task1.auditAs("Init").save(ctx);

                com.example.robottaskboardservice.task.Task task2 = new com.example.robottaskboardservice.task.Task();
                task2.updateId(2L);
                task2.updateName("Connect TeaQL");
                task2.updatePlatform(platform);
                task2.updateStatusToInProgress();
                task2.auditAs("Init").save(ctx);

                com.example.robottaskboardservice.task.Task task3 = new com.example.robottaskboardservice.task.Task();
                task3.updateId(3L);
                task3.updateName("Render UI");
                task3.updatePlatform(platform);
                task3.updateStatusToTodo();
                task3.auditAs("Init").save(ctx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserContext getCtx() {
        return userContext;
    }
}
