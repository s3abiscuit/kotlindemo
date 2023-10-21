open class Vehicle(val year: Int, open var color: String) {
    open val km = 0
    final override fun toString(): String {
        return "year: $year, color: $color, km: $km"
    }

    fun repaint(newColor: String) {
        color = newColor
    }
}

println(Vehicle(2002, "red"))

open class Car(year: Int, Color: String) : Vehicle(year, Color) {
    override var km = 0
        set(value) {
            if (value < 1) {
                throw RuntimeException("can't set negative value")
            }
            field = value
        }

    fun drive(distance: Int) {
        km += distance
    }
}

val car = Car(2010, "white")
car.drive(10)
try {
    car.drive(-10)
} catch (e: RuntimeException) {
    println(e)
}
println(car)

class FamilyCar(year: Int, Color: String) : Vehicle(year, Color) {
    override var color: String
        get() = super.color
        set(value) {
            if (value.isEmpty()) throw RuntimeException("color required")
            super.color = value
        }
}

val familyCar = FamilyCar(2010, "white")
println(familyCar.color)
try {
    familyCar.repaint("")
} catch (e: RuntimeException) {
    println(e.message)
}
/*
year: 2002, color: red, km: 0
java.lang.RuntimeException: can't set negative value
year: 2010, color: white, km: 10
white
color required
*/