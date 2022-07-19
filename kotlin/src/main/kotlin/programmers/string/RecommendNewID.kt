package programmers.string

class RecommendNewID {
    fun solution(new_id: String): String {
        var answer: String = ""

        val strbuilder = StringBuilder()
        new_id.toLowerCase().forEach {
            if (it.isLetter() || it.isDigit() || it in arrayOf('-', '_', '.')) {
                if (!(it == '.' && strbuilder.isNotEmpty() && strbuilder.get(strbuilder.length - 1) == '.')) {
                    strbuilder.append(it)
                }
            }
        }

        if (strbuilder.get(0) == '.') strbuilder.deleteCharAt(0)
        if (strbuilder.isNotEmpty() && strbuilder.get(strbuilder.length - 1) == '.') strbuilder.deleteCharAt(strbuilder.length - 1)
        if (strbuilder.isEmpty()) strbuilder.append('a')

        if (strbuilder.length >= 16) {
            val result = strbuilder.substring(0, 15)
            if (result.get(result.length - 1) == '.') return result.substring(0, 14)
            return result
        } else if (strbuilder.length == 2) {
            strbuilder.append(strbuilder.get(strbuilder.length - 1))
        } else if (strbuilder.length == 1) {
            strbuilder.append(strbuilder.get(strbuilder.length - 1))
            strbuilder.append(strbuilder.get(strbuilder.length - 1))
        }

        return strbuilder.toString()
    }

    fun solution2(new_id: String): String = new_id.toLowerCase()
            .filter { it.isLetter() || it.isDigit() || it in arrayOf('-', '_', '.') }
            .replace("[.]+".toRegex(), ".")
            .removePrefix(".")
            .removeSuffix(".")
            .let { if (it.isEmpty()) "a" else it }
            .let { if (it.length >= 16) it.substring(0, 15).removeSuffix(".") else it }
            .let {
                if (it.length == 1) it + it + it
                else if (it.length == 2) it + it.last()
                else it
            }

}