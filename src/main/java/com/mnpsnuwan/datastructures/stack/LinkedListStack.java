package com.mnpsnuwan.datastructures.stack;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link LinkedListStack}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 19Nov2023
 * Time : 9:50 PM
 */
public class LinkedListStack<T> implements Iterable<T>, Stack<T>
{

    private final java.util.LinkedList<T> list = new java.util.LinkedList<>();

    // Create an empty stack
    public LinkedListStack()
    {
    }

    // Create a Stack with an initial element
    public LinkedListStack( T firstElem )
    {
        push( firstElem );
    }

    // Return the number of elements in the stack
    public int size()
    {
        return list.size();
    }

    // Check if the stack is empty
    public boolean isEmpty()
    {
        return size() == 0;
    }

    // Push an element on the stack
    public void push( T elem )
    {
        list.addLast( elem );
    }

    // Pop an element off the stack
    // Throws an error is the stack is empty
    public T pop()
    {
        if( isEmpty() ) throw new java.util.EmptyStackException();
        return list.removeLast();
    }

    // Peek the top of the stack without removing an element
    // Throws an exception if the stack is empty
    public T peek()
    {
        if( isEmpty() ) throw new java.util.EmptyStackException();
        return list.peekLast();
    }

    // Searches for the element starting from top of the stack
    // Returns -1 if the element is not present in the stack
    public int search( T elem )
    {
        return list.lastIndexOf( elem );
    }

    // Allow users to iterate through the stack using an iterator
    @Override
    public java.util.Iterator<T> iterator()
    {
        return list.iterator();
    }
}
