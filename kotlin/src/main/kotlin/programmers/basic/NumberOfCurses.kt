package programmers.basic

class NumberOfCurses {
    fun isPossible(n: Int): Boolean{
        return n.toString().all{it != '3'} && n % 3 != 0
    }

    fun solution(n: Int): Int =
        Array(n+1){0}.apply{
            if(n < 3){
                for(i in 1..n) set(n,n)
            }
            else{
                set(1,1)
                set(2,2)
                if(n >= 3){
                    for(i in 3 until n+1){
                        var cur = get(i-1) + 1
                        while(isPossible(cur).not()){
                            cur+=1
                        }
                        set(i, cur)
                    }
                }
            }
        }.get(n)
}