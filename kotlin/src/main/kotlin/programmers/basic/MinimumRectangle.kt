package programmers.basic

import kotlin.math.*

class MinimumRectangle {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0

        var y = 0
        var x = 0
        for(arr in sizes){
            arr.sort()
            var first = max(y,arr[0])*max(x,arr[1])
            var second = max(y,arr[1])*max(x,arr[0])
            if(first > second){
                answer = second
                y = max(y,arr[1])
                x = max(x,arr[0])
            }else{
                answer = first
                y = max(y,arr[0])
                x = max(x,arr[1])
            }
        }

        return answer
    }
}