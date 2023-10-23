val doubleOfEven1 = (1..10).filter { i: Int -> i % 2 == 0 }.map { i: Int -> 2 * i }
val doubleOfEven2 = (1..10).filter { it % 2 == 0 }.map { 2 * it }
println(doubleOfEven1)

fun isPrime(n: Int) = n > 1 && (2 until n).none { i -> n % 2 == 0 }

fun walk1To(n: Int, action: (Int) -> Unit) {
    (1..n).forEach { i -> action(i) }
}

object Terminal {
    fun write(n: Int) = print(n)
}

walk1To(5) { i -> print(i) }
walk1To(5, ::print)
walk1To(5, Terminal::write)