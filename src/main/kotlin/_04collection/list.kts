val names = listOf("Tom", "Jerry", "Spike")
println(names)
for ((index, name) in names.withIndex()) {
    println("position of $name is $index")
}

// contains
println(names.contains("Tom"))
println("Tom" in names)

val names2 = names + "Jackson"
println(names2)

val noJackson = names2 - "Jackson"
println(noJackson)

/**
[Tom, Jerry, Spike]
position of Tom is 0
position of Jerry is 1
position of Spike is 2
true
true
[Tom, Jerry, Spike, Jackson]
[Tom, Jerry, Spike]
 */