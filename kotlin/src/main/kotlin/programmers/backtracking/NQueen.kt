package programmers.backtracking

class NQueen {
    var answer = 0
    fun backtracking(n: Int, h: Int, harr: List<Int>, leftarr: List<Int>, rightarr: List<Int>){
        if(n == h){
            answer++
        }else{
            for(i in 0 until n){
                if(!harr.contains(i) && !leftarr.contains(h+i) && !rightarr.contains(n-h+i)){
                    backtracking(n,h+1, harr+listOf(i), leftarr+listOf(h+i), rightarr+listOf(n-h+i))
                }
            }
        }
    }

    fun solution(n: Int): Int {
        backtracking(n, 0, listOf(), listOf(),listOf())
        return answer
    }
}