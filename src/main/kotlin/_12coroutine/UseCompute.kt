import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val compute = Compute()
  
  launch(Dispatchers.Default) {
    compute.compute2(2)
  }
  launch(Dispatchers.Default) {
    compute.compute2(1)
  }
}
/*
2 received : Thread: Thread[DefaultDispatcher-worker-1,5,main]
1 received : Thread: Thread[DefaultDispatcher-worker-2,5,main]
1, returning 2: Thread: Thread[DefaultDispatcher-worker-2,5,main]
2, returning 4: Thread: Thread[DefaultDispatcher-worker-4,5,main]
*/