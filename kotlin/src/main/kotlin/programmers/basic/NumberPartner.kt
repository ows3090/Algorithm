package programmers.basic

class NumberPartner {
    fun solution(X: String, Y: String): String {
        var answer: String = ""
        val counts = MutableList(10){0}
        val nums = mutableListOf<Int>()

        X.forEach{
            counts[it.toString().toInt()]++
        }

        Y.forEach {
            if(counts[it.toString().toInt()] > 0){
                nums.add(it.toString().toInt())
                counts[it.toString().toInt()]--
            }
        }

        return if(nums.isEmpty()) "-1"
        else if(nums.sum() == 0) "0"
        else nums.sortedDescending().joinToString("")
    }
}