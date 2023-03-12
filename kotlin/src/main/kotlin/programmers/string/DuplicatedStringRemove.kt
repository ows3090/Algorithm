package programmers.string

class DuplicatedStringRemove {
    fun solution(my_string: String): String =
        my_string.fold(""){ acc, ch ->
            if(acc.contains(ch).not()) acc + ch else acc
        }

    /**
     * distinct() -> Colection 중복 제거
     */
    fun solution2(my_string: String): String =
        my_string.toList().distinct().joinToString("")
}