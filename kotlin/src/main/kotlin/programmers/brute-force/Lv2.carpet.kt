import kotlin.math.*

class Carpet {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf(0,0)
        var mod = sqrt(yellow.toDouble()).toInt()
        while(mod>=1){
            var w = max(yellow/mod, mod)
            var h = min(yellow/mod, mod)

            if((w+2)*(h+2) - yellow == brown){
                answer[0] = w+2
                answer[1] = h+2
                break;
            }
            mod--
        }
        return answer
    }

    fun solution2(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        var sum = brown + yellow


        (1..sqrt(yellow.toDouble()).toInt()).forEach {
            val w = it
            val h = yellow / w

            if ((w+2) * (h+2) == sum) {
                answer = intArrayOf(max(w+2, h+2), min(w+2,h+2))
            }
        }

        return answer
    }
}