package baekjoon.recursion

class Multiple {
    fun recur(a: Long, b: Long, c: Long): Long {
        if(b == 1L){
            return a%c
        }else{
            val result = recur(a,b/2,c)
            if(b%2 == 0L){
                return ((result%c)*(result%c))%c
            }else{
                return ((((result%c)*(result%c))%c)*a)%c
            }
        }
    }


    fun main() = with(System.`in`.bufferedReader()) {
        val input = readLine().split(" ")
        println(recur(
                input.get(0).toLong(),
                input.get(1).toLong(),
                input.get(2).toLong()
        ))
    }



}