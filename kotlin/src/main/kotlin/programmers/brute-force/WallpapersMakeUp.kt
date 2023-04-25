package programmers.`brute-force`

import kotlin.math.max
import kotlin.math.min

class WallpapersMakeUp {
    fun solution(wallpaper: Array<String>): IntArray =
        intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE, Int.MIN_VALUE).apply{
            wallpaper.forEachIndexed{ index, paper ->
                paper.forEachIndexed{ pindex, ch ->
                    if(ch == '#'){
                        set(0, min(get(0), index))
                        set(1, min(get(1), pindex))
                        set(2, max(get(2), index + 1))
                        set(3, max(get(3), pindex + 1))
                    }
                }
            }
        }
}