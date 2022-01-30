package programmers.recursion

class Parenthesis_Conversion {
    fun recur(p: String): String{
        if(p.length == 0) return p
        else{
            var check = true
            var len = 0
            var idx = 0
            do{
                if(p[idx] == '('){
                    len++
                }else{
                    len--
                    if(len < 0) check = false
                }
                idx++
            }while(len!=0)

            if(check){
                return p.substring(0,idx) + recur(p.substring(idx))
            }else{
                var str = StringBuilder()
                for(ch in p.substring(1, idx-1)){
                    if(ch == '(') str.append(')')
                    else str.append('(')
                }

                return "(" + recur(p.substring(idx)) + ")" + str.toString()
            }
        }
    }

    fun solution(p: String): String {
        println("123".substring(3))
        return recur(p)
    }
}