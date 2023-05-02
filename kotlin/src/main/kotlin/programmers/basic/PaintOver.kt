package programmers.basic

class PaintOver {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        val arr = Array(n+1){false}
        section.forEach{ arr[it] = true}
        var idx = section.first()

        while(idx <= n){
            if(arr[idx] == true){
                answer++
                idx += m
            }else{
                idx++
            }
        }

        return answer
    }
}