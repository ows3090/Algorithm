import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val num = readLine().toInt()
    val q = LinkedList<Int>()

    for(i in 0 until num){
        var cmd = readLine()!!.split(" ")
        when(cmd.first()) {
            "push" -> {
                q.add(cmd.last().toInt())
            }
            "pop" -> {
                if(q.size == 0) println(-1) else println(q.poll())
            }
            "size" -> {
                println(q.size)
            }
            "empty" -> {
                if(q.isEmpty()) println(1) else println(0)
            }
            "front" -> {
                if(q.size == 0) println(-1) else println(q.peek())
            }
            "back" -> {
                if(q.size == 0) println(-1) else println(q.peekLast())
            }
        }
    }
}


