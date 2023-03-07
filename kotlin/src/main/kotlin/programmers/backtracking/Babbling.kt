package programmers.backtracking

class Babbling {
    val list = listOf("aya", "ye","woo","ma")

    fun solution(babbling: Array<String>): Int = babbling.count{ str ->
        var idx = 0
        loop@while(idx < str.length){
            for(item in list){
                if(idx + item.length > str.length) continue
                if(str.substring(idx, idx + item.length) == item){
                    idx +=item.length
                    continue@loop
                }
            }
            return@count false
        }
        return@count true
    }
}