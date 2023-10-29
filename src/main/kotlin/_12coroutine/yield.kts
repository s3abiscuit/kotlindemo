import kotlinx.coroutines.*

suspend fun task1() {
    println("start task1 in Thread ${Thread.currentThread()}")
    yield()
    println("end task1 in Thread ${Thread.currentThread()}")
}

suspend fun task2() {
    println("start task2 in Thread ${Thread.currentThread()}")
    yield()
    println("end task2 in Thread ${Thread.currentThread()}")
}

println("start")

runBlocking {
    launch { task1() }
    launch { task2() }

    println("called task1 and task2 from ${Thread.currentThread()}")
}

println("done")
/*
start
called task1 and task2 from Thread[main @coroutine#1,5,main]
start task1 in Thread Thread[main @coroutine#2,5,main]
start task2 in Thread Thread[main @coroutine#3,5,main]
end task1 in Thread Thread[main @coroutine#2,5,main]
end task2 in Thread Thread[main @coroutine#3,5,main]
done
*/