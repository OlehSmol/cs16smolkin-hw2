package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.io.Console;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.ConsoleHandler;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    @Test
    public void testAdd() {
        ImmutableArrayList list = new ImmutableArrayList();
        Object[] expResult = {1, 2, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        Object[] actualResult = list.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIndexAdd() {
        ImmutableArrayList list = new ImmutableArrayList();
        Object[] expResult = {1, 2, 4, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.add(2, 4);

        Object[] actualResult = list.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList list = new ImmutableArrayList();
        Object[] expResult = {1, 2, 3, 4, 5, 6};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.addAll(new Object[]{4, 5, 6});

        Object[] actualResult = list.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIndexAddAll() {
        ImmutableArrayList list = new ImmutableArrayList();
        Object[] expResult = {1, 2, 4, 5, 6, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.addAll(2, new Object[]{4, 5, 6});

        Object[] actualResult = list.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOfExisted() {
        ImmutableArrayList list = new ImmutableArrayList();
        int expResult = 2;
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        int actualResult = list.indexOf(3);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList list = new ImmutableArrayList();
        int expResult = -1;
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        int actualResult = list.indexOf(4);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSet() {
        ImmutableArrayList list = new ImmutableArrayList();
        Object[] expResult = {1, 4, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.set(2, 4);

        Object[] actualResult = list.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testGet() {
        ImmutableArrayList list = new ImmutableArrayList();
        Object expResult = 1;
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        Object actualResult = list.get(0);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList list = new ImmutableArrayList();
        Object[] expResult = {1, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.remove(1);

        Object[] actualResult = list.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testClear() {
        ImmutableArrayList list = new ImmutableArrayList();
        list = list.add(new StringBuilder("a"));
        list = list.clear();
        int actualResult = list.size();
        int expResult = 0;
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testString() {
        ImmutableArrayList list = new ImmutableArrayList();
        String expResult = "1, 2, 3";
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        String actualResult = list.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        boolean expResult = false;
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        boolean actualResult = list.isEmpty();
        assertEquals(expResult, actualResult);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testValidate() {
        ImmutableArrayList list = new ImmutableArrayList();
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.add(5, 4);
    }

}
