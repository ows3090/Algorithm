package programmers.bfs

class SafeRegion {
    var dir = arrayOf(
        arrayOf(-1,-1),
        arrayOf(-1,0),
        arrayOf(-1,1),
        arrayOf(0,-1),
        arrayOf(0,0),
        arrayOf(0,1),
        arrayOf(1,-1),
        arrayOf(1,0),
        arrayOf(1,1)
    )

    fun isInside(y: Int, x: Int, n: Int): Boolean{
        return (0 until n).contains(x) && (0 until n).contains(y)
    }

    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0
        var size = board.size
        var position = mutableListOf<Pair<Int,Int>>()

        for(i in 0 until size){
            for(j in 0 until size){
                if(board[i][j] == 1){
                    position.add(i to j)
                }
            }
        }

        position.forEach{ p ->
            for(i in 0 until 9){
                val dy = p.first + dir[i][0]
                val dx = p.second + dir[i][1]

                if(isInside(dy, dx, size)){
                    board[dy][dx] = 1
                }
            }
        }

        return board.fold(0){ acc, arr ->
            acc + arr.count{ it == 0}
        }
    }
}