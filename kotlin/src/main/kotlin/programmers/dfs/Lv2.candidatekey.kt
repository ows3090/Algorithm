package programmers.dfs

class CandidateKey {
    var answer = 0
    var keylist = mutableListOf<IntArray>()

    fun dfs(idx: Int, cnt: Int, arr: IntArray, relation: Array<Array<String>>){
        if(idx> relation[0].size) return
        if(cnt == arr.size){
            var check = true
            var list = mutableListOf<String>()

            for(i in 0 until relation.size){
                var str = StringBuilder()
                for(j in arr){
                    str.append(relation[i][j])
                    str.append("-")
                }

                if(list.contains(str.toString())){
                    check = false
                    break
                }
                list.add(str.toString())
            }

            if(check){
                var count = keylist.filter{ list ->
                    list.filter{ !arr.contains(it)}.size == 0
                }.size

                if(count == 0) keylist.add(arr)
            }
        }else{
            dfs(idx+1, cnt, arr+intArrayOf(idx), relation)
            dfs(idx+1, cnt, arr, relation)
        }
    }

    fun solution(relation: Array<Array<String>>): Int {
        for(i in 0..relation[0].size){
            dfs(0, i, intArrayOf(), relation)
        }
        return keylist.size
    }
}