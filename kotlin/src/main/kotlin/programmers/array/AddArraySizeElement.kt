package programmers.array

class AddArraySizeElement {
    fun solution(arr: IntArray): IntArray =
        mutableListOf<Int>().apply {
            arr.forEach{ num ->
                (0 until num).forEach{
                    add(num)
                }
            }
        }.toIntArray()
}