package programmers.basic

class HideNumber2 {
    fun solution(my_string: String): Int {
        var answer = 0
        var last = my_string.fold(""){ acc, i ->
            if(i.isDigit()) acc + i
            else{
                answer+= if(acc.length > 0) acc.toInt() else 0
                ""
            }
        }
        answer += if(last.length > 0) last.toInt() else 0
        return answer
    }
}