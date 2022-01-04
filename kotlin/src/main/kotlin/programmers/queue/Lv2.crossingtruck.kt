class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        // data class를 정의하여도 무방
        // LinkedList constuctor 매개변수는 Collection
        var q = mutableListOf<IntArray>()
        var idx = 0
        var sum = 0
        while(answer>=0){
            if(idx == truck_weights.size) break

            for(arr in q) arr[1]++
            if(q.size > 0 && q[0][1] == bridge_length){
                sum-=q[0][0]
                q.removeAt(0)
            }

            if(sum + truck_weights[idx] <= weight){
                sum+=truck_weights[idx]
                q.add(intArrayOf(truck_weights[idx], 0))
                idx++
            }
            answer++
        }
        answer+=bridge_length
        return answer
    }
}