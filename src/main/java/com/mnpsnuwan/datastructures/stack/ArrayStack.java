package com.mnpsnuwan.datastructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link ArrayStack}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 19Nov2023
 * Time : 9:51 PM
 */
public class ArrayStack<T> implements Stack<T> {
    private int size;
    private int capacity;
    private Object[] data;

    public ArrayStack() {
        capacity = 16;
        data = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T elem) {
        if (size == capacity) {
            increaseCapacity();
        }
        data[size++] = elem;
    }

    // Increase the capacity to store more elements.
    private void increaseCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T elem = (T) data[--size];
        data[size] = null;
        return elem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) data[size - 1];
    }
}
