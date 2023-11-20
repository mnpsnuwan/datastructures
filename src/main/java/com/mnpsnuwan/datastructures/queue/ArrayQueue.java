package com.mnpsnuwan.datastructures.queue;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link ArrayQueue}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 20Nov2023
 * Time : 2:20 PM
 */
public class ArrayQueue<T> implements Queue<T>
{
    private final Object[] data;
    private int front;
    private int rear;

    public ArrayQueue( int capacity )
    {
        // ArrayQueue maximum size is data.length - 1.
        data = new Object[capacity + 1];
        front = 0;
        rear = 0;
    }

    @Override
    public void offer( T elem )
    {
        if( isFull() )
        {
            throw new RuntimeException( "Queue is full" );
        }
        data[rear++] = elem;
        rear = adjustIndex( rear, data.length );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public T poll()
    {
        if( isEmpty() )
        {
            throw new RuntimeException( "Queue is empty" );
        }
        front = adjustIndex( front, data.length );
        return ( T ) data[front++];
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public T peek()
    {
        if( isEmpty() )
        {
            throw new RuntimeException( "Queue is empty" );
        }
        front = adjustIndex( front, data.length );
        return ( T ) data[front];
    }

    @Override
    public int size()
    {
        return adjustIndex( rear + data.length - front, data.length );
    }

    @Override
    public boolean isEmpty()
    {
        return rear == front;
    }

    public boolean isFull()
    {
        return ( front + data.length - rear ) % data.length == 1;
    }

    private int adjustIndex( int index, int size )
    {
        return index >= size ? index - size : index;
    }
}
