package isp.lab3.exercise2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    Rectangle rectangle = new Rectangle();

    @Test
    public void testGetPerimeter(){
        assertEquals(6, rectangle.getPerimeter());
    }

    @Test
    public void testGetArea(){
        assertEquals(2, rectangle.getArea());
    }
}
