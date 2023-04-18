package programmers.math

class DivideMarble {
    fun solution(balls: Int, share: Int): Int {
        var ball = balls
        var sh = share
        var total = 1L
        while((ball >= balls - share  && sh >= 1)){
            if(ball == balls - share){
                total /= sh
                sh--
            }else if(sh == 1){
                total *= ball
                ball--
            }else{
                total *=ball
                if(total % sh == 0L){
                    total /= sh
                    sh--
                }
                ball--
            }
        }
        return total.toInt()
    }
}