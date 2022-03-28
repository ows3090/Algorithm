package programmers.basic

class GetReport {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val result_list = mutableMapOf<String,Int>().apply{
            id_list.forEach{
                put(it, 0)
            }
        }
        val report_list = mutableMapOf<String,MutableSet<String>>()

        for(elem in report){
            val report_id = elem.split(" ").get(0)
            val id = elem.split(" ").get(1)

            if(report_list.contains(id)){
                report_list.get(id)!!.add(report_id)
            }else{
                report_list.put(id, mutableSetOf(report_id))
            }
        }

        for(elem in report_list){
            if(elem.value.size >= k){
                for(e in elem.value){
                    result_list.put(e, (result_list.get(e) ?: 0)+1)
                }
            }
        }


        return result_list.values.toIntArray()
    }
}