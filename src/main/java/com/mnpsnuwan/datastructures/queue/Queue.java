package com.mnpsnuwan.datastructures.queue;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Interface : {@link Queue}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 20Nov2023
 * Time : 2:14 PM
 */
public interface Queue<T>
{
    void offer( T elem );

    T poll();

    T peek();

    int size();

    boolean isEmpty();
}
