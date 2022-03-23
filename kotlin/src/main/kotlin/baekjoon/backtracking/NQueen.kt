package baekjoon.backtracking

class NQueen {
    val default = 50
    var total = 0

    fun recur(num: Int, cnt: Int, arr: Array<Int>, leftarr: Array<Int>, rightarr: Array<Int>) {
        if(num == cnt){
            total++
        }else{
            for(i in 0 until num){
                if(i !in arr){
                    if(cnt+i !in leftarr){
                        if(cnt-i !in rightarr){
                            arr[cnt] = i
                            leftarr[cnt] = cnt+i
                            rightarr[cnt] = cnt-i
                            recur(num, cnt+1, arr, leftarr, rightarr)
                            arr[cnt] = default
                            leftarr[cnt] = default
                            rightarr[cnt] = default
                        }
                    }
                }
            }
        }
    }

    fun main() = with(System.`in`.bufferedReader()) {
        val num = readLine().toInt()
        recur(num, 0, Array(num,{default}), Array(num,{default}),Array(num,{default}))
        println(total)
    }
}