package com.mnpsnuwan.datastructures.dynamicarray;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link IntArrayTest}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 18Nov2023
 * Time : 6:11 PM
 */
public class IntArrayTest
{
    @Test
    public void testIsEmpty()
    {
        IntArray list = new IntArray();
        assertTrue( list.isEmpty() );
    }

    @Test( expected = Exception.class )
    public void testRemoveAt()
    {
        IntArray list = new IntArray();
        list.removeAt( 0 );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtIndexOutOfBounds()
    {
        IntArray list = new IntArray();
        list.add( -15 );
        list.add( -20 );
        list.add( -35 );
        list.removeAt( 3 );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtIndexOutOfBounds2()
    {
        IntArray list = new IntArray();
        for( int i = 0; i < 1000; i++ ) list.add( 789 );
        list.removeAt( 1000 );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtIndexOutOfBounds3()
    {
        IntArray list = new IntArray();
        for( int i = 0; i < 1000; i++ ) list.add( 789 );
        list.removeAt( -1 );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtIndexOutOfBounds4()
    {
        IntArray list = new IntArray();
        for( int i = 0; i < 15; i++ ) list.add( 123 );
        list.removeAt( -66 );
    }

    @Test
    public void testRemove()
    {
        IntArray list = new IntArray();
        int[] intArray = { 10, 20, 30, 40, 50 };
        for( int i : intArray ) list.add( i );

        assertTrue( list.remove( 10 ) );
        assertTrue( list.remove( 20 ) );
        assertTrue( list.remove( 30 ) );
        assertTrue( list.remove( 40 ) );

        assertFalse( list.remove( 10 ) );
        assertFalse( list.remove( 20 ) );
        assertFalse( list.remove( 30 ) );
        assertFalse( list.remove( 40 ) );
    }

    @Test
    public void testAddGet()
    {

        IntArray list = new IntArray();

        int[] elems = { 1, 2, 3, 4, 5, 6, 7 };

        for( int elem : elems ) list.add( elem );

        for( int i = 0; i < elems.length; i++ ) assertEquals( list.get( i ), elems[i] );
    }

    @Test
    public void testAddRemoveRemoveAt()
    {

        IntArray list = new IntArray( 0 );

        for( int i = 0; i < 50; i++ ) list.add( 33 );
        for( int i = 0; i < 50; i++ ) list.remove( 33 );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 50; i++ ) list.add( 44 );
        for( int i = 0; i < 50; i++ ) list.removeAt( 0 );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 100; i++ ) list.add( 50 );
        for( int i = 0; i < 100; i++ ) list.remove( 50 );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 100; i++ ) list.add( 50 );
        for( int i = 0; i < 100; i++ ) list.removeAt( 0 );
        assertTrue( list.isEmpty() );
    }

    @Test
    public void testAddSetRemove()
    {

        IntArray list = new IntArray( 0 );

        for( int i = 0; i < 50; i++ ) list.add( 22 );
        for( int i = 0; i < 50; i++ ) list.set( i, 33 );
        for( int i = 0; i < 50; i++ ) list.remove( 33 );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 50; i++ ) list.add( 22 );
        for( int i = 0; i < 50; i++ ) list.set( i, 33 );
        for( int i = 0; i < 50; i++ ) list.removeAt( 0 );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 100; i++ ) list.add( 22 );
        for( int i = 0; i < 100; i++ ) list.set( i, 33 );
        for( int i = 0; i < 100; i++ ) list.remove( 33 );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 100; i++ ) list.add( 22 );
        for( int i = 0; i < 100; i++ ) list.removeAt( 0 );
        assertTrue( list.isEmpty() );
    }
    
    @Test
    public void testBinarySearch(){
        IntArray list = new IntArray();
        int[] intArray = { 10, 20, 30, 40, 50 };
        for( int i : intArray ) list.add( i );

        assertEquals( 2,  list.binarySearch( 30 ) );
    }

    @Test
    public void testBinarySearch2(){
        IntArray list = new IntArray();
        int[] intArray = { 10, 20, 30, 40, 50 };
        for( int i : intArray ) list.add( i );

        assert  list.binarySearch( 1000 ) < 0;
    }

    @Test
    public void testSize()
    {

        IntArray list = new IntArray();

        Integer[] elems = { -76, 45, 66, 3, 54, 33 };
        for( int i = 0, sz = 1; i < elems.length; i++, sz++ )
        {
            list.add( elems[i] );
            assertEquals( list.size(), sz );
        }
    }
}
