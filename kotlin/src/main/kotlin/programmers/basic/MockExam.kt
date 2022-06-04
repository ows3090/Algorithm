package programmers.basic

import kotlin.math.*

class MockExam {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf(0,0,0)

        val numarr = arrayOf(
                arrayOf(1,2,3,4,5),
                arrayOf(2,1,2,3,2,4,2,5),
                arrayOf(3,3,1,1,2,2,4,4,5,5)
        )

        for(i in 0..2){
            var score = 0

            for(j in 0 until answers.size){
                score += if(numarr[i][j%numarr[i].size] == answers[j]) 1 else 0
            }
            answer[i] = score
        }

        return answer.mapIndexed{ index, i ->
            if(i == answer.maxOf{it}){
                index+1
            }else{
                -1
            }
        }.filter{ it != -1}.toIntArray()
    }
}