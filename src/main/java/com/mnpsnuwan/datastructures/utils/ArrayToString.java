package com.mnpsnuwan.datastructures.utils;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link ArrayToString}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 18Nov2023
 * Time : 5:41 PM
 */
public class ArrayToString<T>
{
    public String toString( T[] arr, int len )
    {
        if( len == 0 )
        {
            return "[]";
        }
        else
        {
            StringBuilder sb = new StringBuilder( len ).append( "[" );
            for( int i = 0; i < len - 1; i++ ) sb.append( arr[i] ).append( ", " );
            return sb.append( arr[len - 1] ).append( "]" ).toString();
        }
    }
}
