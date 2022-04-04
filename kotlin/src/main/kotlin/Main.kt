import java.util.*
import kotlin.collections.LinkedHashMap

fun main() = with(System.`in`.bufferedReader()) {

    val arr = arrayOf("pop","R&B","jazz")
    val grouping = arr.indices.groupBy { arr.get(it) }.toList()
    println(grouping)
}