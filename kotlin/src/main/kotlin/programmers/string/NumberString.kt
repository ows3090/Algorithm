package programmers.string

class NumberString{
    fun solution(s: String): Int {
        var answer: String = ""
        val map = mapOf(
                "zero" to 0,
                "one" to 1,
                "two" to 2,
                "three" to 3,
                "four" to 4,
                "five" to 5,
                "six" to 6,
                "seven" to 7,
                "eight" to 8,
                "nine" to 9
        )

        val str = StringBuilder()
        s.forEach{ ch ->
            if(ch.isLetter()){
                str.append(ch)

                if(map.contains(str.toString())){
                    answer = answer+map[str.toString()]!!
                    str.clear()
                }
            }else{
                answer+=ch
            }
        }

        if(str.isNotEmpty()){
            if(str.isNotEmpty()){
                answer = answer + map[str.toString()]!!
            }
        }
        return answer.toInt()
    }

    fun solution2(s: String): Int = s.replace("zero", "0")
            .replace("one","1")
            .replace("two","2")
            .replace("three", "3")
            .replace("four", "4")
            .replace("five","5")
            .replace("six", "6")
            .replace("seven","7")
            .replace("eight","8")
            .replace("nine", "9")
            .toInt()

}