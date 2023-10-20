interface Remote {
    fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }
}

class TV {
    private var volume = 0
    val remote: Remote
        get() = TVRemote()

    override fun toString(): String {
        return "Volume is $volume"
    }

    inner class TVRemote : Remote {
        override fun up() {
            volume++
        }

        override fun down() {
            volume--
        }

        override fun toString(): String {
            return "inner ${this@TV.toString()}"
        }
    }
}

val tv = TV()
val remote = tv.remote
println(tv)
remote.up()
remote.doubleUp()
println(tv)
println(remote)

/*
Volume is 0
Volume is 3
inner Volume is 3
*/