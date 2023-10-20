// when as an expression
fun systemInfo(): String =
    when (val numberOfCores = Runtime.getRuntime().availableProcessors()) {
        1 -> "1 core, packing this one to museum"
        in 2..6 -> "you have $numberOfCores cores"
        else -> "$numberOfCores cores, i want your machine"
    }

fun printWhatToDo(dayOfWeek: Any): Unit {
    when (dayOfWeek) {
        "Saturday", "Sunday" -> println("relax")
        in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> println("work hard")
        in 2..4 -> println("work hard")
        "Friday" -> println("party")
        is String -> println("what")
    }
}

println(systemInfo())
printWhatToDo("Monday")
printWhatToDo("Wednesday")
printWhatToDo(3)
printWhatToDo("hhh")
printWhatToDo(8)

/*
8 cores, i want your machine
work hard
work hard
work hard
what
*/