package programmers.backtracking

class CollectionDictionary {
    val list = mutableSetOf<String>()

    fun getResult(word: String,idx: Int, str: String){
        if(idx == str.length){
            list.add(word)
        }else{
            for(ch in str){
                getResult(word + ch, idx+1, str)
            }
            getResult(word, idx+1, str)
        }
    }

    fun solution(word: String): Int {
        getResult("", 0, "AEIOU")
        return list.toList().sorted().indexOf(word)
    }
}