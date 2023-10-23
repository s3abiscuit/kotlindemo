//fun invokeTwo(
inline fun invokeTwo(
    n: Int,
    action1: (Int) -> Unit,
//    action2: (Int) -> Unit
    noinline action2: (Int) -> Unit
): (Int) -> Unit {

    println("enter invokeTwo $n")

    action1(n)
    action2(n)

    println("exit invokeTwo $n")
    return { _: Int -> println("lambda returned from invokeTwo") }
}

fun callInvokeTwo() {
    invokeTwo(1, { i -> report(i) }, { i -> report(i) })
}

callInvokeTwo()

fun report(n: Int) {
    println("")
    print("called with $n, ")

    val stackTrace = RuntimeException().getStackTrace()

    println("Stack depth: ${stackTrace.size}")
    println("Partial listing of the stack:")
    stackTrace.take(3).forEach(::println)
}

/*
enter invokeTwo 1

called with 1, Stack depth: 34
Partial listing of the stack:
Inline.report(inline.kts:27)
Inline.callInvokeTwo(inline.kts:18)
Inline.<init>(inline.kts:21)

called with 1, Stack depth: 36
Partial listing of the stack:
Inline.report(inline.kts:27)
Inline$callInvokeTwo$2.invoke(inline.kts:18)
Inline$callInvokeTwo$2.invoke(inline.kts:18)
exit invokeTwo 1
*/

/* no inline output
enter invokeTwo 1

called with 1, Stack depth: 37
Partial listing of the stack:
Inline.report(inline.kts:26)
Inline$callInvokeTwo$1.invoke(inline.kts:17)
Inline$callInvokeTwo$1.invoke(inline.kts:17)

called with 1, Stack depth: 37
Partial listing of the stack:
Inline.report(inline.kts:26)
Inline$callInvokeTwo$2.invoke(inline.kts:17)
Inline$callInvokeTwo$2.invoke(inline.kts:17)
exit invokeTwo 1
*/
