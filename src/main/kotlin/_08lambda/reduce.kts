data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Sara", 12),
    Person("Jill", 51),
    Person("Paula", 23),
    Person("Paul", 25),
    Person("Mani", 12),
    Person("Jack", 70),
    Person("Sue", 10)
)

val result = people.filter { person -> person.age > 20 }
    .map { person -> person.name }
    .map { name -> name.uppercase() }
    .reduce { acc, name -> "$acc, $name" }
println(result)

/*
JILL, PAULA, PAUL, JACK
*/

/*
public inline fun <S, T : S> Iterable<T>.reduce(operation: (acc: S, T) -> S): S {
    val iterator = this.iterator()
    if (!iterator.hasNext()) throw UnsupportedOperationException("Empty collection can't be reduced.")
    var accumulator: S = iterator.next()
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
    }
    return accumulator
}
*/