package com.mnpsnuwan.datastructures.queue;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link IntQueue}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 20Nov2023
 * Time : 2:21 PM
 */
public class IntQueue implements Queue<Integer>
{

    private final int[] data;
    private int front, end;
    private int size;

    // maxSize is the maximum number of items
    // that can be in the queue at any given time
    public IntQueue( int maxSize )
    {
        front = end = size = 0;
        data = new int[maxSize];
    }

    // Return true/false on whether the queue is empty
    public boolean isEmpty()
    {
        return size == 0;
    }

    // Return the number of elements inside the queue
    public int size()
    {
        return size;
    }

    @Override
    public Integer peek()
    {
        if( isEmpty() )
        {
            throw new RuntimeException( "Queue is empty" );
        }
        front = front % data.length;
        return data[front];
    }

    public boolean isFull()
    {
        return size == data.length;
    }

    // Add an element to the queue
    @Override
    public void offer( Integer value )
    {
        if( isFull() )
        {
            throw new RuntimeException( "Queue too small!" );
        }
        data[end++] = value;
        size++;
        end = end % data.length;
    }

    // Make sure you check is the queue is not empty before calling poll!
    @Override
    public Integer poll()
    {
        if( size == 0 )
        {
            throw new RuntimeException( "Queue is empty" );
        }
        size--;
        front = front % data.length;
        return data[front++];
    }

    // Example usage
    public static void main( String[] args )
    {

        IntQueue q = new IntQueue( 5 );

        q.offer( 1 );
        q.offer( 2 );
        q.offer( 3 );
        q.offer( 4 );
        q.offer( 5 );

        System.out.println( q.poll() ); // 1
        System.out.println( q.poll() ); // 2
        System.out.println( q.poll() ); // 3
        System.out.println( q.poll() ); // 4

        System.out.println( q.isEmpty() ); // false

        q.offer( 1 );
        q.offer( 2 );
        q.offer( 3 );

        System.out.println( q.poll() ); // 5
        System.out.println( q.poll() ); // 1
        System.out.println( q.poll() ); // 2
        System.out.println( q.poll() ); // 3

        System.out.println( q.isEmpty() ); // true

        benchMarkTest();
    }

    // BenchMark IntQueue vs ArrayDeque.
    private static void benchMarkTest()
    {

        int n = 10000000;
        IntQueue intQ = new IntQueue( n );

        // IntQueue times at around 0.0324 seconds
        long start = System.nanoTime();
        for( int i = 0; i < n; i++ ) intQ.offer( i );
        for( int i = 0; i < n; i++ ) intQ.poll();
        long end = System.nanoTime();
        System.out.println( "IntQueue Time: " + ( end - start ) / 1e9 );

        // ArrayDeque times at around 1.438 seconds
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();

        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for( int i = 0; i < n; i++ ) arrayDeque.offer( i );
        for( int i = 0; i < n; i++ ) arrayDeque.poll();
        end = System.nanoTime();
        System.out.println( "ArrayDeque Time: " + ( end - start ) / 1e9 );
    }
}
