import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class implements a circular buffer using locks and conditions.
 * Note: This class was built by modifying the circular buffer class
 * designed in Figure 23.18 of Deitel and Deitel's Java How to Program
 * Eary Objects.
 * @author Sophia Mallaro
 * @see CircularBuffer
 */
public class CircularBuffer implements Buffer {
    private final int[] buffer = {-1, -1, -1};
    private int occupiedCells = 0;
    private int writeIndex = 0;
    private int readIndex = 0;

    private final Lock accessLock = new ReentrantLock();

    private final Condition canWrite = accessLock.newCondition(); //not full
    private final Condition canRead = accessLock.newCondition(); //not empty

    /**
     * This method places a value into the buffer
     * @param value Value to be placed in the buffer
     * @throws InterruptedException
     */
    public void blockingPut(int value) throws InterruptedException {
        accessLock.lock();
        try {
            while(occupiedCells == buffer.length) {
                canWrite.await();
            }
            buffer[writeIndex] = value;
            writeIndex = (writeIndex + 1) % buffer.length;
            ++occupiedCells;
            displayState("Producer Writes:  " + value);
            canRead.signal();
        } finally {
            accessLock.unlock();
        }

    }

    /**
     * This method removes one item from the buffer
     * @return Next int in buffer
     * @throws InterruptedException
     */
    public int blockingGet() throws InterruptedException {
        accessLock.lock();
        try {
            while(occupiedCells == 0) {
                canRead.await();
            }

            int readValue = buffer[readIndex];
            readIndex = (readIndex + 1) % buffer.length;
            --occupiedCells;
            displayState("Producer Reads:  " + readValue);
            canWrite.signal();
            return readValue;
        } finally {
            accessLock.unlock();
        }
    }

    /**
     * This method displays the state of the buffer.
     * @param operation
     */
    public void displayState(String operation) {
        accessLock.lock();
        System.out.printf("%s%s%d)%n%s", operation, " (buffer cells occupied: ", occupiedCells, "buffer cells: ");

        for(int value : buffer) {
            System.out.printf(" %2d ", value);
        }
        System.out.printf("%n              ");

        for(int i=0; i< buffer.length; i++) {
            if(i == writeIndex && i == readIndex) {
                System.out.print(" WR");
            }
            else if(i == writeIndex) {
                System.out.print(" W  ");
            }
            else if(i == readIndex) {
                System.out.print(" R ");
            }
            else {
                System.out.print("     ");
            }
        }

        System.out.printf("%n%n");
        accessLock.unlock();
    }



}
