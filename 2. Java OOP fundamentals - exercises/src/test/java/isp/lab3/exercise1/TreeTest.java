package isp.lab3.exercise1;

import isp.lab3.exercise1.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
// nu facem pentru getter/setter
public class TreeTest {
    @Test
    public void testGrow(){
        Tree tree1 = new Tree();
        tree1.grow(2);
        assertEquals(17, tree1.getHeight());

        Tree tree2 = new Tree();
        tree2.grow(0);
        assertEquals(15, tree2.getHeight());
    }

    @Test
    public void testToString() {
        Tree tree = new Tree();
        assertEquals("Tree height 15", tree.toString());
    }
}
