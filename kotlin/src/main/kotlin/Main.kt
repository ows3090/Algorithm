import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

fun isPrime(n: Int): Boolean = (2..sqrt(n.toDouble()).toInt()).all {
    n % it != 0
}

fun main() = with(System.`in`.bufferedReader()) {
    val list = listOf<Int>()


}