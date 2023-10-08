package programmers.basic

class Removead {
    fun solution(strArr: Array<String>): Array<String> =
        strArr.filter { it.contains("ad").not() }.toTypedArray()
}