package com.mnpsnuwan.datastructures.suffixarray;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.*;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link SuffixArrayTest}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 08Dec2023
 * Time : 1:31 PM
 */
public class SuffixArrayTest
{
    String ASCII_LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @BeforeEach
    public void setup()
    {
    }

    @Test
    public void suffixArrayLength()
    {
        String str = "ABCDE";

        SuffixArray sa1 = new SuffixArraySlow( str );
        SuffixArray sa2 = new SuffixArrayMedium( str );
        SuffixArray sa3 = new SuffixArrayFast( str );

        assertThat( sa1.getSa().length ).isEqualTo( str.length() );
        assertThat( sa2.getSa().length ).isEqualTo( str.length() );
        assertThat( sa3.getSa().length ).isEqualTo( str.length() );
    }

    @Test
    public void lcsUniqueCharacters()
    {

        SuffixArray sa1 = new SuffixArraySlow( ASCII_LETTERS );
        SuffixArray sa2 = new SuffixArrayMedium( ASCII_LETTERS );
        SuffixArray sa3 = new SuffixArrayFast( ASCII_LETTERS );

        SuffixArray[] suffixArrays = { sa1, sa2, sa3 };

        for( SuffixArray sa : suffixArrays )
        {
            for( int i = 0; i < sa.getSa().length; i++ )
            {
                assertThat( sa.getLcpArray()[i] ).isEqualTo( 0 );
            }
        }
    }

    @Test
    public void increasingLCPTest()
    {

        String UNIQUE_CHARS = "KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK";

        SuffixArray sa1 = new SuffixArraySlow( UNIQUE_CHARS );
        SuffixArray sa2 = new SuffixArrayMedium( UNIQUE_CHARS );
        SuffixArray sa3 = new SuffixArrayFast( UNIQUE_CHARS );

        SuffixArray[] suffixArrays = { sa1, sa2, sa3 };

        for( SuffixArray sa : suffixArrays )
        {
            for( int i = 0; i < sa.getSa().length; i++ )
            {
                assertThat( sa.getLcpArray()[i] ).isEqualTo( i );
            }
        }
    }

    @Test
    public void lcpTest1()
    {

        String text = "ABBABAABAA";
        int[] lcpValues = { 0, 1, 2, 1, 4, 2, 0, 3, 2, 1 };

        SuffixArray sa1 = new SuffixArraySlow( text );
        SuffixArray sa2 = new SuffixArrayMedium( text );
        SuffixArray sa3 = new SuffixArrayFast( text );

        SuffixArray[] suffixArrays = { sa1, sa2, sa3 };

        for( SuffixArray sa : suffixArrays )
        {
            for( int i = 0; i < sa.getSa().length; i++ )
            {
                assertThat( lcpValues[i] ).isEqualTo( sa.getLcpArray()[i] );
            }
        }
    }

    @Test
    public void lcpTest2()
    {
        String text = "ABABABAABB";
        int[] lcpValues = { 0, 1, 3, 5, 2, 0, 1, 2, 4, 1 };

        SuffixArray sa1 = new SuffixArraySlow( text );
        SuffixArray sa2 = new SuffixArrayMedium( text );
        SuffixArray sa3 = new SuffixArrayFast( text );

        SuffixArray[] suffixArrays = { sa1, sa2, sa3 };

        for( SuffixArray sa : suffixArrays )
        {
            for( int i = 0; i < sa.getSa().length; i++ )
            {
                assertThat( lcpValues[i] ).isEqualTo( sa.getLcpArray()[i] );
            }
        }
    }

    @Test
    public void saConstruction()
    {
        // Test inspired by LCS. Make sure constructed SAs are equal.
        // Use digits 0-9 to fake unique tokens
        String text = "BAAAAB0ABAAAAB1BABA2ABA3AAB4BBBB5BB";

        SuffixArray sa1 = new SuffixArraySlow( text );
        SuffixArray sa2 = new SuffixArrayMedium( text );
        SuffixArray sa3 = new SuffixArrayFast( text );
        SuffixArray[] suffixArrays = { sa1, sa2, sa3 };

        for( int i = 0; i < suffixArrays.length; i++ )
        {
            for( int j = i + 1; j < suffixArrays.length; j++ )
            {
                SuffixArray s1 = suffixArrays[i];
                SuffixArray s2 = suffixArrays[j];
                for( int k = 0; k < s1.getSa().length; k++ )
                {
                    assertThat( s1.getSa()[k] ).isEqualTo( s2.getSa()[k] );
                }
            }
        }
    }
}
