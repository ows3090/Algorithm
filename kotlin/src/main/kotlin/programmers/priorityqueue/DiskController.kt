package programmers.priorityqueue

import java.util.*

class DiskController {
    fun solution(job: Array<IntArray>): Int {
        val jobs = job.sortedWith(compareBy({it.get(0)}, {it.get(1)})).map{ it.toList()}
        var cur = jobs.get(0)[0] + jobs.get(0)[1]
        var answer = jobs.get(0)[1]
        var idx = 1

        val pq = PriorityQueue<Pair<Int,Int>>(compareBy({it.second}, {it.first}))
        while(idx < jobs.size){
            val nxt = jobs[idx][0]

            if(nxt <= cur){
                pq.add(Pair(jobs[idx][0],jobs[idx][1]))
                idx++
            }else{
                val request = pq.poll()
                if(request == null){
                    cur = jobs[idx][0] + jobs[idx][1]
                    answer+=jobs[idx][1]
                    idx++
                }else{
                    answer+=(cur - request.first + request.second)
                    cur += request.second
                }
            }
        }

        while(pq.isNotEmpty()){
            val request = pq.poll()
            answer += (cur - request.first + request.second)
            cur+=request.second
        }

        return answer/jobs.size
    }
}