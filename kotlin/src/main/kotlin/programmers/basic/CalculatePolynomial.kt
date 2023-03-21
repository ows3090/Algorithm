package programmers.basic

class CalculatePolynomial {
    fun solution(polynomial: String): String {
        val (first, second) = polynomial.split(" + ").partition{ it.contains('x')}
        var sumX = first.map{
            if(it.replace("x","").length == 0) 1 else it.replace("x","").toInt()
        }.sum()
        var sum = second.map{ it.toInt() }.sum()

        if(sumX == 0) return sum.toString()
        else if(sum == 0){
            if(sumX == 1) return "x"
            return "${sumX.toString()}x"
        }
        else{
            if(sumX == 1) return "x + ${sum}"
            else return "${sumX}x + ${sum}"
        }
    }
}