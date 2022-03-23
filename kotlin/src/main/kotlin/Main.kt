var count = 0

fun backtracking(num: Int, sum: Int, total: Int, idx: Int, arr: IntArray) {
    if(idx == num) {
        if(sum == total) count++
    }else {
        backtracking(num, sum, total+arr[idx], idx+1, arr)
        backtracking(num, sum, total, idx+1, arr)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ")
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    backtracking(
            input.first().toInt(),
            input.last().toInt(),
            0,
            0,
            arr
    )
    if(input.last().toInt() == 0) count--
    println(count)
}


