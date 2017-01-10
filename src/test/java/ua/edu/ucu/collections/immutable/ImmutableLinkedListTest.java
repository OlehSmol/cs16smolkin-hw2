package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAdd() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        Object[] expResult = {1, 2, 3};
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        Object[] actualResult = list.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIndexAdd() {
        ImmutableLinkedList list = new ImmutableLinkedList();
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
        ImmutableLinkedList list = new ImmutableLinkedList();
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
        ImmutableLinkedList list = new ImmutableLinkedList();
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
        ImmutableLinkedList list = new ImmutableLinkedList();
        int expResult = 2;
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        int actualResult = list.indexOf(3);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int expResult = -1;
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        int actualResult = list.indexOf(4);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList list = new ImmutableLinkedList();
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
        ImmutableLinkedList list = new ImmutableLinkedList();
        Object expResult = 1;
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);

        Object actualResult = list.get(0);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList list = new ImmutableLinkedList();
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
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.add(new StringBuilder("a"));
        list = list.clear();
        int actualResult = list.size();
        int expResult = 0;
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testString() {
        ImmutableLinkedList list = new ImmutableLinkedList();
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
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.add(5, 4);
    }
}
