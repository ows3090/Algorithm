package baekjoon.bfs

import java.util.*

class Fire {
    fun inside(n: Int, m: Int, y: Int, x: Int): Boolean {
        return 0 <= y && y < n && 0 <= x && x < m
    }

    fun main() = with(System.`in`.bufferedReader()) {
        val input = readLine().split(" ")
        val n = input.first().toInt()
        val m = input.last().toInt()

        val arr = Array(n, { Array(m, { 0 }) })
        val fvisit = Array(n, { Array(m, { Int.MAX_VALUE }) })
        val jvisit = Array(n, { Array(m, { -1 }) })
        val dir = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))

        val jq = LinkedList<Pair<Int,Int>>()
        val fq = LinkedList<Pair<Int,Int>>()

        for (i in 0 until n) {
            readLine().toCharArray().forEachIndexed { j, ch ->
                when(ch){
                    '#' -> arr[i][j] = -1
                    '.' -> arr[i][j] = 0
                    'J' -> {
                        arr[i][j] = 1
                        jq.add(Pair(i,j))
                        jvisit[i][j] = 0
                    }
                    'F' ->{
                        arr[i][j] = 2
                        fq.add(Pair(i,j))
                        fvisit[i][j] = 0
                    }
                }
            }
        }

        while(!fq.isEmpty()){
            val y = fq.peek().first
            val x = fq.peek().second
            fq.poll()

            for(d in dir){
                val dy = y + d[0]
                val dx = x + d[1]

                if(inside(n,m,dy,dx) && arr[dy][dx] == 0){
                    if(fvisit[y][x] + 1 < fvisit[dy][dx])
                        fq.add(Pair(dy,dx))
                    fvisit[dy][dx] = fvisit[y][x] + 1
                }
            }
        }

        var result = -1
        loop@while(!jq.isEmpty()){
            val y = jq.peek().first
            val x = jq.peek().second
            jq.poll()

            for(d in dir){
                val dy = y + d[0]
                val dx = x + d[1]

                if(!inside(n,m,dy,dx)){
                    result = jvisit[y][x] + 1
                    break@loop
                }

                if(arr[dy][dx] == 0 && jvisit[dy][dx] == -1){
                    if(jvisit[y][x] + 1 <fvisit[y][x]){
                        jq.add(Pair(dy,dx))
                        jvisit[dy][dx] = jvisit[y][x] + 1
                    }
                }
            }
        }
        if(result == -1){
            println("IMPOSSIBLE")
        }else{
            println(result)
        }
    }
}