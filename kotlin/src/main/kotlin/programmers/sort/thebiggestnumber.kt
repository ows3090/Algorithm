class TheBiggestNumber {
    fun solution(numbers: IntArray): String {
        if(numbers.filter{it != 0}.size == 0) return "0"
        var arr = numbers.sortedWith(
            Comparator { a,b ->
                when{
                    "$a$b" > "$b$a" -> -1
                    "$a$b" < "$b$a" -> 1
                    else -> 0
                }
            }
        )
        return arr.joinToString("")
    }

    fun solution2(numbers: IntArray): String {
        if (numbers.all { it == 0 }) return "0"
        val nums = numbers.sortedWith(
            Comparator { a,b ->
                when {
                    "$a$b" > "$b$a" -> -1
                    "$a$b" < "$b$a" -> 1
                    else -> 0
                }
            }
        )

        return nums.joinToString("")
    }
}