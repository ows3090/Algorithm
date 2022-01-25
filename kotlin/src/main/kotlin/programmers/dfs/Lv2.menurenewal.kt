package programmers.dfs

class MenuRenewal {
    val menu = mutableMapOf<Int,Int>()
    val map = mutableMapOf<String,Int>()

    fun getresult(str: String, idx: Int, course: IntArray, s: String){
        if(idx == str.length){
            if(s.length in course){
                if(map.contains(s)){
                    map.put(s, map[s]!! + 1)

                    if(menu.contains(s.length)){
                        if(menu[s.length]!! < map[s]!!){
                            menu[s.length] = map[s]!!
                        }
                    }else{
                        menu.put(s.length, map[s]!!)
                    }

                }else{
                    map.put(s, 1)
                }
            }
        }else{
            getresult(str, idx+1, course, s+str[idx])
            getresult(str, idx+1, course, s)
        }
    }

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = mutableListOf<String>()
        var list = orders.map{
            it.toCharArray().sorted().joinToString("")
        }

        for(str in list){
            getresult(str, 0, course, "")
        }

        val filtermap = map.filter{it.value>=2}
        for(elem in menu){
            for(data in filtermap){
                if(data.key.length == elem.key && data.value == elem.value){
                    answer.add(data.key)
                }
            }
        }

        return answer.sorted().toTypedArray()
    }
}