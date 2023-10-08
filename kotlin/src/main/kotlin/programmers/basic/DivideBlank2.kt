package programmers.basic

class DivideBlank2 {
    fun solution(my_string: String): Array<String> =
        my_string.split(" ")
            .filter{ it.isNotEmpty() }
            .toTypedArray()
}