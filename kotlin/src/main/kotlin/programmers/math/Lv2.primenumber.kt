package programmers.math

import kotlin.math.*

class PrimeNumber {
    var answer: Int = 0

    fun isPrime(n: Int) : Boolean{
        if(n == 1) return false
        else return (2..sqrt(n.toDouble()).toInt()).all{
            n%it != 0
        }
        return true
    }

    fun solution(n: Int, k: Int): Int {
        var num = n
        val str = StringBuilder()

        while(num>0){
            val r = num%k
            num/=k
            if(r == 0){
                if(str.length > 0 && isPrime(str.toString().reversed().toInt())){
                    answer++
                }
                str.clear()
            }else{
                str.append(r)
            }
        }

        if(str.length>0 && isPrime(str.toString().reversed().toInt())){
            answer++
        }

        return answer
    }
}