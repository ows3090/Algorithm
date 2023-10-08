package programmers.string

class ReplaceToUpperCase {
    fun solution(my_string: String, alp: String): String =
        my_string.replace(alp, alp.toUpperCase())
}