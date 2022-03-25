package baekjoon.graph
import kotlin.math.min

class Floyd {
    fun main() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val num = readLine().toInt()

        val arr = Array(n + 1, { Array(n + 1, { 10000005 }) })

        for(i in 1..n){
            arr[i][i] = 0
        }

        for (i in 0 until num) {
            var info = readLine().split(" ").map { it.toInt() }

            arr[info[0]][info[1]] = min(arr[info[0]][info[1]], info[2])
        }



        for(i in 1..n){
            for(j in 1..n){
                for(k in 1..n){
                    arr[j][k] = min(arr[j][i] + arr[i][k], arr[j][k])
                }
            }
        }

        for(i in 1..n){
            for(j in 1..n){
                if(arr[i][j] == 10000005) arr[i][j] = 0
                print("${arr[i][j]} ")
            }
            println()
        }
    }
}