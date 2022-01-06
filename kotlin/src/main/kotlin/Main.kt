import java.util.*

fun main(){
    var pq = PriorityQueue<Pair<Int,Int>>()

    pq.add(Pair(1,2))
    pq.add(Pair(100,2))
    pq.add(Pair(2345,2))
    pq.add(Pair(90,123))
    pq.add(Pair(90,2))
    pq.add(Pair(90,12))

    while(pq.isNotEmpty()){
        println(pq.poll())
    }
}

