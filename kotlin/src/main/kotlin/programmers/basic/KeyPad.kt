package programmers.basic

import java.lang.Math.abs

class KeyPad {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""

        var left = 9
        var right = 11
        numbers.map { if (it == 0) 10 else it - 1 }.forEach { num ->
            if (num in arrayOf(0, 3, 6)) {
                answer = answer + 'L'
                left = num
            } else if (num in arrayOf(2, 5, 8)) {
                answer = answer + 'R'
                right = num
            } else {
                val lrd = abs(left / 3 - num / 3)
                val lcd = abs(left % 3 - num % 3)

                val rrd = abs(right / 3 - num / 3)
                val rcd = abs(right % 3 - num % 3)

                if (lrd + lcd < rrd + rcd) {
                    answer = answer + 'L'
                    left = num
                } else if (lrd + lcd > rrd + rcd) {
                    answer = answer + 'R'
                    right = num
                } else {
                    if (hand == "right") {
                        answer = answer + 'R'
                        right = num
                    } else {
                        answer = answer + 'L'
                        left = num
                    }
                }
            }
        }

        return answer
    }
}