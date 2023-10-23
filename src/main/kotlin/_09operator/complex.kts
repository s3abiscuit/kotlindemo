import kotlin.math.abs

data class Complex(val real: Int, val imaginary: Int) {

    operator fun plus(other: Complex): Complex {
        val a = this.real + other.real
        val b = this.imaginary + other.imaginary
        return Complex(a, b)
    }

    operator fun minus(other: Complex): Complex {
        return Complex(this.real - other.real, this.imaginary - other.imaginary)
    }

    operator fun times(other: Complex): Complex {
        val a = this.real * other.real - this.imaginary * other.imaginary
        val b = this.real * other.imaginary + this.imaginary * other.real
        return Complex(a, b)
    }

    private fun sign() = if (imaginary < 0) "-" else "+"
    override fun toString(): String {
        return "$real ${sign()} ${abs(imaginary)}i"
    }
}

val c1 = Complex(1, 2)
val c2 = Complex(3, 4)
val c3 = c1 + c2
val c4 = c1 - c2
val c5 = c1.times(c2)
println("c1: $c1, c2: $c2")
println("c1+c2: $c3")
println("c1-c2: $c4")
println("c1*c2: $c5")


class Counter(val count: Int) {
    operator fun inc(): Counter = Counter (count + 1)
    operator fun dec(): Counter = Counter (count - 1)
    override fun toString(): String {
        return "$count"
    }
}

val counter1 = Counter(1)
val counter2 = ++counter1
val counter3 = --counter1

println("counter1: $counter1, counter2: $counter2, counter3: $counter3")
/*
c1: 1 + 2i, c2: 3 + 4i
c1+c2: 4 + 6i
c1-c2: -2 - 2i
c1*c2: -5 + 10i
counter1: 1, counter2: 2, counter3: 1
*/