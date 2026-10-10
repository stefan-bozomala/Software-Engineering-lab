package utcluj.aut;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirstExampleTest {
    
    @Test
    public void testAdd() {
        assertEquals(5, MyFirstExample.add(2, 3));
        assertEquals(0, MyFirstExample.add(-1, 1));
        assertEquals(-3, MyFirstExample.add(-1, -2));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, MyFirstExample.subtract(3, 2));
        assertEquals(-2, MyFirstExample.subtract(-1, 1));
        assertEquals(1, MyFirstExample.subtract(-1, -2));
    }

    //adaug testul pentru metoda compare
    @Test
    public void testCompare() {
        assertEquals(1, MyFirstExample.compare(1, 2));
        assertEquals(-1, MyFirstExample.compare(2, 1));
        assertEquals(0, MyFirstExample.compare(1, 1));
    }

}
