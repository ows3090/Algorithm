package programmers.basic

class SequenceAndQuery1 {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray =
        arr.apply {
            queries.forEach { query ->
                (query.first()..query.last()).forEach {
                    arr.set(it, arr[it] + 1)
                }
            }
        }
}