class Mailer {
    val details = StringBuilder()
    fun from(addr: String) = details.append("from $addr...\n")
    fun to(addr: String) = details.append("to $addr..\n")
    fun subject(line: String) = details.append("subject $line..\n")
    fun body(message: String) = details.append("body $message..\n")
    fun send() = "...sending...\n$details"
}

val mailer = Mailer()
mailer.from("from@abcd.com")
mailer.to("to@abcd.com")
mailer.subject("this is title")
mailer.body("this is body")
println(mailer.send())

val applyMail = Mailer().apply {
    from("from@abcd.com")
    to("to@abcd.com")
    subject("this is title")
    body("this is body")
}
println(applyMail.send())

val runMailResult = Mailer().run {
    from("from@abcd.com")
    to("to@abcd.com")
    subject("this is title")
    body("this is body")
    send()
}
print(runMailResult)

val alsoMail = Mailer().also { }



