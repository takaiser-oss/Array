package de.uni_bremen.pi2;
import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Array<E> implements Iterable<E> {
    private int size;
    private int capacity;
    private E[] puffer;

    public Array(int capacity) {
        size=0;
        this.capacity = capacity;
        puffer = (E[]) new Object[capacity];

        if (capacity < 0) {

            throw new IllegalArgumentException("capacity");
        }
    }

    int size() {
        return size;

    }

    int capacity() {
        return capacity;
    }

    void set(int index, E value) {
        if (index < 0 || (capacity == 0 && index > 1 || index > capacity * 2)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index >= capacity) {
            if (capacity == 0) {
                capacity=1;
                //puffer = Arrays.copyOf(puffer, 1);
            } else {
                puffer = Arrays.copyOf(puffer, capacity * 2);
            }
            capacity +=capacity;

        }
        puffer[index] = value;
        size++;
    }

    E get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return puffer[index];
    }

    @Override
    // Erzeugen Iterator
    public Iterator<E> iterator() {
        Iterator<E> it = Arrays.stream(puffer).iterator();
        while (it.hasNext()){
            if(it.next()==null) it.remove();
        }
        return it;
    }
        /*
        return new Iterator<E>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                if (!hasNext()) {

                    throw new NoSuchElementException();
                }
                return puffer[index++];

            }*/



}





