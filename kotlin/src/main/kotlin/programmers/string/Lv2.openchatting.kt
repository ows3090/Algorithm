package programmers.string

class OpenChatting {
    fun solution(records: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        var userInfo = mutableMapOf<String,String>()
        var actionInfo = mutableListOf<Pair<String,String>>()


        for(record in records){
            var info = record.split(" ")
            when(info.get(0)){
                "Enter" -> {
                    userInfo.put(info.get(1), info.get(2))
                    actionInfo.add(Pair(info.get(1),info.get(0)))
                }
                "Leave" -> {
                    actionInfo.add(Pair(info.get(1), info.get(0)))
                }
                "Change" -> {
                    userInfo.put(info.get(1), info.get(2))
                }
            }
        }

        for(action in actionInfo){
            when(action.second){
                "Enter" -> answer.add("${userInfo.get(action.first)}님이 들어왔습니다.")
                "Leave" -> answer.add("${userInfo.get(action.first)}님이 나갔습니다.")
            }
        }

        return answer.toTypedArray()
    }
}