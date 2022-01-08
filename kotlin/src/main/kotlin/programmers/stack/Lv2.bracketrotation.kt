package programmers.stack

import java.util.*

class BracketRotation {
    fun solution(s: String): Int {
        var answer = 0
        var arr = s.toMutableList()
        var map = mapOf(']' to '[', ')' to '(', '}' to '{')

        for(i in 0 until arr.size){
            var check = true
            var s = Stack<Char>()
            for(ch in arr){
                if(s.size == 0 && ch in charArrayOf(']',')','}')){
                    check = false
                    break
                }

                if(ch in charArrayOf('[','(','{')){
                    s.add(ch)
                }else{
                    if(s.peek() == map[ch]){
                        s.pop()
                    }
                }
            }

            if(s.size == 0 && check){
                answer++
            }
            arr.add(arr[0])
            arr.removeAt(0)
        }
        return answer
    }
}