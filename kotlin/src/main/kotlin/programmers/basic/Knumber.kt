package programmers.basic

class Knumber {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.mapIndexed { index, i ->
            array.toList()
                    .subList(commands[index][0] - 1, commands[index][1])
                    .sorted()
                    .get(commands[index][2] - 1)
        }.toIntArray()
    }
}