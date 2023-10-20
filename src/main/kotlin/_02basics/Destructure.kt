package _02basics

fun main() {
    val (first, second, third) = Triple("John", "Quincy", "Adams")
    val (first1, _, third1) = Triple("John1", "Quincy1", "Adams1")
    println(first)
    println(second)
    println(third)
    println(first1)
    println(third1)
}

/*
John
Quincy
Adams
John1
Adams1
*/