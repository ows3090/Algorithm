import java.util.*
import kotlin.math.max
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val list = intArrayOf(1,2,3,4,5)

    val q = LinkedList<Pair<Int,Int>>().apply {
        list.forEachIndexed { index, i -> add(Pair(index, i)) }
    }


}