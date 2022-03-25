package baekjoon.dp
import kotlin.math.*

class ClimbingStairs {
    fun main() = with(System.`in`.bufferedReader()) {
        val num = readLine().toInt()
        val arr = Array(num+1, {0})

        for(i in 1..num){
            arr[i] = readLine().toInt()
        }

        if(num == 1){
            println(arr[1])
            return
        }

        val dist = Array(num+1, {Array(3, {0})})
        dist[1][1] = arr[1]
        dist[1][2] = 0
        dist[2][1] = arr[2]
        dist[2][2] = dist[1][1] + arr[2]

        for(i in 3..num){
            dist[i][1] = max(dist[i-2][1] , dist[i-2][2]) + arr[i]
            dist[i][2] = dist[i-1][1] + arr[i]
        }

        println(max(dist[num][1],dist[num][2]))
    }



}