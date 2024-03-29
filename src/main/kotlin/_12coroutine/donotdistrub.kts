import kotlinx.coroutines.*

suspend fun doWork(id: Int, sleep: Long) = coroutineScope {
  try {
    println("$id: entered $sleep")
    delay(sleep)
    println("$id: finished nap $sleep")
    
    withContext(NonCancellable) {
      println("$id: do not disturb, please")
      delay(5000)
      println("$id: OK, you can talk to me now")
    }
    
    println("$id: outside the restricted context")
    println("$id: isActive: $isActive")
  } catch(ex: CancellationException) {
    println("$id: doWork($sleep) was cancelled")
  }
}

runBlocking {
  val job = launch(Dispatchers.Default) {
    launch { doWork(1, 3000) }
    launch { doWork(2, 1000) }
  }
  
  Thread.sleep(2000)
  job.cancel()
  println("cancelling")
  job.join()           
  println("done")
}
/*
2: entered 1000
1: entered 3000
2: finished nap 1000
2: do not disturb, please
cancelling
1: doWork(3000) was cancelled
2: OK, you can talk to me now
2: outside the restricted context
2: isActive: false
done
*/