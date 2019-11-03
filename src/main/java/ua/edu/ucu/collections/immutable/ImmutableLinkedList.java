package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {

    private class Node {

        private Object elem;
        private Node next;
        private Node prev;

        Node(Object elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

        Node(Object elem) {
            this.elem = elem;
            this.next = null;
            this.prev = null;
        }

        public Object getElem() {
            return elem;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node copyNextNull() {
            return new Node(this.elem, this.next, this.prev);
        }
    }

    private final Node head;
    private final Node tail;
    private final int size;

    public ImmutableLinkedList(Object elem) {
        Node nod = new Node(elem);
        this.head = nod;
        this.tail = nod;
        this.size = 1;
    }

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public ImmutableLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
        Node nod = head;
        int i = 1;
        while (nod.getNext() != null) {
            nod = nod.getNext();
            i++;
        }
        this.size = i;
    }

    private void indexCheck(int index)
            throws IndexOutOfBoundsException {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node goTo(int index) {
        Node nod;
        if (index >= size/2) {
            nod = this.head;
            for (int i = 0; i < index; i++) {
                nod = nod.getNext();
            }
        }
        else {
            nod = this.tail;
            for (int i = size - 1; i > index; i--) {
                nod = nod.getPrev();
            }
        }
        return nod;
    }

    private Node[] copyAll() {
        Node newHead = this.head.copyNextNull();
        Node iterNode = this.head;
        Node iterNodeNew = newHead;
        while (iterNode.getNext() != null) {
            iterNodeNew.setNext(iterNode.getNext().copyNextNull());
            iterNodeNew = iterNodeNew.getNext();
            iterNode = iterNode.getNext();
        }
        return new Node[] {newHead, iterNodeNew};
    }

    public ImmutableLinkedList addFirst(Object e) {
        Node[] newHeadAndTail = this.copyAll();
        Node newHead = new Node(e, newHeadAndTail[0], null);
        newHeadAndTail[0].setPrev(newHead);
        return new ImmutableLinkedList(newHead, newHeadAndTail[1]);
    }

    public ImmutableLinkedList addLast(Object e) {
        Node[] newHeadAndTail = this.copyAll();
        Node newTail = new Node(e, null, newHeadAndTail[1]);
        newHeadAndTail[1].setNext(newTail);
        return new ImmutableLinkedList(newHeadAndTail[0], newTail);
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return addLast(e);
    }

    @Override
    public ImmutableList add(int index, Object e)
            throws IndexOutOfBoundsException {
        indexCheck(index);
        if (index == 0) {
//            Node newNode = Node(e, this.h)
        }
        Node indexNode = this.goTo(index);
        Node nextIndexNode = indexNode.getNext();
//        indexNode.setNext(Node(e, nextIndexNode, indexNode.getPrev()));
        return null;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return null;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        Node iterNode = this.head;
        while (iterNode.getNext() != null) {
            buf.append(String.valueOf(iterNode.getElem()));
            buf.append(", ");
            iterNode = iterNode.getNext();
        }
        buf.append(String.valueOf(iterNode.getElem()));
        buf.append(", ");
        return buf.toString();
    }
}
