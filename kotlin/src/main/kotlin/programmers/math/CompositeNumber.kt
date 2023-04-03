package programmers.math

import kotlin.math.*
class CompositeNumber {
    fun isPrime(n: Int): Boolean = when(n){
        1, 2, 3 -> true
        else -> (2..(ceil(sqrt(n.toFloat())).toInt())).any{ n % it == 0}.not()
    }

    fun solution(n: Int): Int = (1..n).count{ isPrime(it).not() }
}