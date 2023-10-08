package programmers.string

class GroupStrings {
    fun solution(strArr: Array<String>): Int =
        strArr.groupBy{ it.length }
            .maxByOrNull{ it.value.size }!!.value.size
}