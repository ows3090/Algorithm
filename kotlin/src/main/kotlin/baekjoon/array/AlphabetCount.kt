package baekjoon.array

class AlphabetCount {
    fun solution() {
        val str = readLine()!!
        var array = MutableList(26, { 0 })
        str.forEach { ch -> array[ch.toInt() - 'a'.toInt()]++ }
        array.forEach {
            print("$it ")
        }
    }
}