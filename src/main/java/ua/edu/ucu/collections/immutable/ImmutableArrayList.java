package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {

    private final Object[] elements;

    private void indexCheck(int index) throws IndexOutOfBoundsException {
        if (index > this.elements.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public ImmutableArrayList() {
        this.elements = new Object[] {};
    }

    public ImmutableArrayList(Object[] e) {
        this.elements = e;
    }

    @Override
    public ImmutableList add(Object e) {
        return this.add(this.elements.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) throws IndexOutOfBoundsException {
        indexCheck(index);
        Object[] newList = Arrays.copyOf(this.elements, this.elements.length + 1);
        newList[index] = e;
        for (int i = index + 1; i < this.elements.length + 1; i++) {
            newList[i] = this.elements[i-1];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(this.elements.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) throws IndexOutOfBoundsException {
        indexCheck(index);
        Object[] newList = Arrays.copyOf(this.elements, this.elements.length + c.length);
        for (int i = index; i < c.length + index; i++) {
            newList[i] = c[i - index];
        }
        for (int i = c.length + index; i < c.length + this.elements.length; i++) {
            newList[i] = this.elements[i - c.length];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException{
        indexCheck(index);
        return this.elements[index];
    }

    @Override
    public ImmutableList remove(int index) throws IndexOutOfBoundsException{
        indexCheck(index);
        Object[] newList = Arrays.copyOf(this.elements, this.elements.length - 1);
        for (int i = index; i < this.elements.length - 1; i++) {
            newList[i] = this.elements[i+1];
        }
        return new ImmutableArrayList(newList);
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
        String resString = "";
        for (int i = 0; i < this.elements.length; i++) {

            resString += String.valueOf(this.elements[i]);
            if (i != this.elements.length-1) {
                resString += ", ";
            }
        }
        return resString;
    }
}
