package programmers.string

class FindChangedString {
    fun solution(myString: String, pat: String): Int =
        if(myString.contains(
                pat.replace("A","C")
                    .replace("B","D")
                    .replace("C","B")
                    .replace("D","A")
            )) {
            1
        } else {
            0
        }
}