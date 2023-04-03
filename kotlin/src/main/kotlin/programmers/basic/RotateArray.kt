package programmers.basic

class RotateArray {
    fun solution(numbers: IntArray, direction: String): IntArray =
        when(direction){
            "left" -> (numbers.toList().subList(1, numbers.size) + numbers.first()).toIntArray()
            else ->
                (numbers.toList()
                    .subList(0, numbers.lastIndex)
                    .toMutableList().apply{
                        add(0, numbers.last())
                    }).toIntArray()
        }
}