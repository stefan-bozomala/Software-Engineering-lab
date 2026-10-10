package isp.lab3.exercise4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyPointTest {
    MyPoint point1 = new MyPoint(1,2,3);
    MyPoint point2 = new MyPoint(4,5,6);

    @Test
    public void testDistance1(){
        assertEquals(33, point1.distance(10,20,30));
    }

    @Test
    public void testDistance2(){
        assertEquals(5,point1.distance(point2));
    }

}
