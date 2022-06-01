package programmers.greedy

class GymSuit {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n
        val reallost = lost.filter{ n -> reserve.count{ it == n} == 0 }.sortedDescending().toMutableList()
        val realreserve = reserve.filter{ n -> lost.count{ it == n} == 0}.sortedDescending()

        realreserve.forEach{ num ->
            if(num == n){
                if(reallost.count{ num-1 == it} > 0){
                    reallost.remove(num-1)
                }
            }else if(num == 1){
                if(reallost.count{ num+1 == it} > 0){
                    reallost.remove(num+1)
                }
            }else{
                if(reallost.count{ num+1 == it } > 0){
                    reallost.remove(num+1)
                }else{
                    if(reallost.count{ num-1 == it} > 0){
                        reallost.remove(num-1)
                    }
                }
            }
        }


        return answer-reallost.size
    }
}