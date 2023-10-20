// 类声明
// 引用的时候才会创建单例对象
object Util {
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
    val number = Runtime.getRuntime().availableProcessors()
}

fun drawCircle() {
    // 这里创建了一个匿名类的对象 Object$drawCircle$circle$1
    val circle = object {
        var x = 10
        val y = 10
        val radius = 30

        fun area(): Float = 3.14f * radius * radius
    }
    circle.x = 11

    println("circle x: ${circle.x}, circle y: ${circle.y}, circle radius: ${circle.radius}")
    println("circle area: ${circle.area()}")
    println(circle::class)

    println(Util.numberOfProcessors())
    println(Util.number)
}

fun createRunnable(): Runnable {
    val r1 = object : Runnable {
        override fun run() {
            println("run run run")
        }
    }
    val r2 = Runnable { println("run run run") }
    return r2
}

drawCircle()
createRunnable().run()
/*
circle x: 11, circle y: 10, circle radius: 30
circle area: 2826.0002
class Object$drawCircle$circle$1
8
8
run run run
*/