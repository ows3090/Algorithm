package programmers.hash

class Costume {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = clothes.groupBy { it[1] }.values.fold(1) { acc, arrays ->
            acc*(arrays.size + 1)
        } - 1
        return answer
    }
}