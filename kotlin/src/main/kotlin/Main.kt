import java.util.*
import kotlin.collections.LinkedHashMap

fun main() = with(System.`in`.bufferedReader()) {

    var arr = mutableListOf<Int>()
    arr.count { it >= 100 }

    val map = mutableMapOf<String,Int>().map { it }.sortedBy { it.value }

}