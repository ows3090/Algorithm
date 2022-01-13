package programmers.greedy

import kotlin.math.*

class JoyStick {
    var answer = Int.MAX_VALUE

    fun getanswer(str: String, name: String, check: BooleanArray, idx: Int,cnt: Int){
        if(str == name){
            answer = min(answer, cnt)
        }else{
            var dist = if(abs(name[idx] - str[idx]) > 13) 26 - abs(name[idx] - str[idx]) else abs(name[idx] - str[idx])
            var newstr = StringBuilder(str)
            newstr.set(idx, name[idx])

            if(newstr.toString() == name){
                answer = min(answer, cnt+dist)
                return;
            }

            for(i in idx+1 until idx+name.length){
                if(!check[(i%name.length)]){
                    check[(i%name.length)] = true
                    getanswer(newstr.toString(), name, check, i%name.length, cnt+dist+(i-idx))
                    check[(i%name.length)] = false
                    break
                }
            }

            for(i in idx+name.length-1 downTo idx+1){
                if(!check[(i%name.length)]){
                    check[(i%name.length)] = true
                    getanswer(newstr.toString(), name, check, i%name.length, cnt+dist+(idx+name.length - i))
                    check[(i%name.length)] = false
                    break
                }
            }
        }
    }

    fun solution(name: String): Int {
        var check = BooleanArray(name.length){false}
        check[0] = true
        getanswer(
            String(CharArray(name.length){'A'}),
            name,
            check,
            0,
            0
        )
        return answer
    }
}