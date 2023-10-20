fun nofluff() {
    println("nofluff called...")
    throw RuntimeException("oops")
}

println("not in a function, calling nofluff")

try {
    nofluff()
} catch (ex: Exception) {
    val stackTrace = ex.getStackTrace()
    println(stackTrace[0])
    println(stackTrace[1])
}

/*
not in a function, calling nofluff
nofluff called...
Standalone.nofluff(standalone.kts:4)
Standalone.<init>(standalone.kts:10)
 */