package programmers.basic

class ControlZ {
    fun solution(s: String): Int {
        val list = s.split(" ")
        val totalSum = list.filter{ it != "Z" }.map{ it.toInt()}.sum()
        val zSum = list.mapIndexed{ index, str -> if(str == "Z") list.get(index-1).toInt() else 0}.sum()
        return totalSum - zSum
    }
}