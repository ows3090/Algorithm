import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val num = readLine().toInt()
    val s = Stack<Int>()

    for(i in 0 until num){
        var cmd = readLine()!!.split(" ")
        when(cmd.first()){
            "push" -> {
                s.add(cmd.last().toInt())
            }
            "top" -> {
                if(s.size == 0) println(-1) else println(s.peek())
            }
            "size" -> {
                println(s.size)
            }
            "empty" -> {
                if(s.isEmpty()) println(1) else println(0)
            }
            else -> {
                if(s.size == 0) println(-1) else println(s.pop())
            }
        }
    }
}


