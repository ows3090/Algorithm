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
}