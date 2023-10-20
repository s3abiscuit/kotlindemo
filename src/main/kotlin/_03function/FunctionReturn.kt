package _03function

fun main() {
    val message: Unit = sayHello()
    println(message)
}

fun sayHello() = println("hello")

/** output
hello
kotlin.Unit
 */

/** what is unit
package kotlin
public object Unit {
    override fun toString() = "kotlin.Unit"
}
*/