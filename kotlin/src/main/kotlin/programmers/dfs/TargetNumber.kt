package programmers.dfs

class TargetNumber {
    var answer = 0

    fun getresult(numbers: IntArray, checks: IntArray, target: Int){
        if(checks.size == numbers.size){
            val sum = numbers.foldIndexed(0){index, acc, i ->
                acc + i*checks[index]
            }

            if(target == sum) answer++
        }else{
            getresult(numbers, checks + intArrayOf(-1), target)
            getresult(numbers, checks + intArrayOf(1), target)
        }
    }

    fun solution(numbers: IntArray, target: Int): Int {
        getresult(numbers, intArrayOf(), target)
        return answer
    }
}