import kotlin.math.sqrt

fun isPrime(n: Int): Boolean = (2..sqrt(n.toDouble()).toInt()).all {
    n % it != 0
}

fun main() = with(System.`in`.bufferedReader()) {
    println(isPrime(6))
}