interface Worker {
    fun doWork()
    fun takeVacation()
    fun fileTimeSheet() = println("Why, really")
}

interface Assistant {
    fun doChores()
    fun fileTimeSheet() = println("no escape from that")
}

class JavaProgrammer : Worker {
    override fun doWork() {
        println("write java code")
    }

    override fun takeVacation() {
        println("take vacation in Java")
    }
}

class DepartmentAssistant : Assistant {
    override fun doChores() {
        println("do daily routine")
    }
}

class Manager(private val worker: Worker, private val assistant: Assistant) :
    Worker by worker, Assistant by assistant {
    override fun takeVacation() {
        println("do vacation by manager himself")
    }

    override fun fileTimeSheet() {
        print("manually forwarding this, ")
        assistant.fileTimeSheet()
    }
}

val manager = Manager(JavaProgrammer(), DepartmentAssistant())
manager.doWork() // delegates to JavaProgrammer
manager.doChores() // delegates to DepartmentAssistant
manager.takeVacation() // override
manager.fileTimeSheet() // override

/*
write java code
do daily routine
do vacation by manager himself
manually forwarding this, no escape from that
*/

