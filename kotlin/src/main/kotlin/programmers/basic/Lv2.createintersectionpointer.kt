import kotlin.math.*

class CreateInterSectionPointer {
    fun solution(line: Array<IntArray>): Array<String> {
        val pointerset = mutableSetOf<Pair<Long,Long>>()

        var minx = Long.MAX_VALUE
        var miny = Long.MAX_VALUE
        var maxx = Long.MIN_VALUE
        var maxy = Long.MIN_VALUE
        for(i in 0 until line.size-1){
            for(j in i+1 until line.size){
                var p: Long = (line[i][0]*line[j][1] - line[i][1]*line[j][0]).toLong()
                if(p == 0L) continue

                var x = (line[i][1]*line[j][2].toLong() - line[i][2]*line[j][1].toLong()).toDouble()/p
                var y = (line[i][2]*line[j][0].toLong() - line[i][0]*line[j][2].toLong()).toDouble()/p
                if(x == x.toLong().toDouble() && y == y.toLong().toDouble()){
                    pointerset.add(Pair(x.toLong(),-1*y.toLong()))
                    minx = min(x.toLong(),minx)
                    miny = min(-1*y.toLong(), miny)
                    maxx = max(x.toLong(), maxx)
                    maxy = max(-1*y.toLong(), maxy)
                }
            }
        }

        maxy-=miny
        maxx-=minx

        val answer = Array(maxy.toInt()+1, {CharArray(maxx.toInt()+1,{'.'})})
        pointerset.map{elem ->
            answer[(elem.second-miny).toInt()][(elem.first-minx).toInt()] = '*'
        }

        return answer.map{ arr ->
            arr.joinToString("")
        }.toTypedArray()
    }
}