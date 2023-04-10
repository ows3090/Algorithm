package programmers.hash

class RunningRace {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val map = mutableMapOf<String, Int>().apply{
            players.forEachIndexed{ index, player ->
                put(player, index)
            }
        }

        callings.forEach{
            var index = map[it]!!
            val temp = players[index-1]
            map[it] = index - 1
            map[temp] = index
            players[index-1] = players[index]
            players[index] = temp
        }
        return players
    }
}