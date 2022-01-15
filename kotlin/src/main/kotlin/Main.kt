

fun main(){
    var arr = intArrayOf(5,1,3,2,4)
    println(arr.sortedBy { it })


    var cm = arr.sortedWith(Comparator { a,b ->
        when{
            "$a$b" > "$b$a" -> -1
            "$a$b" < "$b$a" -> 1
            else -> 0
        }
    })
}

