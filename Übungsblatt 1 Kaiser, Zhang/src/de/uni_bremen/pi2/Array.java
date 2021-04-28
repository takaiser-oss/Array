package de.uni_bremen.pi2;
import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Array<E> implements Iterable<E> {
    int size;
    private int capacity;
    private E[] puffer;

    @SuppressWarnings("unchecked")
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
        if (index < 0 ) throw new ArrayIndexOutOfBoundsException();

        if (capacity == 0) {
            capacity = 1;
            puffer = Arrays.copyOf(puffer, capacity );
        }

            while (index >= capacity) {
                puffer = Arrays.copyOf(puffer, capacity * 2);//capacity*2     capacity<<1;
                capacity += capacity;
            }
            puffer[index] = value;
        if (index > size) size = index + 1;
        }


    E get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return puffer[index];
    }

    @Override
// Erzeugen Iterator  Beschreibung

    public Iterator<E> iterator() {

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

            }
        };

    }
}





