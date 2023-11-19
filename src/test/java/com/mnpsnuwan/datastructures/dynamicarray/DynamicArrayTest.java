package com.mnpsnuwan.datastructures.dynamicarray;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link DynamicArrayTest}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 18Nov2023
 * Time : 4:46 PM
 */
public class DynamicArrayTest
{

    @Test
    public void testIsEmpty()
    {
        DynamicArray<Integer> list = new DynamicArray<>();
        assertTrue( list.isEmpty() );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtRemovingEmpty()
    {
        DynamicArray<Integer> list = new DynamicArray<>();
        list.removeAt( 0 );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtIndexOutOfBounds()
    {
        DynamicArray<Integer> list = new DynamicArray<>();
        list.add( -56 );
        list.add( -53 );
        list.add( -55 );
        list.removeAt( 3 );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtIndexOutOfBounds2()
    {
        DynamicArray<Integer> list = new DynamicArray<>();
        for( int i = 0; i < 1000; i++ ) list.add( 789 );
        list.removeAt( 1000 );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtIndexOutOfBounds3()
    {
        DynamicArray<Integer> list = new DynamicArray<>();
        for( int i = 0; i < 1000; i++ ) list.add( 789 );
        list.removeAt( -1 );
    }

    @Test( expected = Exception.class )
    public void testRemoveAtIndexOutOfBounds4()
    {
        DynamicArray<Integer> list = new DynamicArray<>();
        for( int i = 0; i < 15; i++ ) list.add( 123 );
        list.removeAt( -66 );
    }

    @Test
    public void testClear()
    {
        DynamicArray<String> list = new DynamicArray<>();
        String[] strArray = { "a", "b", "c", null, "e", "f", "g" };
        for( String s : strArray ) list.add( s );
        list.clear();
        assertEquals( 0, list.size() );
    }

    @Test
    public void testRemove()
    {
        DynamicArray<String> list = new DynamicArray<>();
        String[] strArray = { "a", "b", "c", "d", "e", null, "g", "h" };
        for( String s : strArray ) list.add( s );

        boolean ret = list.remove( "c" );
        assertTrue( ret );

        ret = list.remove( "c" );
        assertFalse( ret );

        ret = list.remove( "h" );
        assertTrue( ret );

        ret = list.remove( null );
        assertTrue( ret );

        ret = list.remove( "a" );
        assertTrue( ret );

        ret = list.remove( "a" );
        assertFalse( ret );

        ret = list.remove( "h" );
        assertFalse( ret );

        ret = list.remove( null );
        assertFalse( ret );
    }

    @Test
    public void testRemove2()
    {
        DynamicArray<String> list = new DynamicArray<>();
        String[] strArray = { "a", "b", "c", "d" };
        for( String s : strArray ) list.add( s );

        assertTrue( list.remove( "a" ) );
        assertTrue( list.remove( "b" ) );
        assertTrue( list.remove( "c" ) );
        assertTrue( list.remove( "d" ) );

        assertFalse( list.remove( "a" ) );
        assertFalse( list.remove( "b" ) );
        assertFalse( list.remove( "c" ) );
        assertFalse( list.remove( "d" ) );
    }

    @Test
    public void testIndexOfNullElement()
    {
        DynamicArray<String> list = new DynamicArray<>();
        String[] strArray = { "a", "b", null, "d" };
        for( String s : strArray ) list.add( s );
        assertEquals( 2, list.indexOf( null ) );
    }

    @Test
    public void testContains()
    {
        DynamicArray<String> list = new DynamicArray<>();
        String[] strArray = { "a", "b", "c", null, "e", "f" };
        for( String s : strArray ) list.add( s );
        assertTrue( list.contains( null ) );
    }

    @Test
    public void testAddGet()
    {

        DynamicArray<Integer> list = new DynamicArray<>();

        int[] elems = { 1, 2, 3, 4, 5, 6, 7 };

        for( int elem : elems ) list.add( elem );

        for( int i = 0; i < elems.length; i++ ) assertEquals( list.get( i ).intValue(), elems[i] );
    }

    @Test
    public void testAddRemoveRemoveAt()
    {

        DynamicArray<Long> list = new DynamicArray<>( 0 );

        for( int i = 0; i < 55; i++ ) list.add( 44L );
        for( int i = 0; i < 55; i++ ) list.remove( 44L );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 55; i++ ) list.add( 44L );
        for( int i = 0; i < 55; i++ ) list.removeAt( 0 );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 155; i++ ) list.add( 44L );
        for( int i = 0; i < 155; i++ ) list.remove( 44L );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 155; i++ ) list.add( 44L );
        for( int i = 0; i < 155; i++ ) list.removeAt( 0 );
        assertTrue( list.isEmpty() );
    }

    @Test
    public void testAddSetRemove()
    {

        DynamicArray<Long> list = new DynamicArray<>( 0 );

        for( int i = 0; i < 55; i++ ) list.add( 44L );
        for( int i = 0; i < 55; i++ ) list.set( i, 33L );
        for( int i = 0; i < 55; i++ ) list.remove( 33L );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 55; i++ ) list.add( 44L );
        for( int i = 0; i < 55; i++ ) list.set( i, 33L );
        for( int i = 0; i < 55; i++ ) list.removeAt( 0 );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 155; i++ ) list.add( 44L );
        for( int i = 0; i < 155; i++ ) list.set( i, 33L );
        for( int i = 0; i < 155; i++ ) list.remove( 33L );
        assertTrue( list.isEmpty() );

        for( int i = 0; i < 155; i++ ) list.add( 44L );
        for( int i = 0; i < 155; i++ ) list.removeAt( 0 );
        assertTrue( list.isEmpty() );
    }

    @Test
    public void testSize()
    {

        DynamicArray<Integer> list = new DynamicArray<>();

        Integer[] elems = { -76, 45, 66, 3, null, 54, 33 };
        for( int i = 0, sz = 1; i < elems.length; i++, sz++ )
        {
            list.add( elems[i] );
            assertEquals( list.size(), sz );
        }
    }
}
