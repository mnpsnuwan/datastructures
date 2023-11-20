package com.mnpsnuwan.datastructures.dynamicarray;

import com.mnpsnuwan.datastructures.utils.ArrayToString;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link IntArray}
 * Author : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 17Nov2023
 * Time : 4:06 PM
 */
public class IntArray implements Iterable<Integer>
{

    private static final int DEFAULT_CAP = 1 << 3;

    public int[] arr;
    public int len = 0;
    private int capacity;

    // Initialize the array with a default capacity
    public IntArray()
    {
        this( DEFAULT_CAP );
    }

    // Initialize the array with a certain capacity
    public IntArray( int capacity )
    {
        if( capacity < 0 ) throw new IllegalArgumentException( "Illegal Capacity: " + capacity );
        this.capacity = capacity;
        arr = new int[capacity];
    }

    // Given an array make it a dynamic array!
    public IntArray( int[] array )
    {
        if( array == null ) throw new IllegalArgumentException( "Array cannot be null" );
        arr = java.util.Arrays.copyOf( array, array.length );
        capacity = len = array.length;
    }

    // Returns the size of the array
    public int size()
    {
        return len;
    }

    // Returns true/false on whether the array is empty
    public boolean isEmpty()
    {
        return len == 0;
    }

    // To get/set values without method call overhead you can do
    // array_obj.arr[index] instead, you can gain about 10x the speed!
    public int get( int index )
    {
        return arr[index];
    }

    public void set( int index, int elem )
    {
        arr[index] = elem;
    }

    // Add an element to this dynamic array
    public void add( int elem )
    {
        if( len + 1 >= capacity )
        {
            if( capacity == 0 ) capacity = 1;
            else capacity *= 2; // double the size
            arr = java.util.Arrays.copyOf( arr, capacity ); // pads with extra 0/null elements
        }
        arr[len++] = elem;
    }

    // Removes the element at the specified index in this list.
    // If possible, avoid calling this method as it take O(n) time
    // to remove an element (since you have to reconstruct the array!)
    public void removeAt( int rm_index )
    {
        System.arraycopy( arr, rm_index + 1, arr, rm_index, len - rm_index - 1 );
        --len;
        --capacity;
    }

    // Search and remove an element if it is found in the array
    // If possible, avoid calling this method as it take O(n) time
    public boolean remove( int elem )
    {
        for( int i = 0; i < len; i++ )
        {
            if( arr[i] == elem )
            {
                removeAt( i );
                return true;
            }
        }
        return false;
    }

    // Reverse the contents of this array
    public void reverse()
    {
        for( int i = 0; i < len / 2; i++ )
        {
            int tmp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = tmp;
        }
    }

    // Perform a binary search on this array to find an element in O(log(n)) time
    // Make sure this array is sorted! Returns a value < 0 if item is not found
    public int binarySearch( int key )
    {
        // if (index < 0) index = -index - 1; // If not found this will tell you where to insert
        return java.util.Arrays.binarySearch( arr, 0, len, key );
    }

    // Sort this array
    public void sort()
    {
        java.util.Arrays.sort( arr, 0, len );
    }

    // Iterator is still fast but not as fast as iterative for loop
    @Override
    public java.util.Iterator<Integer> iterator()
    {
        return new java.util.Iterator<>()
        {

            int index = 0;

            public boolean hasNext()
            {
                return index < len;
            }

            public Integer next()
            {
                return arr[index++];
            }

            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString()
    {
        Integer[] integers = Arrays.stream( arr ).boxed().toArray( Integer[]::new );
        ArrayToString<Integer> arrayToString = new ArrayToString<>();
        return arrayToString.toString( integers, len );
    }

    // Example usage
    public static void main( String[] args )
    {

        IntArray ar = new IntArray( 50 );
        ar.add( 3 );
        ar.add( 7 );
        ar.add( 6 );
        ar.add( -2 );

        if( !ar.isEmpty() )
        {
            ar.add( 10 );
            ar.add( 8 );
            boolean remove = ar.remove( 7 );
            System.out.println( ar + "--" + remove );

            ar.sort(); // [-2, 3, 6, 8, 10]
            ar.set( 2, 5 );
        }

        // Prints [-2, 3, 5, 8, 10]
        for( int i = 0; i < ar.size(); i++ )
            System.out.println( ar.get( i ) );

        ar.reverse();
        // Prints [10, 8, 5, 3, -2]
        System.out.println( ar );
    }
}
