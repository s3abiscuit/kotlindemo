data class Person(val name: String, var age: Int) {
    var occupation: String = "teacher"
}

val p1 = Person("jack", 18)
println(p1.hashCode())
println(p1)

val p2 = p1.copy()
println(p2)
/*
100881427
Person(name=jack, age=18)
Person(name=jack, age=18)
*/