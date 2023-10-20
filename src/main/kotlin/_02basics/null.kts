fun nickName1(name: String?): String {
    return if (name == "William") "Bill"
    else name?.reversed()?.uppercase() ?: "Joker"
}

fun nickName(name: String?) = when (name) {
    null -> "Joker"
    "William" -> "Bill"
    else -> name.reversed().uppercase()
}

fun nickName2(name: String?): String {
    return if (name == "William") "Bill"
    else return name!!.reversed()?.uppercase() ?: "Joker" // name 为 null 时会引起 NPE
}

println(nickName1("William"))
println(nickName1("Jack"))
println(nickName1(null))

println(nickName("William"))
println(nickName("Jack"))
println(nickName(null))

println(nickName2("William"))
println(nickName2("Jack"))
println(nickName2(null))

/*
Bill
KCAJ
Joker
Bill
KCAJ
Joker
Bill
KCAJ
java.lang.NullPointerException
        at Null.nickName2(null.kts:14)
        at Null.<init>(null.kts:27)
*/