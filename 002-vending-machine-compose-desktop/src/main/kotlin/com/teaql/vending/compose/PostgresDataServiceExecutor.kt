package com.teaql.vending.compose

import io.teaql.core.UserContext
import io.teaql.core.meta.EntityDescriptor
import io.teaql.core.meta.EntityMetaFactory
import io.teaql.core.sql.portable.PortableSQLRepository
import io.teaql.core.sql.portable.TeaQLDatabase
import io.teaql.dataservice.sql.SqlDataServiceExecutor
import io.teaql.dataservice.sql.SqlExecutionAdapter
import javax.sql.DataSource
import java.util.Collections

class PostgresDataServiceExecutor(
    name: String,
    executionAdapter: SqlExecutionAdapter,
    private val dataSource: DataSource
) : SqlDataServiceExecutor(name, executionAdapter) {

    override fun ensureSchema(ctx: UserContext) {
        val descriptors = EntityMetaFactory.get().allEntityDescriptors()

        val dbAdapter = object : TeaQLDatabase {
            override fun query(sql: String, args: Array<Any>): List<Map<String, Any>> {
                return executionAdapter.queryForList(sql, args)
            }

            override fun executeUpdate(sql: String, args: Array<Any>): Int {
                return executionAdapter.update(sql, args)
            }

            override fun batchUpdate(sql: String, batchArgs: List<Array<Any>>): IntArray {
                return executionAdapter.batchUpdate(sql, batchArgs)
            }

            override fun execute(sql: String) {
                // Postgres might need specific type mapping replacements if PortableSQLRepository doesn't handle them
                executionAdapter.execute(sql.replace("<max>", "255"))
            }

            override fun execute(ctx: UserContext, sql: String) {
                this.execute(sql)
            }

            override fun executeInTransaction(action: Runnable) {
                action.run() 
            }

            override fun getTableColumns(tableName: String): List<Map<String, Any>> {
                return try {
                    val columns: List<Map<String, Any>> = executionAdapter.queryForList(
                        "SELECT column_name as \"column_name\", column_name as \"name\" FROM information_schema.columns WHERE table_name = ?",
                        arrayOf<Any>(tableName.lowercase())
                    )
                    columns
                } catch (e: Exception) {
                    emptyList()
                }
            }
        }

        for (descriptor in descriptors) {
            val repository = PortableSQLRepository<Any>(descriptor, dbAdapter, null)
            repository.ensureSchema(ctx)
        }
    }
}
