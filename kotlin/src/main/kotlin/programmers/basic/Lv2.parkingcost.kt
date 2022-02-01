package programmers.basic

import kotlin.math.*

class ParkingCost {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer = mutableListOf<Int>()

        val curmap = mutableMapOf<String,Int>()
        val totalmap = mutableMapOf<String,Int>()

        for(record in records){
            val infos = record.split(" ")
            val times = infos[0].split(":")
            val time = times[0].toInt()*60 + times[1].toInt()

            if(curmap.contains(infos[1])){
                val prevtime = curmap[infos[1]]!!
                val totaltime = totalmap[infos[1]] ?: 0
                totalmap.put(infos[1], totaltime + time - prevtime)
                curmap.remove(infos[1])
            }else{
                curmap.put(infos[1],time)
            }
        }

        for(elem in curmap){
            val time = 23*60 + 59
            val prevtime = elem.value
            val totaltime = totalmap[elem.key] ?: 0
            totalmap.put(elem.key, totaltime + time - prevtime)
        }

        for(key in totalmap.keys.sorted()){
            answer.add(
                if(totalmap[key]!! > fees[0]){
                    fees[1] + ceil((totalmap[key]!! - fees[0])/fees[2].toDouble()).toInt()*fees[3]
                }else{
                    fees[1]
                }
            )
        }

        return answer.toIntArray()
    }
}