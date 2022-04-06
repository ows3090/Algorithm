package programmers.dp

class RunFar {
    fun solution(n: Int): Long {
        var answer: Long = 0
        var arr =
                return when(n){
                    1 -> return 1
                    2 -> return 2
                    else -> {
                        val arr = Array(n+1,{0L})
                        arr[1] = 1
                        arr[2] = 2
                        for(i in 3..n){
                            arr[i] = (arr[i-1] + arr[i-2])%1234567
                        }

                        return arr[n]
                    }
                }
    }
}