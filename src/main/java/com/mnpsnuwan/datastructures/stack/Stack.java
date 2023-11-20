package com.mnpsnuwan.datastructures.stack;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Interface : {@link Stack}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 19Nov2023
 * Time : 9:45 PM
 */
public interface Stack<T>
{
    // return the number of elements in the stack
    int size();

    // return if the stack is empty
    boolean isEmpty();

    // push the element on the stack
    void push( T elem );

    // pop the element off the stack
    T pop();

    T peek();
}
