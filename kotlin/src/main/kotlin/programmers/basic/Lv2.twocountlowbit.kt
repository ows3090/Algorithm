package programmers.basic

import kotlin.math.*

class TwoCountLowBit{
    fun solution(numbers: LongArray): LongArray {
        var answer = mutableListOf<Long>()

        for(number in numbers){
            var list = mutableListOf<Long>()
            var temp = number

            if(temp == 0L){
                answer.add(1)
                continue
            }

            var find = false
            while(temp>0){
                if(!find && temp%2 == 0L){
                    if(list.size == 0){
                        list.add(1)
                    }else{
                        list[list.size-1] = 0
                        list.add(1)
                    }
                    find = true
                    temp/=2
                    continue
                }

                list.add(temp%2)
                temp/=2
            }
            if(!find && list.size > 0){
                list[list.size-1] = 0
                list.add(1)
            }

            var ans = list.foldIndexed(0L){index, acc, element ->
                acc + element*(2.0).pow(index).toLong()
            }
            answer.add(ans)
        }
        return answer.toLongArray()
    }
}
