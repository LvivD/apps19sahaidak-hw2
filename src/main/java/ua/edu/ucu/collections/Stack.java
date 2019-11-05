package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList lst;

    public Stack() {
        lst = new ImmutableLinkedList();
    }

    public Object peek() {
        return this.lst.getFirst();
    }

    public Object dequeue() {
        Object elem = this.lst.getFirst();
        this.lst = this.lst.removeFirst();
        return elem;
    }

    public void enqueue(Object e) {
        this.lst = this.lst.addFirst(e);
    }

    public String toString() {
        return this.lst.toString();
    }
}
