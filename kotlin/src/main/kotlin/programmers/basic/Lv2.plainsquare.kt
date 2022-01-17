package programmers.basic

import kotlin.math.*

class PlainSquare {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = w*h.toLong()
        var total:Long = 0L

        for(i in 1..h){
            var cnt = ceil(w.toDouble()*i/h).toLong() - floor(w.toDouble()*(i-1)/h).toLong()
            total+=cnt
        }
        return answer - total
    }
}