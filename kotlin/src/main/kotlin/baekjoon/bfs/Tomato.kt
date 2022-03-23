package baekjoon.bfs

import java.util.*
import kotlin.math.max

class Tomato {
    fun inside(n: Int, m: Int, y: Int, x: Int): Boolean {
        return 0 <= y && y < n && 0 <= x && x < m
    }

    fun main() = with(System.`in`.bufferedReader()) {
        val input = readLine().split(" ")
        val m = input.first().toInt()
        val n = input.last().toInt()

        val arr = Array(n, { Array(m, { 0 }) })
        val visit = Array(n, { Array(m, { Int.MAX_VALUE }) })
        val dir = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))

        for (i in 0 until n) {
            readLine().split(" ").forEachIndexed { j, num ->
                arr[i][j] = num.toInt()
            }
        }

        val q = LinkedList<Pair<Int,Int>>()
        for(i in 0 until n){
            for(j in 0 until m){
                if(arr[i][j] == 1){
                    q.add(Pair(i,j))
                    visit[i][j] = 0
                }
            }
        }

        while(!q.isEmpty()){
            val y = q.peek().first
            val x = q.peek().second
            q.poll()

            for(d in dir){
                val dy = y + d[0]
                val dx = x + d[1]

                if(inside(n,m,dy,dx) && arr[dy][dx] == 0){
                    if(visit[y][x] + 1 < visit[dy][dx]){
                        q.add(Pair(dy,dx))
                        visit[dy][dx] = visit[y][x] + 1
                    }
                }
            }
        }

        var result = -1
        loop@for(i in 0 until n){
            for(j in 0 until m){
                if(visit[i][j] == Int.MAX_VALUE){
                    if(arr[i][j] == 0){
                        result = -1
                        break@loop
                    }
                    continue
                }
                result = max(result, visit[i][j])
            }
        }
        println(result)
    }
}