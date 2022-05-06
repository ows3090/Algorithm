package baekjoon.backtracking
import java.lang.Integer.max

class BlackJack {
    var result = 0
    var num = 0

    fun backtracking(list: List<Int>, idx: Int, cnt: Int,sum: Int){
        if(idx >= list.size && cnt<3) return
        if(cnt == 3){
            if(sum <= num){
                result = max(result, sum)
            }
        }else{
            backtracking(list, idx+1, cnt+1, sum+list[idx])
            backtracking(list, idx+1, cnt, sum)
        }
    }

    fun main() = with(System.`in`.bufferedReader()) {
        val input = readLine().split(" ").map { it.toInt() }
        num = input.get(1)

        val list = readLine().split(" ").map { it.toInt() }

        backtracking(list, 0,0, 0)
        println(result)
    }
}