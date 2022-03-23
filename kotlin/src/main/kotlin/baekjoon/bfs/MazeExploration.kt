package baekjoon.bfs
import java.util.*
import kotlin.math.*

class MazeExploration {
    fun inside(n: Int, m: Int, y: Int, x: Int): Boolean {
        return 0 <= y && y < n && 0 <= x && x < m
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val input = readLine().split(" ")
        val n = input.first().toInt()
        val m = input.last().toInt()

        val arr = Array(n, { Array(m, { 0 }) })
        val visit = Array(n, { Array(m, { 0 }) })
        val dir = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))

        for (i in 0 until n) {
            readLine().toCharArray().map { it.toString().toInt() }.forEachIndexed { j, num ->
                arr[i][j] = num
            }
        }

        val q = LinkedList<Pair<Int, Int>>()
        val cost = LinkedList<Int>()
        q.add(Pair(0, 0))
        cost.add(1)
        visit[0][0] = 1

        while (!q.isEmpty()) {
            val y = q.peek().first
            val x = q.peek().second
            val c = cost.poll()
            q.poll()

            if(y == n-1 && x == m-1){
                println(c)
                break;
            }

            for (d in dir) {
                val dy = y + d[0]
                val dx = x + d[1]

                if(inside(n,m,dy,dx) && arr[dy][dx] == 1 && visit[dy][dx] ==0){
                    q.add(Pair(dy, dx))
                    visit[dy][dx] = 1
                    cost.add(c+1)
                }
            }
        }
    }

}