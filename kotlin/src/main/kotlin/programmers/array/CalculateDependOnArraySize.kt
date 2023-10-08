package programmers.array

class CalculateDependOnArraySize {
    fun solution(arr: IntArray, n: Int): IntArray =
        arr.mapIndexed { index, num ->
            if((arr.size%2==0 && index%2 == 1) || (arr.size%2==1 && index%2 == 0)){
                num + n
            } else {
                num
            }
        }.toIntArray()
}