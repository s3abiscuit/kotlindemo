val numbers: IntRange = 1..10

val i1 = numbers.iterator()
while (i1.hasNext()) {
    print("${i1.next()}, ")
}
println()

for (e in numbers) {
    print("$e, ")
}
println()

val strings: ClosedRange<String> = "hell".."help"
operator fun ClosedRange<String>.iterator() = object : Iterator<String> {
    val next = StringBuilder(start)
    val last = endInclusive

    override fun hasNext(): Boolean {
        return next.toString() <= last
    }

    override fun next(): String {
        val result = next.toString()
        val lastChar = next.last()
        next.setCharAt(next.length - 1, lastChar + 1)
        return result
    }
}

val i2 = strings.iterator()
while (i2.hasNext()) {
    print("${i2.next()}, ")
}
println()

for (i in strings) {
    print("${i}, ")
}

/*
1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
hell, helm, heln, helo, help,
hell, helm, heln, helo, help,
*/