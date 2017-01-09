package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testQueuOrder() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Integer[] ActualResult = new Integer[3];
        for (int i=0; i<3; i++){
            ActualResult[i] = (Integer) queue.dequeue();
        }
        Integer[] ExpectedResult = {1, 2, 3};

        assertArrayEquals(ActualResult, ExpectedResult);
    }

    @Test
    public void testEmptyQueu() {
        Queue queue = new Queue();
        Integer ActualResult = (Integer) queue.pick();
        Integer ExpectedResult = null;
        assertEquals(ActualResult, ExpectedResult);
    }
}
