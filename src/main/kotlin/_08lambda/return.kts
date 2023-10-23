fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("invokeWith start")
    action(n)
    println("invokeWith end")
}

fun caller() {
    (1..3).forEach { i ->
        invokeWith(i) {
            println("enter for $it")
            if (it == 2) {
                return@invokeWith
            }
            println("exit for $it")
        }
    }
}

caller()

/*
invokeWith start
enter for 1
exit for 1
invokeWith end
invokeWith start
enter for 2
invokeWith end
invokeWith start
enter for 3
exit for 3
invokeWith end
*/