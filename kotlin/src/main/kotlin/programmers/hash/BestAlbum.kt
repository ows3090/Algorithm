package programmers.hash

class BestAlbum{
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        val genremap = mutableMapOf<String,Int>()
        val musics = mutableMapOf<String, MutableList<Pair<Int,Int>>>()
        for(i in 0 until genres.size){
            val genre = genres.get(i)
            val play = plays.get(i)

            if(musics.contains(genre)){
                musics.put(genre, musics.get(genre)!!.apply{ add((Pair(i, play))) } )
                genremap.put(genre, genremap.get(genre)!! + play)
            }else{
                musics.put(genre, mutableListOf(Pair(i, play)))
                genremap.put(genre, play)
            }
        }

        val sortedlist = genremap.map { it }.sortedByDescending{it.value}

        for(elem in sortedlist){
            val key = elem.key
            val countlist = musics.get(key)!!.sortedByDescending{it.second}

            for(i in 0 until countlist.size){
                if(i == 2) break
                answer.add(countlist.get(i).first)
            }
        }

        return answer.toIntArray()
    }

    /**
     * Array.indices : Index List 반환
     * groupBy : 장르가 key가 되어 해당 key들로 그룹핑, 반환 값은 Map<Key, List<Value>>
     * flatten : 리스트 내 리스트에서 사용되는 함수로 모든 리스트의 원소를 더하는 메소드
     */
    fun solution2(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }
                .toList()
                .sortedByDescending { it.second.sumBy { plays[it] } }
                .map { it.second.sortedByDescending { plays[it] }.take(2) }
                .flatten()
                .toIntArray()
    }
}