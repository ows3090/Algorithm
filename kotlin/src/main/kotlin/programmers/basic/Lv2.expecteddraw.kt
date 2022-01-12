package programmers.basic

class ExpectedDraw {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var first = if(a>b) b else a
        var second = if(a>b) a else b

        while(first!=second){
            answer++
            first = (first/2) + (first%2)
            second = (second/2) + (second%2)
        }
        return answer
    }
}