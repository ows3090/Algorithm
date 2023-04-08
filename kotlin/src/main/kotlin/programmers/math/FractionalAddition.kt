package programmers.math

class FractionalAddition {
    fun getGCD(a: Int, b: Int): Int{
        var c = a
        var d = b
        while(d > 0){
            var r = c % d
            c = d
            d = r
        }
        return c
    }

    fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
        var denom = denom1 * denom2 / getGCD(denom1, denom2)
        var numer = numer1 * denom / denom1 + numer2 * denom / denom2
        var gcd = getGCD(numer, denom)
        return intArrayOf(numer/gcd , denom/gcd)
    }
}