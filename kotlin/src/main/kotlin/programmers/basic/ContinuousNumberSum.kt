package programmers.basic

class ContinuousNumberSum {
    fun solution(num: Int, total: Int): IntArray {
        val answer = mutableListOf<Int>()
        answer.add(total/num)

        if(num%2 == 0){
            for(i in 1 until 1 + num/2){
                answer.add(answer.last() + 1)
            }
            for(i in 1 until num/2){
                answer.add(0, answer.first() - 1)
            }
        }else{
            for(i in 1 until 1 + num/2){
                answer.add(answer.last() + 1)
                answer.add(0, answer.first() - 1)
            }
        }
        return answer.toIntArray()
    }
}