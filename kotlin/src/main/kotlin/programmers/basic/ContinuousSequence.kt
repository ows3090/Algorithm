package programmers.basic

class ContinuousSequence {
    fun solution(elements: IntArray): Int {
        var answer = mutableSetOf<Int>()
        val list = elements.toList() + elements.toList()

        for(i in 1..elements.size){
            for(j in 0..(list.size -i)){
                answer.add(list.subList(j, j+i).sum())
            }
        }

        return answer.size
    }
}