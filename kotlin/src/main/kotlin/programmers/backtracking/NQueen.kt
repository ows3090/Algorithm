package programmers.backtracking

class NQueen {
    var answer = 0

    fun backtraking(n: Int, y: Int, dlist: List<Int>, rdlist: List<Int>, ldlist: List<Int>){
        if(n == y){
            answer++
            return
        }

        (0 until n).forEach{ i ->
            if(dlist.contains(i).not() && rdlist.contains(y-i).not() && ldlist.contains(y+i).not()){
                backtraking(n, y+1, dlist + listOf(i), rdlist + listOf(y -i), ldlist + listOf(y + i))
            }
        }
    }

    fun solution(n: Int): Int {
        backtraking(n,0,listOf<Int>(), listOf<Int>(), listOf<Int>())
        return answer
    }
}