package programmers.basic

class BinaryTransition {
    fun solution(s: String): IntArray {
        var str = s
        var trans = 0
        var cnt = 0


        while(str != "1"){
            trans++
            cnt += str.filter{ it == '0'}.length
            str = Integer.toBinaryString(str.filter{it == '1'}.length)
        }

        return intArrayOf(trans, cnt)
    }
}