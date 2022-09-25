import java.util.*
import kotlin.math.max
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val list = listOf(listOf("a","b"), listOf("b","b"), listOf("c","b"), listOf("c","c"), listOf("d","c"))
    val map = list.groupBy { it.last() }.map { it.value }?.let {
        if(it.size == 1) it.size else it.size + it.fold(1){acc, list -> acc*list.size }
    }
    println(map)
}