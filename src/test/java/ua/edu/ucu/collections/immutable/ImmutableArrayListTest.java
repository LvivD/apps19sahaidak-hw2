package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest {

    @Test
    public void testAddMethod() {
        ImmutableArrayList a = new ImmutableArrayList();
        ImmutableList b = a.add(1);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexMethodException() {
        ImmutableArrayList a = new ImmutableArrayList();
        ImmutableList b = a.add(3, 1);
    }

    @Test
    public void testAddWithIndexMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.add(1, 7);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,7,2,3}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test
    public void testAddAllMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.addAll(new Object[] {4,5,6});
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,2,3,4,5,6}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndexMethodException() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.addAll(5, new Object[] {4,5,6});
    }

    @Test
    public void testAddAllWithIndexMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.addAll(2, new Object[] {4,5,6});
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,2,4,5,6,3}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetMethodException() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        Object elem = a.get(7);
    }

    @Test
    public void testGetMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        Object elem = a.get(2);
        assertEquals(elem, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveMethodException() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        Object elem = a.remove(7);
    }

    @Test
    public void testRemoveMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.remove(1);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,3}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveMethodMinusOne() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveMethodLastLast() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.remove(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetMethodException() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        Object elem = a.set(7, 100);
    }

    @Test
    public void testSetMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.set(1, 100);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,100,3}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test
    public void testIndexOfMethodNotFound() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        int res = a.indexOf(100);
        assertEquals(res, -1);
    }

    @Test
    public void testIndexOfMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        int res = a.indexOf(1);
        assertEquals(res, 0);
    }

    @Test
    public void testSizeMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        int size = a.size();
        assertEquals(size, 3);
    }

    @Test
    public void testClearMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.clear();
        assertEquals(b.toString(), "");
        assertNotEquals(b.toString(), a.toString());
    }

    @Test
    public void testIsEmptyMethodTrue() {
        ImmutableArrayList a = new ImmutableArrayList();
        assertTrue(a.isEmpty());
    }

    @Test
    public void testIsEmptyMethodFalse() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        assertFalse(a.isEmpty());
    }

    @Test
    public void testToArrayMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        assertArrayEquals(a.toArray(), new Object[] {1,2,3});
    }

    @Test
    public void testToStringMethod() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        assertEquals(a.toString(), "1, 2, 3");
    }


}
