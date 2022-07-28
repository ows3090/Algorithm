package programmers.string

import java.lang.Integer.min

class StringCompression{
    fun solution(s: String): Int {
        var answer = 1000
        if(s.length == 1) return 1

        (1..s.length/2).forEach{
            var count = it + (s.length % it)
            var str = s.substring(0,it)

            var cnt = 1
            for(i in it..(s.length - it) step it){
                if(str == s.substring(i, i+it)){
                    cnt++
                }else{
                    str = s.substring(i, i+it)
                    count+=it
                    count+= if(cnt == 1) 0 else cnt.toString().length
                    cnt = 1
                }
            }

            count+= if(cnt == 1) 0 else cnt.toString().length
            answer = min(count, answer)
        }
        return answer
    }
}