package programmers.string

class StringSort {
    fun solution(my_string: String) = my_string
        .toLowerCase()
        .toCharArray()
        .sorted()
        .joinToString("")
}