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
}