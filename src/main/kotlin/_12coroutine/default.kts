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
    launch(Dispatchers.Default) { task1() }
    launch { task2() }

    println("called task1 and task2 from ${Thread.currentThread()}")
}

println("done")
/*
start
start task1 in Thread Thread[DefaultDispatcher-worker-1 @coroutine#2,5,main]
end task1 in Thread Thread[DefaultDispatcher-worker-3 @coroutine#2,5,main]
called task1 and task2 from Thread[main @coroutine#1,5,main]
start task2 in Thread Thread[main @coroutine#3,5,main]
end task2 in Thread Thread[main @coroutine#3,5,main]
done
*/