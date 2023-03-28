package programmers.simulation

class CharacterCoordinate {
    val map = mapOf(
        "left" to arrayOf(-1,0),
        "right" to arrayOf(1,0),
        "up" to arrayOf(0,1),
        "down" to arrayOf(0,-1)
    )

    fun isInside(x: Int, y: Int, a: Int, b: Int) : Boolean =
        0<=a && a<x && 0<=b && b<y

    fun solution(keyinput: Array<String>, board: IntArray): IntArray {
        var answer: IntArray = intArrayOf(board[0] / 2, board[1] / 2)
        keyinput.forEach{
            var x = answer[0]
            var y = answer[1]

            if(isInside(board[0], board[1], x + map[it]!![0], y + map[it]!![1])){
                answer.set(0, x + map[it]!![0])
                answer.set(1, y + map[it]!![1])
            }
        }

        answer.set(0, answer.get(0) - board[0] / 2)
        answer.set(1, answer.get(1) - board[1] / 2)
        return answer
    }
}
