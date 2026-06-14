package io.teaql.worldcup.db;

import com.example.fifaworldcupservice.EntityMetaRegistry;
import io.teaql.core.UserContext;
import io.teaql.core.meta.SimpleEntityMetaFactory;
import io.teaql.core.sqlite.SqliteDataServiceExecutor;
import io.teaql.provider.jdbc.JdbcSqlExecutor;
import io.teaql.runtime.DefaultUserContext;
import io.teaql.runtime.TeaQLRuntime;
import org.sqlite.SQLiteDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseManager {

    private static final String DB_DIR_NAME = ".wc2026";
    private static final String DB_FILE_NAME = "worldcup.db";

    private static DatabaseManager instance;

    private final Path dbPath;
    private Connection connection;
    private UserContext userContext;

    private DatabaseManager() {
        Path home = Paths.get(System.getProperty("user.home"));
        Path dbDir = home.resolve(DB_DIR_NAME);
        this.dbPath = dbDir.resolve(DB_FILE_NAME);

        try {
            Files.createDirectories(dbDir);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create data directory", e);
        }
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public synchronized UserContext getContext() {
        if (userContext == null) {
            SimpleEntityMetaFactory metaFactory = new SimpleEntityMetaFactory();
            new EntityMetaRegistry().assemble(metaFactory);
            
            SQLiteDataSource dataSource = new SQLiteDataSource();
            dataSource.setUrl("jdbc:sqlite:" + dbPath.toAbsolutePath());
            
            JdbcSqlExecutor adapter = new JdbcSqlExecutor(dataSource);
            SqliteDataServiceExecutor dataService = new SqliteDataServiceExecutor("default", adapter, dataSource);
            io.teaql.core.meta.EntityMetaFactory.registerGlobal(metaFactory);
            io.teaql.core.utils.Convert.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            try {
                java.lang.reflect.Field mapperField = io.teaql.core.utils.Convert.class.getDeclaredField("OBJECT_MAPPER");
                mapperField.setAccessible(true);
                com.fasterxml.jackson.databind.ObjectMapper mapper = (com.fasterxml.jackson.databind.ObjectMapper) mapperField.get(null);
                mapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            TeaQLRuntime runtime = new TeaQLRuntime.Builder()
                .metadata(metaFactory)
                .dataService("default", dataService)
                .logSink(new FileExecutionLogSink())
                .build();
                
            DefaultUserContext ctx = new DefaultUserContext(runtime);
            userContext = ctx;
            
            // This replaces the old raw SQL CREATE TABLE
            dataService.ensureSchema(ctx);
        }
        return userContext;
    }

    public synchronized Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:sqlite:" + dbPath.toAbsolutePath();
            connection = DriverManager.getConnection(url);
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("PRAGMA journal_mode=WAL");
                stmt.execute("PRAGMA foreign_keys=ON");
            }
        }
        return connection;
    }

    public synchronized void close() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
            } finally {
                connection = null;
            }
        }
    }

    public void initializeDatabase() throws SQLException {
        // Will be replaced by TeaQL's ensureSchema, called in getContext()
        getContext();
    }

    public boolean isInitialized() {
        try {
            return io.teaql.worldcup.db.SeedData.isInitialized(getContext());
        } catch (Exception e) {
            return false;
        }
    }
}
