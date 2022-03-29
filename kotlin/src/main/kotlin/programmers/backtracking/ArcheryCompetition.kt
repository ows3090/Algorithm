package programmers.backtracking

class ArcheryCompetition {
    var answer = Array(11,{0})
    var sum = -1

    fun getresult(info: IntArray, arr: Array<Int>, cnt: Int, idx: Int){
        if(cnt == 0){
            var apeach = 0
            var ryan = 0

            for(i in 0..10){
                if(info[i] == 0 && arr[i] == 0) continue

                if(info[i] >= arr[i]){
                    apeach+=(10-i)
                }else{
                    ryan+=(10-i)
                }
            }

            if(ryan > apeach){
                if(ryan-apeach > sum){
                    sum =ryan-apeach

                    for(i in 0..10){
                        answer[i] = arr[i]
                    }
                }
            }

        }else{
            if(idx >= 0){
                for(i in cnt downTo 0){
                    arr[idx] = i
                    getresult(info, arr, cnt-i, idx-1)
                }
            }
        }
    }

    fun solution(n: Int, info: IntArray): IntArray {
        getresult(info, Array(11,{0}), n,10)
        return if(answer.all{ it == 0 }) intArrayOf(-1) else answer.toIntArray()
    }
}