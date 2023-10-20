abstract class Musician(val name: String, val activeFrom: Int) {
    abstract fun instrumentType(): String
}

class Cellist(name: String, activeFrom: Int) : Musician(name, activeFrom) {
    override fun instrumentType(): String {
        return "String"
    }
}

val ma = Cellist("Yo-yo Ma", 1962)