package programmers.basic

class MakeJadenCaseString {
    fun solution(s: String): String {
        return s.split(" ").map{ str ->
            if(str == " ") str
            else if(str[0].isLowerCase()) str[0].toUpperCase() + str.substring(1, str.length).toLowerCase()
            else str.toLowerCase()
        }.joinToString(" ")
    }
}