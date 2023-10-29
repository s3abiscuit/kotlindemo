import kotlinx.coroutines.*

runBlocking {
    val count: Deferred<Int> = async(Dispatchers.Default) {
        println("fetching in ${Thread.currentThread()}")
        Runtime.getRuntime().availableProcessors()
    }

    println("Called the function in ${Thread.currentThread()}")

    println("Number of cores is ${count.await()} in ${Thread.currentThread()}")
}
/*
Called the function in Thread[main @coroutine#1,5,main]
fetching in Thread[DefaultDispatcher-worker-2 @coroutine#2,5,main]
Number of cores is 8 in Thread[main @coroutine#1,5,main]
*/