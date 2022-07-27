package programmers.basic

class LeastCommonMultiple {
    fun getLCM(a: Int, b: Int) : Int{
        var x = a
        var y = b

        while(x%y != 0){
            var r = x%y
            x = y
            y = r
        }
        return a*b/y
    }

    fun solution(arr: IntArray): Int {
        var answer = 1

        arr.forEach{
            answer = getLCM(answer, it)
        }

        return answer
    }
}