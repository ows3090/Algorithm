package programmers.dfs

import kotlin.math.*

class MaxExpression {

    val operation = charArrayOf('-','+','*')
    var answer: Long = 0

    fun getNum(a: Long, b: Long, op: Char): Long{
        when(op){
            '-' -> return a-b
            '+' -> return a+b
            else -> return a*b
        }
    }

    fun getresult(cnt: Int, check: BooleanArray, numList: List<Long>, opList: List<Char>){
        if(cnt == 3){
            answer = max(answer, abs(numList.first()))
        }else{
            for(i in 0 until 3){
                if(!check[i]){
                    check[i] = true
                    val tempNumList = numList.toMutableList()
                    val tempOpList = opList.toMutableList()

                    var idx = 0
                    for(j in 0 until tempOpList.size){
                        if(tempOpList.get(j) == operation.get(i)){
                            val result = getNum(
                                tempNumList.get(j-idx),
                                tempNumList.get(j+1-idx),
                                operation.get(i)
                            )
                            tempNumList.removeAt(j-idx)
                            tempNumList.set(j-idx, result)
                            idx++
                        }
                    }

                    getresult(cnt+1, check,tempNumList.toList(),tempOpList.filter{it != operation.get(i)})
                    check[i] = false
                }
            }
        }
    }

    fun solution(expression: String): Long {
        val numList = mutableListOf<Long>()
        val opList = mutableListOf<Char>()

        val sb = StringBuilder()
        for(exp in expression){
            if(exp in charArrayOf('-','*','+')){
                numList.add(sb.toString().toLong())
                opList.add(exp)
                sb.clear()
            }else{
                sb.append(exp)
            }
        }
        numList.add(sb.toString().toLong())
        getresult(0, BooleanArray(3), numList.toList(), opList.toList())

        return answer
    }
}