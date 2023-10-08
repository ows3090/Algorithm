package programmers.basic

class SelectNumberOfRandom {
    fun solution(arr: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val s = arr.toSet()
        if(s.size >= k){
            return s.toList().subList(0, k).toIntArray()
        } else {
            return (s.toList() + List(k - s.size){-1}).toIntArray()
        }
    }
}