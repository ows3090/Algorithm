import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

fun isPrime(n: Int): Boolean = (2..sqrt(n.toDouble()).toInt()).all {
    n % it != 0
}

fun main() = with(System.`in`.bufferedReader()) {
    val arr = arrayOf(1, 2, 3)
    val s = Stack<Int>()
    arr.reverse()
    println(arr.contentToString())

    s.pop()

}