import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.TADs.Heap.Heap;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void peek() {
        Heap h = new Heap(true);
        h.add(1);
        h.add(12);
        h.add(33);
        assertEquals(33,h.peek());
    }

    @Test
    void delete() {
        Heap h = new Heap(true);
        h.add(1);
        h.add(12);
        h.add(33);
        assertEquals(33,h.delete());

    }

    @Test
    void add() {
        Heap h = new Heap(true);
        h.add(1);
        assertEquals(1,h.peek());
    }
}