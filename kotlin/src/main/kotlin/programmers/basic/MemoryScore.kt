package programmers.basic

class MemoryScore {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray =
        photo.map{ names ->
            names.foldIndexed(0){ index, acc, i ->
                acc + if(name.indexOf(i) >= 0) yearning[name.indexOf(i)] else 0
            }
        }.toIntArray()
}