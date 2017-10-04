/**
 * Created by Sophia on 11/11/2016.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This is the driver class for the program. It creates a shared buffer, a consumer
 * and a producer.
 * @see CircularBufferTest
 */
public class CircularBufferTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CircularBuffer buffer = new CircularBuffer();
        buffer.displayState("Initial State");

        executorService.execute(new Producer(buffer));
        executorService.execute(new Consumer(buffer));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
