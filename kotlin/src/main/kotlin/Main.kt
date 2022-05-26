import java.lang.Integer.max
import kotlin.time.seconds

fun main() = with(System.`in`.bufferedReader()) {
    val list = listOf(1,3,5,3,1)
    println(list.count { it == 3 })
}