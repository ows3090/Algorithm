package programmers.basic

class ThreeDivider {
    fun solution(myStr: String): Array<String> {
        val result = myStr.replace("a",",")
            .replace("b",",")
            .replace("c",",")

        val answer = result.split(",")
            .toMutableList()
            .filter{it.isNotEmpty()}
        return if(answer.isEmpty()) arrayOf("EMPTY") else answer.toTypedArray()
    }
}