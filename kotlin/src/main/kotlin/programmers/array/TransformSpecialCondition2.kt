package programmers.array

class TransformSpecialCondition2 {
    fun solution(arr: IntArray): Int {
        var answer: Int = 0
        var temp = arr.toList()
        while(true){
            val transArr = temp.map{
                if(it >= 50 && it % 2 == 0) it / 2
                else if(it < 50 && it % 2 == 1) it * 2 + 1
                else it
            }
            if(temp == transArr) break
            answer++
            temp = transArr
        }
        return answer
    }
}