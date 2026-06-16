package com.example.vendingmachineservice;

import io.teaql.core.UserContext;
import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.sql.SQLRepositorySchemaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class SchemaStartupListener implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(SchemaStartupListener.class);

    @Autowired 
    private EntityMetaFactory factory;

    @Override
    public void run(String... args) throws Exception {
        String schemaMode = System.getenv("TEAQL_SCHEMA");
        if (schemaMode == null || schemaMode.trim().isEmpty()) {
            schemaMode = "_verify";
        }


        try {
            UserContext context = new CustomUserContext();
            SQLRepositorySchemaHelper helper = new SQLRepositorySchemaHelper();

            switch (schemaMode) {
                case "_execute":
                    log.info("[TEAQL_SCHEMA] Execute mode: Migrating database schema...");
                    helper.ensureSchema(context, factory);
                    break;
                case "_dryrun":
                    log.info("[TEAQL_SCHEMA] DryRun mode: Checking database schema...");
                    helper.ensureSchema(context, factory); // In future, dryrun should only print SQL
                    break;
                case "_verify":
                default:
                    if (!"_verify".equals(schemaMode)) {
                        log.warn("Unknown TEAQL_SCHEMA value: '{}'. Defaulting to '_verify'.", schemaMode);
                    }
                    log.info("[TEAQL_SCHEMA] Verify mode: Checking database schema matches domain model...");
                    helper.ensureSchema(context, factory); // verify mode
                    break;
            }
            log.info("Schema verification completed successfully.");
        } catch (Exception e) {
            log.error("Failed to verify/migrate database schema. Halting startup.", e);
            System.exit(1);
        }
    }
}