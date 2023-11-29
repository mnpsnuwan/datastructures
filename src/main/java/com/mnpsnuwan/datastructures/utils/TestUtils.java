package com.mnpsnuwan.datastructures.utils;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link TestUtils}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 29Nov2023
 * Time : 11:37 AM
 */
public final class TestUtils
{

    // Generates a list of random values where every number is between
    // [min, max) and there are possible repeats.
    public static List<Integer> randomIntegerList( int sz, int min, int max )
    {
        List<Integer> lst = new ArrayList<>( sz );
        for( int i = 0; i < sz; i++ ) lst.add( randInt( min, max ) );
        return lst;
    }

    // Generates a list of shuffled values where every number in the array
    // is in the range of [0, sz)
    public static List<Integer> randomUniformUniqueIntegerList( int sz )
    {
        List<Integer> lst = new ArrayList<>( sz );
        for( int i = 0; i < sz; i++ ) lst.add( i );
        Collections.shuffle( lst );
        return lst;
    }

    public static List<Integer> randomUniformUniqueIntegerList( int min, int max )
    {
        List<Integer> lst = new ArrayList<>( max - min );
        for( int i = min; i < max; i++ ) lst.add( i );
        Collections.shuffle( lst );
        return lst;
    }

    // Generates a random int between [min, max)
    public static int randInt( int min, int max )
    {
        return min + ( int ) ( Math.random() * ( ( max - min ) ) );
    }

    // Generates a random long between [min, max)
    public static long randLong( long min, long max )
    {
        return min + ( long ) ( Math.random() * ( ( max - min ) ) );
    }

    // Generates sorted data in the range of [min,max[
    public static List<Integer> sortedIntegerList( int min, int max )
    {
        List<Integer> lst = new ArrayList<>( max - min );
        for( int i = min; i < max; i++ ) lst.add( i );
        return lst;
    }
}
