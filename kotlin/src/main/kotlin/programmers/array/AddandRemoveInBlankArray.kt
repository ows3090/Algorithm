package programmers.array

class AddandRemoveInBlankArray {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        val answer = mutableListOf<Int>()
        var idx = 0
        while(idx < arr.size){
            if(flag[idx]) {
                (0 until (arr[idx] * 2)).forEach {
                    answer.add(arr[idx])
                }
            } else {
                (0 until arr[idx]).forEach{
                    answer.removeLast()
                }
            }
            idx++
        }

        return answer.toIntArray()
    }
}