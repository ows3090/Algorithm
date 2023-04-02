package programmers.math

class Factorization {
    fun solution(n: Int): IntArray {
        var answer = mutableSetOf<Int>()
        var num = n
        var r = 2
        while(num > 1){
            if(num % r == 0){
                num/=r
                answer.add(r)
            }
            else r++
        }

        return answer.toIntArray()
    }
}