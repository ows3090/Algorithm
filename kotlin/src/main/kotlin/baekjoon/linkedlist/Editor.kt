package baekjoon.linkedlist

import java.util.*

class Editor {
    fun solution(){
        val str = readLine()!!
        val num = readLine()!!.toInt()

        var result = LinkedList(str.toList())
        var iter = result.listIterator()
        while(iter.hasNext()) iter.next()

        for(i in 0 until num){
            val input = readLine()!!.split(" ").map{ it.toCharArray().first()}
            if(input.first() == 'P'){
                iter.add(input.last())
            }else if(input.first() == 'L'){
                if(iter.hasPrevious()) iter.previous()
            }else if(input.first() == 'D'){
                if(iter.hasNext()) iter.next()
            }else{
                if(iter.hasPrevious()){
                    iter.previous()
                    iter.remove()
                }
            }
        }
        println(result.toCharArray())
    }
}