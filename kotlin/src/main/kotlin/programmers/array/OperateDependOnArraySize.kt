package programmers.array

class OperateDependOnArraySize {
    fun solution(num_list: IntArray): Int =
        if (num_list.size > 10) num_list.sum() else num_list.fold(1) { acc, num -> acc * num }
}