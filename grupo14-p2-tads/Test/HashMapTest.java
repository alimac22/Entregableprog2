import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.HashMap.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMapTest {

    @Test
    void add() {
        HashMap<String,Integer> h = new HashMap<>();
        h.add("Perro",1);
        h.add("Gato",2);
        h.add("Loro",3);
        assertEquals(3,h.getSize());
    }

    @Test
    void remove() {
        HashMap<String,Integer> h = new HashMap<>();
        h.add("Perro",1);
        h.add("Gato",2);
        h.add("Loro",3);
        h.remove("Perro");
        assertEquals(2,h.getSize());


    }

    @Test
    void get() {
        HashMap<String,Integer> h = new HashMap<>();
        h.add("Perro",1);
        h.add("Gato",2);
        h.add("Loro",3);
        assertEquals(1,h.get("Perro"));

    }
}