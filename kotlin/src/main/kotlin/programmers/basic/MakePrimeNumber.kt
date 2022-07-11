package programmers.basic

import java.lang.Math.sqrt

class MakePrimeNumber {
    fun isPrime(n: Int): Boolean = when(n){
        1 -> false
        else -> (2..sqrt(n.toDouble()).toInt()).all{
            n % it != 0
        }
    }

    fun solution(nums: IntArray): Int {
        var answer = 0

        for(i in 0 until nums.size-2){
            for(j in i+1 until nums.size-1){
                for(k in j+1 until nums.size){
                    if(isPrime(nums[i] + nums[j] + nums[k])){
                        answer++
                    }
                }
            }
        }


        return answer
    }
}