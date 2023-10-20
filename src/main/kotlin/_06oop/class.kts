class Simplest

class Car public constructor(public val yearOfMake: Int, theColor: String) {
    var fuelLevel = 100
    var color = theColor

    init {
        if (yearOfMake < 2020) fuelLevel = 90
    }

    override fun toString(): String {
        return "fuelLevel: ${fuelLevel}, yearOfMake${yearOfMake}, color: ${color}"
    }
}

val car = Car(2019, "red")
car.color = "green"
println(car)

class Person constructor(val first: String, val second: String) {
    var fullTime = true;
    var location: String = "-"

    constructor(first: String, second: String, third: Boolean) : this(first, second) {
        fullTime = third
    }

    constructor(first: String, second: String, third: Boolean, forth: String) : this(first, second, third) {
        location = forth
    }

    override fun toString(): String {
        return "first: ${first}, second: ${second}, fullTime: ${fullTime}, location: ${location}"
    }
}

val p1: Person = Person("Jim", "Green")
println(p1)

val p2: Person = Person("Jack", "Smith", third = true)
println(p2)

val p3: Person = Person("Jason", "Bourne", true, "Beijing")
println(p3)

/**
fuelLevel: 90, yearOfMake2019, color: green
first: Jim, second: Green, fullTime: true, location: -
first: Jack, second: Smith, fullTime: true, location: -
first: Jason, second: Bourne, fullTime: true, location: Beijing
 */