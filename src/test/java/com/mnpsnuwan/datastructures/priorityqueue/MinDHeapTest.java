package com.mnpsnuwan.datastructures.priorityqueue;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.*;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link MinDHeapTest}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 22Nov2023
 * Time : 9:43 AM
 */
public class MinDHeapTest
{

    static final int LOOPS = 1000;
    static final int MAX_SZ = 100;

    @BeforeEach
    public void setup()
    {
    }

    @Test
    public void testEmpty()
    {
        MinDHeap<Integer> q = new MinDHeap<>( 4, 0 );
        assertThat( q.size() ).isEqualTo( 0 );
        assertThat( q.isEmpty() ).isTrue();
        assertThat( q.poll() ).isNull();
        assertThat( q.peek() ).isNull();
    }

    @Test
    public void testHeapProperty()
    {

        MinDHeap<Integer> q = new MinDHeap<>( 3, 30 );
        Integer[] nums = { 3, 2, 5, 6, 7, 9, 4, 8, 1 };

        // Try manually creating heap
        for( int n : nums ) q.add( n );
        for( int i = 1; i <= 9; i++ ) assertThat( q.poll() ).isEqualTo( i );
    }

    @Test
    public void testPriorityQueueSizeParam()
    {
        for( int i = 1; i < LOOPS; i++ )
        {

            Integer[] lst = genRandArray( i );

            MinDHeap<Integer> pq = new MinDHeap<>( i, lst.length );
            PriorityQueue<Integer> pq2 = new PriorityQueue<>( i );

            for( int x : lst )
            {
                pq2.add( x );
                pq.add( x );
            }
            while( !pq2.isEmpty() ) assertThat( pq.poll() ).isEqualTo( pq2.poll() );
        }
    }

    @Test
    public void testPriorityRandomOperations()
    {
        for( int loop = 0; loop < LOOPS; loop++ )
        {

            double p1 = Math.random();
            double p2 = Math.random();
            if( p2 < p1 )
            {
                double tmp = p1;
                p1 = p2;
                p2 = tmp;
            }

            Integer[] ar = genRandArray( LOOPS );
            int d = 2 + ( int ) ( Math.random() * 6 );
            MinDHeap<Integer> pq = new MinDHeap<>( d, LOOPS );
            PriorityQueue<Integer> pq2 = new PriorityQueue<>( LOOPS );

            for( int i = 0; i < LOOPS; i++ )
            {
                int e = ar[i];
                double r = Math.random();
                if( r <= p1 )
                {
                    pq.add( e );
                    pq2.add( e );
                }
                else if( r <= p2 )
                {
                    if( !pq2.isEmpty() ) assertThat( pq.poll() ).isEqualTo( pq2.poll() );
                }
                else
                {
                    pq.clear();
                    pq2.clear();
                }
            }

            assertThat( pq.peek() ).isEqualTo( pq2.peek() );
        }
    }

    @Test
    public void testClear()
    {
        String[] strArray = { "aa", "bb", "cc", "dd", "ee" };
        MinDHeap<String> q = new MinDHeap<>( 2, strArray.length );
        for( String s : strArray ) q.add( s );
        q.clear();
        assertThat( q.size() ).isEqualTo( 0 );
        assertThat( q.isEmpty() ).isTrue();
    }

    @Test
    public void testRemovingDuplicates()
    {

        Integer[] in = new Integer[] { 2, 7, 2, 11, 7, 13, 2 };
        MinDHeap<Integer> pq = new MinDHeap<>( 3, in.length + 1 );

        for( Integer x : in ) pq.add( x );
        assertThat( pq.peek() ).isEqualTo( 2 );
        pq.add( 3 );

        assertThat( pq.poll() ).isEqualTo( 2 );
        assertThat( pq.poll() ).isEqualTo( 2 );
        assertThat( pq.poll() ).isEqualTo( 2 );
        assertThat( pq.poll() ).isEqualTo( 3 );
        assertThat( pq.poll() ).isEqualTo( 7 );
        assertThat( pq.poll() ).isEqualTo( 7 );
        assertThat( pq.poll() ).isEqualTo( 11 );
        assertThat( pq.poll() ).isEqualTo( 13 );
    }

    static Integer[] genRandArray( int sz )
    {
        Integer[] lst = new Integer[sz];
        for( int i = 0; i < sz; i++ ) lst[i] = ( int ) ( Math.random() * MAX_SZ );
        return lst;
    }

    // Generate a list of random numbers
    static List<Integer> genRandList( int sz )
    {
        List<Integer> lst = new ArrayList<>( sz );
        for( int i = 0; i < sz; i++ ) lst.add( ( int ) ( Math.random() * MAX_SZ ) );
        return lst;
    }

    // Generate a list of unique random numbers
    static List<Integer> genUniqueRandList( int sz )
    {
        List<Integer> lst = new ArrayList<>( sz );
        for( int i = 0; i < sz; i++ ) lst.add( i );
        Collections.shuffle( lst );
        return lst;
    }
}
