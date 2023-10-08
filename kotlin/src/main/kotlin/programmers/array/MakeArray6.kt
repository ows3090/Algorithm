package programmers.array

class MakeArray6 {
    fun solution(arr: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var idx = 0
        while(idx < arr.size) {
            if(answer.isEmpty()){
                answer.add(arr[idx++])
            } else if (answer.last() ==  arr[idx]){
                answer.removeLast()
                idx++
            } else {
                answer.add(arr[idx++])
            }
        }

        return if(answer.isEmpty()) intArrayOf(-1) else answer.toIntArray()
    }
}