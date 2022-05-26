package programmers.basic

class FailureRate {
    fun solution(N: Int, stages: IntArray): IntArray {
        val answer = IntArray(N+2)
        stages.forEach{ answer[it]++ }

        var total = stages.size
        val map = mutableListOf<Pair<Int, Double>>()
        for(i in 1..N){
            map.add(Pair(i, answer.get(i) / total.toDouble()))
            total -= answer.get(i)
        }

        return map.sortedWith(compareBy({-it.second}, {it.first})).map { it.first }.toIntArray()
    }
}