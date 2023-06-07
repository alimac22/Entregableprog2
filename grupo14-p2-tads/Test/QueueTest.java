import uy.edu.um.prog2.adt.queue.EmptyQueueException;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.queue.LinkedQueue.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> queue = new Queue<>();

    @Test
    void enqueue() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue().intValue());
    }

    @Test
    void dequeue() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue().intValue());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isNotEmpty() {
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }
}