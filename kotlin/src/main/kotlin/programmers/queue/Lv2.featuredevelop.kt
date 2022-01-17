package programmers.queue

import java.util.*
import kotlin.math.*

class FeatureDevelop {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var q = LinkedList<Int>().apply{
            progresses.forEachIndexed{ index, i ->
                add(ceil((100-i).toDouble()/speeds[index]).toInt())
            }
        }

        var time = 0
        while(q.isNotEmpty()){
            var top = q.peek()

            if(top>time){
                time = top
            }else{
                q.poll()
                var cnt = 1
                while(q.isNotEmpty() && q.peek() <= top){
                    cnt++
                    q.poll()
                }
                answer.add(cnt)
            }
        }

        return answer.toIntArray()
    }
}