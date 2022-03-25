import java.util.*
import kotlin.collections.ArrayList

fun getParent(arr: Array<Int>, n: Int): Int{
    if(arr[n] == n) return n
    else{
        arr[n] = getParent(arr, arr[n])
        return arr[n]
    }
}

fun isSameParent(arr : Array<Int>, a: Int, b: Int): Boolean{
    val pa = getParent(arr, a)
    val pb = getParent(arr, b)

    return pa == pb
}

fun unionParent(arr: Array<Int>, a: Int, b: Int){
    val pa = getParent(arr, a)
    val pb = getParent(arr, b)

    if(pa > pb){
        arr[pa] = pb
    }else{
        arr[pb] = pa
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map{it.toInt()}

    val arr = Array(input.get(0)+1, {it})
    var visit = Array(input.get(0)+1, {0})

    val pq = PriorityQueue<Pair<Pair<Int,Int>, Int>>(compareBy{it.second})
    for(i in 0 until input.get(1)){
        val info = readLine().split(" ").map { it.toInt() }
        pq.add(Pair(Pair(info[0], info[1]), info[2]))
    }

    var cost = 0
    while(pq.isNotEmpty() && !visit.all{ it == 1} ){
        var peek = pq.poll()
        var a = peek.first.first
        var b = peek.first.second

        if(!isSameParent(arr, a,b)){
            unionParent(arr, a,b)
            cost+=peek.second
            visit[a] = 1
            visit[b] = 1
        }
    }

    println(cost)
}