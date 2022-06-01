import java.lang.Integer.max
import kotlin.time.seconds

fun main() = with(System.`in`.bufferedReader()) {
    val list = IntArray(5,{0}).sortedDescending().toMutableList()
    println(list.count { it == 0 })
}