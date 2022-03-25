import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toTypedArray()
    arr.sort()

    val cnt = readLine().toInt()
    val findlist = readLine().split(" ").map { it.toInt() }

    findlist.forEach {
        val find = if(arr.binarySearch(it) >= 0) 1 else 0
        println(find)
    }
}