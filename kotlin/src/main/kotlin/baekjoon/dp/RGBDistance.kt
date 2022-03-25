package baekjoon.dp

import kotlin.math.*

class RGBDistance {
    fun main() = with(System.`in`.bufferedReader()) {
        val num = readLine().toInt()

        val arr = Array(num, {Array(3,{0})})
        for(i in 0 until num){
            arr[i] = readLine().split(" ").map { it.toInt() }.toTypedArray()
        }

        val dist = Array(num , {Array(3, {0})})
        for(i in 0..2){
            dist[0][i] = arr[0][i]
        }

        for(i in 1 until num){
            dist[i][0] = min(dist[i-1][1] , dist[i-1][2]) +  arr[i][0]
            dist[i][1] = min(dist[i-1][0], dist[i-1][2]) + arr[i][1]
            dist[i][2] = min(dist[i-1][0], dist[i-1][1]) + arr[i][2]
        }

        println(min(min(dist[num-1][0], dist[num-1][1]), dist[num-1][2]))
    }
}