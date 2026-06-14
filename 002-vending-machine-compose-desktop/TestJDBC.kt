import java.sql.DriverManager
import java.sql.Statement

fun main() {
    val connection = DriverManager.getConnection("jdbc:sqlite:test.db")
    connection.createStatement().use { it.execute("CREATE TABLE IF NOT EXISTS test (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)") }
    
    val pstmt = connection.prepareStatement("INSERT INTO test (name) VALUES ('hello')", Statement.RETURN_GENERATED_KEYS)
    pstmt.executeUpdate()
    val rs = pstmt.generatedKeys
    if (rs.next()) {
        println("Generated ID: " + rs.getLong(1))
    } else {
        println("No ID generated")
    }
}
