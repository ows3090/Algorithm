package programmers.array

class TransformUpperCaseInArray {
    fun solution(strArr: Array<String>): Array<String> =
        strArr.mapIndexed{ index, str ->
            if(index % 2 == 0) str.toLowerCase()
            else str.toUpperCase()
        }.toTypedArray()
}