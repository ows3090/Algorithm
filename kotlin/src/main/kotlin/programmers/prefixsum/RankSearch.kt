package programmers.prefixsum

class RankSearch {
    val lan = arrayOf("cpp", "java", "python", "-")
    val type = arrayOf("backend", "frontend", "-")
    val age = arrayOf("junior", "senior", "-")
    val food = arrayOf("chicken", "pizza", "-")

    val map = Array(4, { Array(3, { Array(3, { Array(3, { Array(100001, { 0 }) }) }) }) })

    fun saveInfo(infolist: List<String>, templist: List<String>, idx: Int, cnt: Int) {
        if (idx == cnt) {
            val num = infolist[4].toInt()

            map[lan.indexOf(templist[0])][type.indexOf(templist[1])][age.indexOf(templist[2])][food.indexOf(templist[3])][num]++
        } else {
            saveInfo(infolist, templist + listOf(infolist[idx]), idx + 1, cnt)
            saveInfo(infolist, templist + listOf("-"), idx + 1, cnt)
        }
    }

    fun solution(infos: Array<String>, querys: Array<String>): IntArray {
        var answer = mutableListOf<Int>()


        for (info in infos) {
            val infolist = info.split(" ")
            saveInfo(infolist, listOf(), 0, 4)
        }

        for (i in 0 until 4) {
            for (j in 0 until 3) {
                for (k in 0 until 3) {
                    for (l in 0 until 3) {
                        for (x in 1 until 100001) {
                            map[i][j][k][l][x] += map[i][j][k][l][x - 1]
                        }
                    }
                }
            }
        }

        for (query in querys) {
            val querylist = query.split(" ")
            val arr = map[lan.indexOf(querylist[0])][type.indexOf(querylist[2])][age.indexOf(querylist[4])][food.indexOf(querylist[6])]

            answer.add(arr[100000] - arr[querylist[7].toInt() - 1])
        }

        return answer.toIntArray()
    }
}