package programmers.simulation

class ParkWalk {
    val dir = mapOf("E" to (0 to 1), "N" to (-1 to 0), "W" to (0 to -1), "S" to (1 to 0))

    fun isInside(a: Int, b: Int, y:Int, x: Int) =
        0<= a && a< y && 0<=b && b<x

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var y = park.indexOfFirst{ it.contains("S")}
        var x = park[y].indexOf("S")

        routes.forEach{
            val input = it.split(" ")
            var dy = y
            var dx = x
            for(i in 0 until input.last().toInt()){
                dy += dir[input.first()]!!.first
                dx += dir[input.first()]!!.second

                if(isInside(dy, dx, park.size, park[0].length).not()) break
                if(park[dy][dx] == 'X') break
            }

            if(isInside(dy,dx, park.size, park[0].length) && park[dy][dx] != 'X'){
                y = dy
                x = dx
            }
        }


        return intArrayOf(y, x)
    }
}