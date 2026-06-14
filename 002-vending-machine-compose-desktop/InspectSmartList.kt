import io.teaql.core.SmartList
fun main() {
    val methods = SmartList::class.java.methods
    methods.forEach { if (it.name.contains("facet", ignoreCase = true)) println(it.name) }
}
