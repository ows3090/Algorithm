package programmers.math

class FiniteNumberValidateion {
    fun isFinite(a: Int): Boolean{
        var num = a
        var check = true
        while(check){
            if(num%2 == 0 && num/2 >= 1){
                num/=2
            }else if(num%5 == 0 && num/5 >= 1){
                num/=5
            }else{
                if(num > 1) check = false
                break
            }
        }
        return check
    }

    fun solution(a: Int, b: Int): Int {
        var na = a
        var nb = b
        while(nb > 0){
            var r = na % nb
            na = nb
            nb = r
        }

        return if(isFinite(b / na)) 1 else 2
    }
}