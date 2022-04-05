package programmers.floyd
import kotlin.math.*

class SharedTaxiFare {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = 30000001

        var dist = Array(n+1,{Array(n+1,{30000001})})
        for(fare in fares){
            dist[fare[0]][fare[1]] = min(dist[fare[0]][fare[1]],fare[2])
            dist[fare[1]][fare[0]] = min(dist[fare[1]][fare[0]],fare[2])
        }

        for(k in 1..n){
            for(i in 1..n){
                for(j in 1..n){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j]
                    }
                }
            }
        }

        for(i in 1..n) dist[i][i] = 0

        for(i in 1..n){
            answer = min(answer, dist[s][i] + dist[i][a] + dist[i][b])
        }

        return answer
    }

}