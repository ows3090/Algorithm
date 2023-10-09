package programmers.array

class FindWantedString {
    fun solution(myString: String, pat: String): Int =
        if(myString.toLowerCase().contains(pat.toLowerCase())) 1 else 0
}