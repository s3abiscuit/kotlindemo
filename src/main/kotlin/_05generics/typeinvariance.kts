open class Creature {
    override fun toString(): String {
        return "creature"
    }
}

open class Fruit : Creature() {
    override fun toString(): String {
        return "fruit"
    }
}

class Banana : Fruit() {
    override fun toString(): String {
        return "banana"
    }
}

class Orange : Fruit() {
    override fun toString(): String {
        return "orange"
    }
}

// out: read
// 1. 什么可以传入
// 2. 如何读
fun testOut(from: Array<out Fruit>) {
    for (i in 0 until from.size) {
        val f: Fruit = from[i]
        println(f)
    }
}

val bananas: Array<Banana> = Array(3) { _ -> Banana() }
val oranges: Array<Orange> = Array(3) { _ -> Orange() }
testOut(bananas)
testOut(oranges)

// in: write
// 1. 什么可以传入
// 2. 如何写
fun testIn(to: Array<in Fruit>) {
    for (i in 0 until to.size) {
        to[i] = Fruit()
        println(to[i])
    }
}

val creatures: Array<Creature> = Array(3) { _ -> Creature() }
val fruits: Array<Any> = Array(3) { _ -> Any() }
testIn(creatures)
testIn(fruits)

// test in & out
fun copyFromTo(from: Array<out Fruit>, to: Array<in Fruit>) {
    for (i in 0 until from.size) {
        to[i] = from[i]
        println("from: ${from[i]}, to: ${to[i]}")
    }
}

val bananaBasket: Array<Banana> = Array(3) { _ -> Banana() }
val anyBasket: Array<Creature> = Array(3) { _ -> Creature() }
copyFromTo(bananaBasket, anyBasket)

/**
banana
banana
banana
orange
orange
orange
fruit
fruit
fruit
fruit
fruit
fruit
from: banana, to: banana
from: banana, to: banana
from: banana, to: banana
 */
