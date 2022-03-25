import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map{it.toInt()}

    val visit = Array(input.get(0)+1, {it})
    val vec = Array(input.get(0) +1, { mutableListOf<Pair<Int,Int>>()})

    for(i in 0 until input.get(1)){
        var info = readLine().split(" ").map { it.toInt() }
        vec[info[0]].add(Pair(info[1], info[2]))
        vec[info[1]].add(Pair(info[0], info[2]))
    }

    val pq = PriorityQueue<Pair<Pair<Int,Int>, Int>>(compareBy { it.second })
    for(elem in vec[1]){
        pq.add(Pair(Pair(1, elem.first), elem.second))
    }
    visit[1] = 1

    var cost = 0
    var cnt = 0
    while(pq.isNotEmpty() && cnt < input.get(0) - 1){
        val s = pq.peek().first.first
        val e = pq.peek().first.second
        val c = pq.peek().second
        pq.poll()

        if(visit[e] == 1) continue

        visit[e] = 1
        cnt++
        cost+=c

        for(elem in vec[e]){
            pq.add(Pair(Pair(e, elem.first), elem.second))
        }
    }
    println(cost)
}