import kotlin.math.*

class Fatigue {
    var answer: Int = 0
    fun permutation(k: Int,check: Array<Boolean>, dungeons: Array<IntArray>,item : Array<Int>){
        if(item.size == dungeons.size){
            var tired = k
            var cnt = 0
            for(idx in item){
                if(tired >= dungeons.get(idx).first()){
                    tired-=dungeons.get(idx).last()
                    cnt++
                }
            }
            answer = max(answer, cnt)
        }else{
            // Array
            for(i in 0 until dungeons.size){
                if(!check[i]){
                    check[i] = true
                    permutation(k, check, dungeons, item.plus(i))       // Array<Int>.plus(item) -> return Array<Int>
                    check[i] = false
                }
            }
        }
    }

    // Array<Int> vs IntArray => Integer[] vs int[]
    // Wrapper Class
    // Boxing UnBoxing
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        permutation(k,Array<Boolean>(dungeons.size,{false}), dungeons, Array<Int>(0,{0}))
        return answer
    }
}