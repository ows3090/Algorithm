package programmers.basic

class PushWord {
    fun solution(A: String, B: String): Int {
        var answer: Int = 0
        var temp = A
        while(temp != B && answer < A.length){
            answer++
            temp = temp.last() + temp.substring(0, temp.length - 1)
        }

        return if(answer < A.length) answer else -1
    }
}