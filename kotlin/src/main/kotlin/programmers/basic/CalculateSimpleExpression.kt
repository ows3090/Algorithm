package programmers.basic

class CalculateSimpleExpression {
    fun solution(binomial: String): Int =
        binomial.split(" ").let {
            when(it[1]) {
                "+" -> it[0].toInt() + it[2].toInt()
                "-" -> it[0].toInt() - it[2].toInt()
                else -> it[0].toInt() * it[2].toInt()
            }
        }
}