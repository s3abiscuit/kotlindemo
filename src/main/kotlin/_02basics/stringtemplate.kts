val price = 12.25
val taxRate = 0.08

val output = "The amount $price after tax comes to $${price * (1 + taxRate)}"
val disclaimer = "The amount is in US$, that's right in \$only"

println(output)
println(disclaimer)

/**
The amount 12.25 after tax comes to $13.23
The amount is in US$, that's right in $only
 */