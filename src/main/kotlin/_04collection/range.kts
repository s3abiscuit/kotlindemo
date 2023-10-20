val oneToFive: IntRange = 1..5

val fiveToOne: IntProgression = 5.downTo(1) // or (5 downTo 1)

val oneUntilTenStepThree = 1.until(10).step(3) // or (1 until 10 step 3)

val oneToNineWithFilter = (1..9).filter { it % 3 == 0 || it % 5 == 0 }

val aToE: CharRange = 'a'..'e'

val seekHelp: ClosedRange<String> = "hell".."help"

for (number in oneToFive) {
    print("$number, ")
}

println()

for (number in fiveToOne) {
    print("$number, ")
}

println()

for (number in oneUntilTenStepThree) {
    print("$number, ")
}
println()

for (number in oneToNineWithFilter) {
    print("$number, ")
}
println()

for (ch in aToE) {
    print("$ch, ")
}
println()

// can not loop ClosedRange
//for (str in seekHelp) {
//    println(str)
//}

println(seekHelp.contains("help"))

/*
1, 2, 3, 4, 5,
5, 4, 3, 2, 1,
1, 4, 7,
3, 5, 6, 9,
a, b, c, d, e,
true
*/