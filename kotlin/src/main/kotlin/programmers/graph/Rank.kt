package programmers.graph

import java.util.*

class Rank {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        var arr = Array(n+1, {Array(n+1, {0})})
        var match = Array(n+1, {mutableSetOf<Int>()})

        for(result in results){
            arr[result[0]][result[1]] = 1
            arr[result[1]][result[0]] = -1
            match.get(result[0]).add(result[1])
        }

        for(i in 1..n){
            val q = LinkedList<Int>()
            for(elem in match.get(i)){
                q.add(elem)
            }

            while(q.isNotEmpty()){
                val front = q.poll()

                for(elem in match.get(front)){
                    if(arr[i][elem] == 0){
                        arr[i][elem] = 1
                        arr[elem][i] = -1
                        q.add(elem)
                    }
                }
            }
        }

        for(i in 1..n){
            var flag = true
            for(j in 1..n){
                if(i!=j && arr[i][j] == 0){
                    flag = false
                    break
                }
            }

            if(flag) answer++
        }

        return answer
    }
}