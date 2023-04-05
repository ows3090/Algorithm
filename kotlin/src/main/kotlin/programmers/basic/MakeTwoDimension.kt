package programmers.basic

class MakeTwoDimension {
    fun solution(num_list: IntArray, n: Int): Array<IntArray> = Array(num_list.size / n){
        num_list.toList().subList(it*n, (it+1)*n).toIntArray()
    }
}