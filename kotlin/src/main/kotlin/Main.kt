import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

fun isPrime(n: Int): Boolean = (2..sqrt(n.toDouble()).toInt()).all {
    n % it != 0
}

fun main() = with(System.`in`.bufferedReader()) {
    val new_id = "...!@BaT#*..y.abcdefghijklm"
    val answer = new_id.toLowerCase()
            .filter { it.isLetter() || it.isDigit() || it in arrayOf('-','_','.') }
            .replace("[.]+".toRegex(), ".")
            .removePrefix(".")
            .removeSuffix(".")
            .let { if(it.isEmpty()) "a" else it }
            .let { if(it.length >=16) it.substring(0, 15).removeSuffix(".") else it }
            .let {
                if(it.length == 1) it + it + it
                else if(it.length == 2) it + it.last()
                else it
            }
    println(answer)
    val s = listOf<String>("123456","34312541","356356","13","!32")
    s.groupingBy { it }
    println(s)
}