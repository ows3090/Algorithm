package programmers.array

import kotlin.math.pow

class MakePowerArraySize {
    fun solution(arr: IntArray): IntArray {
        var check = true
        var num = arr.size
        var cnt = 0
        while(num > 0){
            if(num % 2 == 1 && num > 1) check = false
            num/=2
            cnt++
        }

        if(check) cnt--
        return (arr.toList() +  List((2.0).pow(cnt).toInt() - arr.size){0}).toIntArray()
    }
}