package programmers.bfs

import java.util.*
import kotlin.math.*

class CheckDistance {
    val dir = arrayOf(arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1),arrayOf(-1,0))

    fun inside(y: Int, x: Int): Boolean = 0<=y && y<5 && 0<=x && x<5

    fun solution(places: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()

        for(place in places){
            var arr = Array(5, {CharArray(5)})

            for(i in 0 until 5){
                arr[i] = place[i].toCharArray()
            }

            var check = true
            for(i in 0 until 5){
                for(j in 0 until 5){
                    if(arr[i][j] == 'P'){
                        val finish = Array(5, {BooleanArray(5)})
                        val s = Stack<Pair<Int,Int>>()
                        s.add(Pair(i,j))
                        finish[i][j] = true

                        while(s.isNotEmpty() && check){
                            val cur = s.peek()
                            s.pop()
                            if(abs(cur.first - i) + abs(cur.second-j) >= 2) continue

                            for(d in dir){
                                val dy = cur.first + d[0]
                                val dx = cur.second + d[1]

                                if(inside(dy,dx) && !finish[dy][dx]){
                                    if(arr[dy][dx] == 'P'){
                                        check = false
                                    }else if(arr[dy][dx] == 'O'){
                                        s.add(Pair(dy,dx))
                                        finish[dy][dx] = true
                                    }
                                }

                            }
                        }
                    }
                }
            }
            answer.add(if(check) 1 else 0)
        }
        return answer.toIntArray()
    }
}