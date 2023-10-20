val p1 = Pair("Tom", "Cat")
val p2 = "Jerry" to "Mouse" // Any 的扩展函数
val p3 = "Fredy".to("Frog")
val map1 = mapOf(p1, p2, p3)
println(map1)
println(map1.containsKey("Tom"))
println("Tom" in map1)
println(map1.containsValue("Cat"))
println("Cat" in map1)
for (entry in map1) println("${entry.key} ${entry.value}")
for ((key, value) in map1) println("$key $value")


val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
fun getTemperaturAtAirport(code: String): String =
    "${Math.round(Math.random() * 30) + code.count()} C"

val map2 = airportCodes.map { code -> code to getTemperaturAtAirport(code) }
println(map2)


/**
{Tom=Cat, Jerry=Mouse, Fredy=Frog}
true
true
true
false
Tom Cat
Jerry Mouse
Fredy Frog
Tom Cat
Jerry Mouse
Fredy Frog
[(LAX, 23 C), (SFO, 8 C), (PDX, 15 C), (SEA, 12 C)]
 */

