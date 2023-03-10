package programmers.string

class CalculateString {
    fun solution(my_string: String): Int {
        val list = my_string.split(" ")
        return list.mapIndexed{ index, str ->
            (arrayOf("+","-").indexOf(str)) to index
        }.fold(list.first().toInt()){ acc, value ->
            when(value.first){
                -1 -> acc
                0 -> acc + list.get(value.second + 1).toInt()
                else -> acc - list.get(value.second + 1).toInt()
            }
        }
    }
}