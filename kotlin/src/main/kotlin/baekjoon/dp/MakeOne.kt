package baekjoon.dp
import kotlin.math.*

class MakeOne {
    fun main() = with(System.`in`.bufferedReader()) {
        val num = readLine().toInt()
        val arr = Array(num + 5, { 0 })
        arr[1] = 0
        arr[2] = 1
        arr[3] = 1
        for (i in 4..num) {
            arr[i] = arr[i - 1] + 1
            if (i % 3 == 0) {
                arr[i] = min(arr[i], arr[i / 3] + 1)
            }

            if (i % 2 == 0) {
                arr[i] = min(arr[i], arr[i / 2] + 1)
            }
        }
        println(arr[num])
    }
}