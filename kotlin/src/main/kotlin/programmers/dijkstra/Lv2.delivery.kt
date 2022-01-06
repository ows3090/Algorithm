package programmers.dijkstra

import java.util.*


class Delivery {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var arr = Array(N+1){mutableMapOf<Int,Int>()}
        var dist = IntArray(N+1){Int.MAX_VALUE}

        for(elem in road){
            var a = elem[0]
            var b = elem[1]
            var cost = elem[2]

            if(arr[a].containsKey(b)){
                if(arr[a].get(b)!! > cost){
                    arr[a].put(b, cost)
                }
            }else{
                arr[a].put(b, cost)
            }

            if(arr[b].containsKey(a)){
                if(arr[b].get(a)!! > cost){
                    arr[b].put(a, cost)
                }
            }else{
                arr[b].put(a, cost)
            }
        }

        var q = PriorityQueue(Comparator<Pair<Int,Int>>{a,b ->
            when{
                a.first != b.first -> when{
                    a.first > b.first -> 1
                    else -> -1
                }
                else -> when{
                    a.second > b.second -> 1
                    else -> -1
                }
            }
        })
        q.add(Pair(0,1))
        dist[1] = 0

        while(q.isNotEmpty()){
            var cur = q.poll()

            if(cur.first!=dist[cur.second]) continue

            for(elem in arr[cur.second]){
                var nxt = elem.key
                var cost = elem.value

                if(dist[cur.second] + cost < dist[nxt]){
                    dist[nxt] = dist[cur.second] + cost
                    q.add(Pair(dist[nxt], nxt))
                }
            }
        }

        return dist.filter{it <= k}.size
    }
}