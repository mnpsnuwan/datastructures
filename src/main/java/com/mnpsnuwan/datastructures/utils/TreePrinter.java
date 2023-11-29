package com.mnpsnuwan.datastructures.utils;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link TreePrinter}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 29Nov2023
 * Time : 11:27 AM
 */
public class TreePrinter
{

    /**
     * Node that can be printed
     */
    public interface PrintableNode
    {

        // Get left child
        PrintableNode getLeft();

        // Get right child
        PrintableNode getRight();

        // Get text to be printed
        String getText();
    }

    // Print a binary tree.
    public static String getTreeDisplay( PrintableNode root )
    {

        StringBuilder sb = new StringBuilder();
        List<List<String>> lines = new ArrayList<>();
        List<PrintableNode> level = new ArrayList<>();
        List<PrintableNode> next = new ArrayList<>();

        level.add( root );
        int nn = 1;
        int widest = 0;

        while( nn != 0 )
        {
            nn = 0;
            List<String> line = new ArrayList<>();
            for( PrintableNode n : level )
            {
                if( n == null )
                {
                    line.add( null );
                    next.add( null );
                    next.add( null );
                }
                else
                {
                    String aa = n.getText();
                    line.add( aa );
                    if( aa.length() > widest ) widest = aa.length();

                    next.add( n.getLeft() );
                    next.add( n.getRight() );

                    if( n.getLeft() != null ) nn++;
                    if( n.getRight() != null ) nn++;
                }
            }

            if( widest % 2 == 1 ) widest++;

            lines.add( line );

            List<PrintableNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perPiece = lines.get( lines.size() - 1 ).size() * ( widest + 4 );
        for( int i = 0; i < lines.size(); i++ )
        {
            List<String> line = lines.get( i );
            int hpw = ( int ) Math.floor( perPiece / 2f ) - 1;
            if( i > 0 )
            {
                for( int j = 0; j < line.size(); j++ )
                {

                    // split node
                    char c = ' ';
                    if( j % 2 == 1 )
                    {
                        if( line.get( j - 1 ) != null )
                        {
                            c = '#';
                        }
                        else
                        {
                            if( line.get( j ) != null ) c = '#';
                        }
                    }
                    sb.append( c );

                    // lines and spaces
                    if( line.get( j ) == null )
                    {
                        sb.append( " ".repeat( Math.max( 0, perPiece - 1 ) ) );
                    }
                    else
                    {
                        sb.append( ( j % 2 == 0 ? " " : "#" ).repeat( Math.max( 0, hpw ) ) );
                        sb.append( "#" );
                        sb.append( ( j % 2 == 0 ? "#" : " " ).repeat( Math.max( 0, hpw ) ) );
                    }
                }
                sb.append( '\n' );
            }
            for( String f : line )
            {
                if( f == null ) f = "";
                float lineGap = perPiece / 2f - f.length() / 2f;
                int gap1 = ( int ) Math.ceil( lineGap );
                int gap2 = ( int ) Math.floor( lineGap );

                sb.append( " ".repeat( Math.max( 0, gap1 ) ) );
                sb.append( f );
                sb.append( " ".repeat( Math.max( 0, gap2 ) ) );
            }
            sb.append( '\n' );

            perPiece /= 2;
        }
        return sb.toString();
    }
}
