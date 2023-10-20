var factor = 2

fun doubleIt(n: Int) = factor * n

factor = 0

println(doubleIt(3))

val message = StringBuilder("_01hello")

//message = StringBuilder("another") // error
message.append("world")

println(message)

/**
 0
 helloworld
 */