package programmers.basic

class HIndex {
    fun solution(citations: IntArray): Int {
        var maxcnt = citations.max()!!
        return maxcnt.downTo(0).filter{ i ->
            citations.filter{ it >= i}.size >=i
        }.max()!!
    }
}