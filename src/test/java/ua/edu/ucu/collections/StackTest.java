package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testInit() {
        Stack a = new Stack();
        assertEquals("", a.toString());
    }

    @Test
    public void testEnqueueEmpty() {
        Stack a = new Stack();
        a.enqueue(1);
        assertEquals("1", a.toString());
    }

    @Test
    public void testEnqueue() {
        Stack a = new Stack();
        a.enqueue(1);
        a.enqueue(2);
        assertEquals("2, 1", a.toString());
    }

    @Test
    public void testPeekEmpty() {
        Stack a = new Stack();
        Object b = a.peek();
        assertNull(b);
    }

    @Test
    public void testPeek() {
        Stack a = new Stack();
        a.enqueue(1);
        a.enqueue(3);
        a.enqueue(2);
        Object b = a.peek();
        assertEquals(2, b);
    }

    @Test
    public void testDequeueEmpty() {
        Stack a = new Stack();
        Object b = a.dequeue();
        assertNull(b);
        assertEquals("", a.toString());
    }

    @Test
    public void testDequeue() {
        Stack a = new Stack();
        a.enqueue(1);
        a.enqueue(3);
        a.enqueue(2);
        Object b = a.dequeue();
        assertEquals(2, b);
        assertEquals("3, 1", a.toString());
    }

    @Test
    public void testToStringEmpty() {
        Stack a = new Stack();
        assertEquals("", a.toString());
    }

    @Test
    public void testToString() {
        Stack a = new Stack();
        a.enqueue(1);
        a.enqueue(3);
        a.enqueue(2);
        assertEquals("2, 3, 1", a.toString());
    }
    
}
