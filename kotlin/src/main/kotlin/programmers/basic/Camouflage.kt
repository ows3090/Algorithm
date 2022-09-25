package programmers.basic

class Camouflage {
    fun solution(clothes: Array<Array<String>>): Int =
            clothes.groupBy { it.last() }.mapValues { it.value.map { it.first() }}.map { it.value }?.let {
                it.fold(1){acc, list -> acc*(list.size + 1) } -1
            }
}