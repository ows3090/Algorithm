package programmers.basic

import kotlin.math.*
class MakeMaxNumber {
    fun solution(numbers: IntArray): Int {
        var answer: Int = numbers[0] * numbers[1]
        for(i in 0 until numbers.size - 1){
            for(j in i+1 until numbers.size){
                answer = max(answer, numbers[i]*numbers[j])
            }
        }
        return answer
    }
}