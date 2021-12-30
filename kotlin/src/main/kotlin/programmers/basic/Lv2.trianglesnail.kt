class Solution {
    val arr = Array(1000,{Array(1000,{0})})
    val dir = arrayOf(1 to 0, 0 to 1, -1 to -1)
    var d = 0
    fun solution(n: Int): IntArray {
        var answer = mutableListOf<Int>()
        var y = -1
        var x = 0
        var idx = 1

        for(i in n downTo 1){
            for(j in 0 until i){
                y+=dir[d].first
                x+=dir[d].second
                arr[y][x] = idx++
            }
            d = (d+1)%3
        }

        for(i in 0 until n){
            for(j in 0..i){
                answer.add(arr[i][j])
            }
        }

        return answer.toIntArray()
    }
}