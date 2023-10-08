package programmers.basic

class NumberOfX {
    fun solution(myString: String): IntArray =
        myString.split('x')
            .map { it.length }
            .toIntArray()
}