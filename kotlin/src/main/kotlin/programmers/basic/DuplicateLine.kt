package programmers.basic

class DuplicateLine {
    fun solution(lines: Array<IntArray>): Int {
        var answer = 0
        val values = Array(201){0}.apply{
            lines.forEach{ line ->
                (line.first() until line.last()).forEach{
                    set(it + 100, get(it + 100) + 1)
                }
            }
        }
        for(i in 0 until 201){
            if(values.get(i) >= 2){
                answer++
            }
        }
        return answer
    }
}