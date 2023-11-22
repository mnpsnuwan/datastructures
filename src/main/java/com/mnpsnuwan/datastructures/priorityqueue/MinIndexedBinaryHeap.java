package com.mnpsnuwan.datastructures.priorityqueue;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link MinIndexedBinaryHeap}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 22Nov2023
 * Time : 11:31 AM
 */
public class MinIndexedBinaryHeap<T extends Comparable<T>> extends MinIndexedDHeap<T>
{
    public MinIndexedBinaryHeap( int maxSize )
    {
        super( 2, maxSize );
    }
}
