import kotlin.math.*

class PrimeNumber {
    var answer: Int = 0

    fun isPrime(n: Long) : Boolean{
        if(n == 1L) return false
        else return (2..sqrt(n.toDouble()).toInt()).all{
            n%it != 0L
        }
    }


    fun solution(n: Int, k: Int): Int {
        var num = n
        val str = StringBuilder()

        while(num>0){
            var r = num%k
            num/=k
            if(r == 0){
                if(str.length > 0){
                    if(isPrime(str.toString().reversed().toLong())){
                        answer++
                    }
                }
                str.clear()
            }else{
                str.append(r)
            }
        }

        if(str.length > 0){
            if(isPrime(str.toString().reversed().toLong())){
                answer++
            }
            str.clear()
        }

        return answer
    }
}