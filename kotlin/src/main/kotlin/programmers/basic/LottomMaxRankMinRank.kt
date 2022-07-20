package programmers.basic

class LottomMaxRankMinRank {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        return intArrayOf(
                (7-win_nums.filter{it in lottos}.size - lottos.count{it == 0}).let{
                    if(it > 6) 6 else it
                },
                (7-win_nums.filter{it in lottos}.size).let{
                    if(it > 6) 6 else it
                }
        )
    }
}