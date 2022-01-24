package programmers.`brute-force`

import kotlin.math.*

class MatrixRotation {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        var arr = Array(rows, { r ->
            Array(columns, { c -> r*columns + c + 1})
        })

        for(query in queries){
            var list = mutableListOf<Int>()
            val sy = query[0]-1
            val sx = query[1]-1
            val ey = query[2]-1
            val ex = query[3]-1

            var num = arr[sy][sx]
            for(i in sx+1..ex){
                var temp = num
                num = arr[sy][i]
                arr[sy][i] = temp
                list.add(temp)
            }

            for(i in sy+1..ey){
                var temp = num
                num = arr[i][ex]
                arr[i][ex] = temp
                list.add(temp)
            }

            for(i in ex-1 downTo sx){
                var temp = num
                num = arr[ey][i]
                arr[ey][i] = temp
                list.add(temp)
            }

            for(i in ey-1 downTo sy){
                var temp = num
                num = arr[i][sx]
                arr[i][sx] = temp
                list.add(temp)
            }
            answer.add(list.min()!!)
        }

        return answer.toIntArray()
    }
}