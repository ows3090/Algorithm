package programmers.basic

class SaveSplitedArray {
    fun solution(my_str: String, n: Int): Array<String> {
        var answer = mutableListOf<String>()

        for(i in 0 until my_str.length-n step n){
            answer.add(my_str.substring(i, i+n))
        }
        answer.add(my_str.substring(
            my_str.length - if(my_str.length % n == 0) n else my_str.length % n,
            my_str.length)
        )
        return answer.toTypedArray()
    }
}