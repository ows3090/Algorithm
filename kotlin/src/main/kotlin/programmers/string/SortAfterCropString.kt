package programmers.string

class SortAfterCropString {
    fun solution(myString: String): Array<String> =
        myString.split('x')
            .filter{ it.isNotEmpty() }
            .toList().sorted().toTypedArray()
}