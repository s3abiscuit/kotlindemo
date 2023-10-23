import kotlin.math.PI

data class Point(val x: Int, val y: Int)
data class Circle(val center: Point, val radius: Int) {
    constructor(x: Int, y: Int, radius: Int) : this(Point(x, y), radius) {
    }
}

// 扩展函数
operator fun Circle.contains(p: Point): Boolean {
    return (p.x - center.x) * (p.x - center.x) + (p.y - center.y) * (p.y - center.y) < radius * radius
}

// 扩展属性
val Circle.area: Double get() = radius * radius * PI

val point = Point(0, 0)

val circle = Circle(2, 2, 10)

println(circle.contains(point))
println(point in circle)
println("circle area is ${circle.area}")

fun <T, R, U> ((T) -> R).andThen(next: ((R) -> U)): (T) -> U {
    return { input: T -> next(this(input)) }
}

fun increment(number: Int): Double {
    return number + 1.toDouble()
}

fun double(number: Double) = 2 * number

val incAndDouble = ::increment.andThen(::double)
println(incAndDouble(5))
/*
true
true
circle area is 314.1592653589793
12.0
*/