package programmers.string

class CalculateNumberOfString {
    fun solution(myString: String, pat: String): Int {
        var answer: Int = 0
        (0..(myString.length - pat.length)).forEach {
            if(myString.substring(it, it+pat.length) == pat) {
                answer++
            }
        }
        return answer
    }
}