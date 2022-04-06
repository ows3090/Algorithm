package programmers.recursion

class HanoiTower {
    var answer = mutableListOf<IntArray>()

    fun getresult(n: Int, s: Int, e: Int){
        if(n == 1){
            answer.add(intArrayOf(s,e))
        }else{
            getresult(n-1, s,6-s-e)
            answer.add(intArrayOf(s,e))
            getresult(n-1, 6-s-e,e)
        }
    }

    fun solution(n: Int): Array<IntArray> {
        getresult(n,1,3)
        return answer.toTypedArray()
    }
}