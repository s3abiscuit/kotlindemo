abstract class Book(val name: String)
class Fiction(name: String) : Book(name)
class NonFiction(name: String) : Book(name)

val books = listOf(Fiction("Moby Dick"), NonFiction("Learn to code"), Fiction("LOTR"))
fun <T> findFirst(books: List<Book>, ofClass: Class<T>): T {
    val selected = books.filter { book -> ofClass.isInstance(book) }
    if (selected.size == 0) throw RuntimeException("not found")
    return ofClass.cast(selected[0])
}

inline fun <reified T> findFirst(books: kotlin.collections.List<Book>): T {
    val selected = books.filter { book -> book is T }
    if (selected.size == 0) throw RuntimeException("not found")
    return selected[0] as T
}
println(findFirst<Fiction>(books, Fiction::class.java).name)
println(findFirst<Fiction>(books).name)

/**
Moby Dick
Moby Dick
 */
