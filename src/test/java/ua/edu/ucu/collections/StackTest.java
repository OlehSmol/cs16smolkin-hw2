package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testStackOrder() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer[] ActualResult = new Integer[3];
        for (int i=0; i<3; i++){
            ActualResult[i] = (Integer) stack.pop();
        }
        Integer[] ExpectedResult = {3, 2, 1};

        assertArrayEquals(ActualResult, ExpectedResult);
    }

    @Test
    public void testEmptyStacl() {
        Stack stack = new Stack();
        Integer ActualResult = (Integer) stack.pick();
        Integer ExpectedResult = null;
        assertEquals(ActualResult, ExpectedResult);
    }
    
}
