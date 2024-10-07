import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val priorities = intArrayOf()
    val location: Int = 5
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
                answer = idx + 1
                break
        } else
            q.add(top)
        }
    }

    return answer
}