package programmers.basic

class Parallel {
    fun solution(dots: Array<IntArray>): Int =
        if(arrayOf(arrayOf(0,1,2,3),arrayOf(0,2,1,3),arrayOf(0,3,1,2)).any{ arr ->
                var d1 = (dots[arr.get(0)][0] - dots[arr.get(1)][0]) / (dots[arr.get(0)][1] - dots[arr.get(1)][1]).toDouble()
                var d2 = (dots[arr.get(2)][0] - dots[arr.get(3)][0]) / (dots[arr.get(2)][1] - dots[arr.get(3)][1]).toDouble()
                d1 == d2
            }) 1 else 0
}