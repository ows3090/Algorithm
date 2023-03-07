package programmers.basic

class NextNumber {
    fun solution(common: IntArray): Int = if(common[2] - common[1] == common[1] - common[0]){
        common.last() + common[2] - common[1]
    }else{
        common.last()*(common[2]/common[1])
    }
}