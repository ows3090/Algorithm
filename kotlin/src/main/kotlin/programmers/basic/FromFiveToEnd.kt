package programmers.basic

class FromFiveToEnd {
    fun solution(num_list: IntArray): IntArray =
        num_list.sorted().take(5).toIntArray()
}