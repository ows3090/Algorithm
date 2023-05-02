package programmers.basic

class RoughKeyboard {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray = targets.map{ target ->
        var check = true
        val sum = target.fold(0){ acc, ch ->
            val minIndex = keymap.minByOrNull{
                if(it.indexOf(ch) == -1) Int.MAX_VALUE
                else it.indexOf(ch)
            }?.indexOf(ch) ?: -1

            if(minIndex == -1) check = false
            acc + minIndex + 1
        }
        if(check) sum else -1
    }.toIntArray()
}