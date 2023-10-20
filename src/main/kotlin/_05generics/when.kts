fun <T : AutoCloseable> useAndClose(input: T) {
    input.close()
}

val writer = java.io.StringWriter()
writer.append("hello ")
useAndClose(writer)
println(writer)

fun <T> useAndClose1(input: T) where T : AutoCloseable, T : Appendable {
    input.append("there")
    input.close()
}

val writer1 = java.io.StringWriter()
writer1.append("hello ")
useAndClose1(writer1)
println(writer1)

/**
hello
hello there
 */
