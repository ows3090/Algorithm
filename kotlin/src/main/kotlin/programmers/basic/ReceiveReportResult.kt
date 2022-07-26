package programmers.basic

class ReceiveReportResult {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size)
        val id_report_set = mutableMapOf<String, Set<String>>().apply {
            id_list.forEach {
                put(it, setOf<String>())
            }
        }

        report.forEach {
            val str = it.split(" ")
            id_report_set.put(str[0], id_report_set.get(str[0])!! + setOf(str[1]))
        }

        val reported_count = mutableMapOf<String, Int>()
        for (elem in id_report_set) {
            val idset = elem.value
            idset.forEach {
                reported_count.put(it, (reported_count.get(it) ?: 0) + 1)
            }
        }

        id_list.forEachIndexed { index, elem ->
            val idset = id_report_set.get(id_list.get(index))!!
            answer[index] = idset.filter { reported_count.get(it)!! >= k }.size
        }

        return answer
    }

    fun solution2(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
            report.distinct().map { it.split(" ") }
                    .groupBy { it[1] }
                    .map { it.value }
                    .filter { it.size >= k }
                    .flatten()
                    .groupBy { it[0] }
                    .run { id_list.map { get(it)?.size ?: 0 }.toIntArray() }
}