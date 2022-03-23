fun recur(num: Int, cnt: Int, arr: Array<Int>) {
    if(arr.size == cnt){
        arr.forEach { print("$it ") }
        println()
    }else{
        for(i in 1..num){
            if(i !in arr){
                recur(num, cnt, arr+ arrayOf(i))
            }
        }
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ")
    recur(input.first().toInt(), input.last().toInt(), arrayOf())
}


