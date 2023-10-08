package programmers.basic

class FindLongestString {
    fun solution(myString: String, pat: String): String {
        var answer: String = ""
        var index = 0

        (0..(myString.length - pat.length)).forEach {
            if(myString.substring(it, it + pat.length) == pat) {
                index = it + pat.length
            }
        }

        return myString.substring(0, index)
    }
}