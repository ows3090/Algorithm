package programmers.stack

import java.util.*

class CrainToy {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0

        val stackList = List(board.size) { Stack<Int>() }
        board.reverse()

        for (i in 0 until board.size) {
            for (j in 0 until board.size) {
                if (board[i][j] != 0) {
                    stackList.get(j).add(board[i][j])
                }
            }
        }

        val s = Stack<Int>()

        moves.forEach {
            if (stackList.get(it - 1).isNotEmpty()) {
                if (s.isEmpty()) {
                    s.add(stackList.get(it - 1).pop())
                } else {
                    if (s.peek() == stackList.get(it - 1).peek()) {
                        answer += 2
                        stackList.get(it - 1).pop()
                        s.pop()
                    } else {
                        s.add(stackList.get(it - 1).pop())
                    }
                }
            }
        }

        return answer
    }
}