val array1 = arrayOf(1, 2, 3)
println(array1.javaClass)

for (number in array1) print("$number, ")
println()

val array2 = intArrayOf(2, 3, 4)
println(array2.javaClass)
println("size: ${array2.size}")
println("sum: ${array2.sum()}")
println("average: ${array2.average()}")

val array3 = Array(5) { i -> (i * i) }
println(array3.sum())


/*
class [Ljava.lang.Integer;
1, 2, 3,
class [I
size: 3
sum: 9
average: 3.0
30
* */