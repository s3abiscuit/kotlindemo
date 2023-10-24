import kotlin.math.PI

data class Point(val x: Int, val y: Int)
data class Circle(val center: Point, val radius: Int) {
    constructor(x: Int, y: Int, radius: Int) : this(Point(x, y), radius) {
    }
}

// 扩展函数
operator infix fun Circle.contains(p: Point): Boolean {
    return (p.x - center.x) * (p.x - center.x) + (p.y - center.y) * (p.y - center.y) < radius * radius
}

// 扩展属性
val Circle.area: Double get() = radius * radius * PI


val point = Point(0, 0)

val circle = Circle(2, 2, 10)

println(circle.contains(point))
println(circle contains point) // infix
println(point in circle)
println("circle area is ${circle.area}")

/*
true
true
true
circle area is 314.1592653589793
*/