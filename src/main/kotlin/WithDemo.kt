//public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
//    contract {
//        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//    }
//    return receiver.block()
//}
fun main() {
    val list = listOf("apple", "banana", "orange", "pear", "grape")
    val result = with(java.lang.StringBuilder()) {
        append("starting eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("ate all fruits.")
        toString()
    }
    println(result)
}