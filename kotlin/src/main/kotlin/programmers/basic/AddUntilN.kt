package programmers.basic

class AddUntilN {
    fun solution(numbers: IntArray, n: Int): Int {
        var answer: Int = 0
        var idx = 0
        while(answer <= n){
            answer += numbers[idx++]
        }
        return answer
    }
}