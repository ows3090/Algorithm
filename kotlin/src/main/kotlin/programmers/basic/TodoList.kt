package programmers.basic

class TodoList {
    fun solution(todo_list: Array<String>, finished: BooleanArray): Array<String> =
        todo_list.filterIndexed { index, todo ->
            !finished[index]
        }.toTypedArray()
}