package programmers.`brute-force`

import kotlin.math.*

class StringCompression {
    fun solution(s: String): Int {
        var answer = 1000

        if(s.length == 1) return 1
        for(len in 1..(s.length/2)){
            var result = StringBuilder()
            var str = ""
            var cnt = 1
            var idx = 0

            for(j in 0..s.length-len step len){
                if(str == s.substring(j, j+len)){
                    cnt++
                }else{
                    if(cnt == 1) result.append(str)
                    else result.append("$cnt$str")
                    str = s.substring(j, j+len)
                    cnt = 1
                }
                idx = j+len
            }

            if(cnt == 1) result.append(str)
            else result.append("$cnt$str")

            for(j in idx until s.length){
                result.append(s[j])
            }

            answer = min(answer, result.length)

        }

        return answer
    }
}