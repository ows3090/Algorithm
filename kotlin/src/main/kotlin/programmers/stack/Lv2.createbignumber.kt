import java.util.*

fun solution(number: String, k: Int): String {
    var answer = ""

    var count = 0
    var s = Stack<Char>()
    s.push(number[0])

    for (i in 1 until number.length) {
        if (count == k) {
            answer = number.substring(i)
            break
        }

        var check = false
        while (s.isNotEmpty() && count < k) {
            if (s.peek().toString().toInt() >= number[i].toString().toInt()) {
                s.add(number[i])
                check = true
                break
            } else {
                count++
                s.pop()
            }
        }

        if (!check) {
            s.add(number[i])
        }
    }

    while (count < k) {
        s.pop()
        count++
    }

    while (s.isNotEmpty()) {
        answer = s.peek() + answer
        s.pop()
    }

    return answer
}