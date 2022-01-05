import java.util.*
import kotlin.math.*

class PowerGridTwoDivide {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = n

        for(i in 0 until wires.size){
            val arr = Array(101, {Array(101, {0})})

            for(j in 0 until wires.size){
                if(i == j) continue
                var s = wires[j][0]
                var e = wires[j][1]
                arr[s][e] = 1
                arr[e][s] = 1
            }


            val check = Array(n+1, {false})
            check[0] = true
            val ans = arrayOf(0,0)

            for(j in 1..n){
                if(!check[j]){
                    var cnt = 1
                    check[j] = true
                    val q = LinkedList<Int>()
                    q.add(j)

                    while(!q.isEmpty()){
                        val node = q.poll()

                        for(k in 0 until 101){
                            if(arr[node][k] == 1 && !check[k]){
                                cnt++
                                check[k] = true
                                q.add(k)
                            }
                        }
                    }
                    if(ans[0] == 0) ans[0] = cnt
                    else ans[1] = cnt
                }
            }
            answer = min(answer, abs(ans[0]-ans[1]))
        }

        return answer
    }
}