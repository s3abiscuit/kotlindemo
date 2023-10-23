val names = listOf("Pam", "Pat", "Paul", "Paula")

println(names.find { name: String -> name.length == 4 })
println(names.find { name: String -> name.length == 5 })

fun test(n: Int): (String) -> Boolean {
    return { name: String -> name.length == n }
}

val checkLength5: (String) -> Boolean = { name: String -> name.length == 5 }
val checkLength5_1 = fun(name: String): Boolean { return name.length == 5 }
println(names.find(test(4)))
println(names.find(test(5)))
println(names.find(checkLength5))
println(names.find(checkLength5_1))

var factor = 2

val doubled1 = listOf(1, 2).map { it * factor }
val doubled2 = sequenceOf(1, 2).map { it * factor }

factor = 0

doubled1.forEach { i: Int -> println(i) }
doubled2.forEach { i: Int -> println(i) }
/*
Paul
Paula
Paul
Paula
Paula
Paula
2
4
0
0
*/