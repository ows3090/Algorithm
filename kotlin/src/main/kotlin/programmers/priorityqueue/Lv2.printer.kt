package programmers.priorityqueue

import java.util.*

class Printer {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var q = LinkedList<Int>().apply{
            for(i in 0 until priorities.size){
                add(i)
            }
        }

        var pq = PriorityQueue<Int>(Collections.reverseOrder()).apply{
            for(i in priorities){
                add(i)
            }
        }

        var cnt = 1
        while(q.isNotEmpty()){
            var idx = q.peek()
            var top = pq.peek()

            if(priorities[idx] == top){
                if(idx == location){
                    answer = cnt
                    break
                }

                cnt++
                q.poll()
                pq.poll()
            }else{
                q.poll()
                q.add(idx)
            }
        }

        return answer
    }

    fun solution2(priorities: IntArray, location: Int): Int {
        var answer = 0
        val prior = priorities.sortedByDescending { it }
        var idx = 0
        val q = LinkedList<Pair<Int, Int>>()
        priorities.forEachIndexed { index, i ->
            q.add(i to index)
        }

        while(!q.isEmpty()) {
            val top = q.poll()
            if(prior[idx] == top.first) {
                idx++

                if (top.second == location) {
                    answer = idx
                    break
                }
            } else {
                q.add(top)
            }
        }

        return answer
    }
}