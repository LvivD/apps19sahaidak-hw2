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
        ImmutableArrayList a = new ImmutableArrayList();
        ImmutableList b = a.add(0, 1);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1}).toString());
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
    
}
