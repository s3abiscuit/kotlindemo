package _03function

fun main() {
    println("max1 value of (1, 2, 3, 4) is ${max1(intArrayOf(1, 2, 3, 4))}")
    println("max2 value of (1, 2, 3, 4) is ${max2(1, 2, 3, 4)}") // variable number of arguments
    println("max2 value of (1, 2, 3, 4) is ${max2(*(listOf(1, 2, 3, 4).toIntArray()))}") // spread
    println(greet("David")) // parameter has default value
    println(greet("Jack", "Yo"))

    createPerson(name = "Jill", weight = 60, age = 20, height = 170) // 参数顺序没有要求

    println(f1())
    println(f2()) // return lambda

    println(f2()())
    println(f2().invoke())
}

fun max1(numbers: IntArray): Int {
    var large = Int.MIN_VALUE
    for (number in numbers) {
        large = if (number > large) number else large
    }
    return large
}

fun max2(vararg numbers: Int): Int {
    var large = Int.MIN_VALUE
    for (number in numbers) {
        large = if (number > large) number else large
    }
    return large
}

fun greet(name: String, msg: String = "hi ${name.length}"): String {
    return "$msg, $name"
}

fun createPerson(name: String, age: Int, height: Int, weight: Int) {
    println("name:$name, age:$age, height:$height, weight:$weight")
}

fun f1() = 2
fun f2() = { 2 }

/**
max1 value of (1, 2, 3, 4) is 4
max2 value of (1, 2, 3, 4) is 4
max2 value of (1, 2, 3, 4) is 4
hi 5, David
Yo, Jack
name:Jill, age:20, height:170, weight:60
2
Function0<java.lang.Integer>
2
2
 */