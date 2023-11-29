package com.mnpsnuwan.datastructures.hashtable;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link HashTableLinearProbing}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 29Nov2023
 * Time : 10:56 AM
 */
public class HashTableLinearProbing<K, V> extends HashTableOpenAddressingBase<K,V>
{

    // This is the linear constant used in the linear probing, it can be
    // any positive number. The table capacity will be adjusted so that
    // the GCD(capacity, LINEAR_CONSTANT) = 1 so that all buckets can be probed.
    private static final int LINEAR_CONSTANT = 17;

    public HashTableLinearProbing()
    {
        super();
    }

    public HashTableLinearProbing( int capacity )
    {
        super( capacity );
    }

    public HashTableLinearProbing( int capacity, double loadFactor )
    {
        super( capacity, loadFactor );
    }

    @Override
    protected void setupProbing( K key )
    {
    }

    @Override
    protected int probe( int x )
    {
        return LINEAR_CONSTANT * x;
    }

    // Adjust the capacity so that the linear constant and
    // the table capacity are relatively prime.
    @Override
    protected void adjustCapacity()
    {
        while( gcd( LINEAR_CONSTANT, capacity ) != 1 )
        {
            capacity++;
        }
    }
}
