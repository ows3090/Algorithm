package programmers.string

class Tuple {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()

        var list = mutableListOf<MutableList<Int>>()
        var split_list = s.split("{").filter{ it.isNotBlank()}
        split_list.forEach{ str ->
            val arr = mutableListOf<Int>()
            var sb = StringBuffer()
            str.forEach{ ch ->
                if(ch == ','){
                    if(sb.length != 0){
                        arr.add(sb.toString().toInt())
                        sb = StringBuffer()
                    }
                }else if(ch.toString().toIntOrNull() != null){
                    sb.append(ch)
                }
            }
            if(sb.length != 0) arr.add(sb.toString().toInt())
            list.add(arr)
        }
        list.sortedWith(compareBy{it.size}).forEach{
            it.forEach{ num ->
                if(!answer.contains(num)){
                    answer.add(num)
                }
            }
        }

        return answer.toIntArray()
    }
}