import java.util.*
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val num = readLine().toInt()

    val dist = Array(input.get(0) + 1, { 300000 })
    val arr = Array(input.get(0) + 1, { mutableMapOf<Int,Int>() })

    for (i in 0 until input.get(1)){
        val info = readLine().split(" ").map { it.toInt() }

        if(arr[info[0]].contains(info[1])){
            if(arr[info[0]].get(info[1])!! > info[2]){
                arr[info[0]].put(info[1], info[2])
            }
        }else{
            arr[info[0]].put(info[1], info[2])
        }
    }


    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    pq.add(Pair(0, num))
    dist[num] = 0

    while (pq.isNotEmpty()) {
        val peek = pq.poll()
        val cost = peek.first
        val node = peek.second

        if (dist[node] != cost) continue

        for (elem in arr[node]) {
            if(dist[elem.key] > cost + elem.value){
                dist[elem.key] = cost + elem.value
                pq.add(Pair(dist[elem.key], elem.key))
            }
        }
    }

    for(i in 1..input.get(0)){
        if(dist.get(i) == 300000){
            println("INF")
        }else{
            println(dist[i])
        }
    }
}