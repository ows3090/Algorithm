import java.util.*
import kotlin.math.*

fun inside(n: Int, m: Int, y: Int, x: Int): Boolean {
    return 0 <= y && y < n && 0 <= x && x < m
}

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ")
    val n = input.first().toInt()
    val m = input.last().toInt()

    val arr = Array(n, { Array(m, { 0 }) })
    val visit = Array(n, { Array(m, { 0 }) })
    val dir = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))

    for (i in 0 until n) {
        readLine().split(" ").forEachIndexed { j, s ->
            arr[i][j] = s.toInt()
        }
    }


    var count = 0
    var maxcount = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 1 && visit[i][j] == 0) {
                count++

                val q = LinkedList<Pair<Int, Int>>()
                q.add(Pair(i, j))
                visit[i][j] = 1
                var cnt = 1


                while (!q.isEmpty()) {
                    val y = q.peek().first
                    val x = q.peek().second
                    q.poll()

                    for (d in dir) {
                        val dy = y + d[0]
                        val dx = x + d[1]

                        if (inside(n, m, dy, dx) && arr[dy][dx] == 1 && visit[dy][dx] == 0) {
                            q.add(Pair(dy, dx))
                            visit[dy][dx] = 1
                            cnt++
                        }
                    }
                }

                maxcount = max(cnt, maxcount)
            }
        }
    }

    println(count)
    println(maxcount)
}


