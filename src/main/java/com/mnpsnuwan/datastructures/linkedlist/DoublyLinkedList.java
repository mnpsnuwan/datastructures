package com.mnpsnuwan.datastructures.linkedlist;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link DoublyLinkedList}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 19Nov2023
 * Time : 2:41 PM
 */
public class DoublyLinkedList<T> implements Iterable<T>
{
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Internal node class to represent data
    private static class Node<T>
    {
        private T data;
        private Node<T> prev, next;

        public Node( T data, Node<T> prev, Node<T> next )
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString()
        {
            return data.toString();
        }
    }

    // Empty this linked list, O(n)
    public void clear()
    {
        Node<T> traverse = head;
        while( traverse != null )
        {
            Node<T> next = traverse.next;
            traverse.prev = traverse.next = null;
            traverse.data = null;
            traverse = next;
        }
        head = tail = traverse = null;
        size = 0;
    }

    // Return the size of this linked list
    public int size()
    {
        return size;
    }

    // Is this linked list empty?
    public boolean isEmpty()
    {
        return size() == 0;
    }

    // Add an element to the tail of the linked list, O(1)
    public void add( T elem )
    {
        addLast( elem );
    }

    // Add an element to the beginning of this linked list, O(1)
    public void addFirst( T elem )
    {
        if( isEmpty() )
        {
            head = tail = new Node<>( elem, null, null );
        }
        else
        {
            head.prev = new Node<>( elem, null, head );
            head = head.prev;
        }
        size++;
    }

    // Add a node to the tail of the linked list, O(1)
    public void addLast( T elem )
    {
        if( isEmpty() )
        {
            head = tail = new Node<>( elem, null, null );
        }
        else
        {
            tail.next = new Node<>( elem, tail, null );
            tail = tail.next;
        }
        size++;
    }

    // Add an element at a specified index
    public void addAt( int index, T data ) throws Exception
    {
        if( index < 0 || index > size )
        {
            throw new Exception( "Illegal Index" );
        }
        if( index == 0 )
        {
            addFirst( data );
            return;
        }

        if( index == size )
        {
            addLast( data );
            return;
        }

        Node<T> temp = head;
        for( int i = 0; i < index - 1; i++ )
        {
            temp = temp.next;
        }
        Node<T> newNode = new Node<>( data, temp, temp.next );
        temp.next.prev = newNode;
        temp.next = newNode;

        size++;
    }

    // Check the value of the first node if it exists, O(1)
    public T peekFirst()
    {
        if( isEmpty() ) throw new RuntimeException( "Empty list" );
        return head.data;
    }

    // Check the value of the last node if it exists, O(1)
    public T peekLast()
    {
        if( isEmpty() ) throw new RuntimeException( "Empty list" );
        return tail.data;
    }

    // Remove the first value at the head of the linked list, O(1)
    public T removeFirst()
    {
        // Can't remove data from an empty list
        if( isEmpty() ) throw new RuntimeException( "Empty list" );

        // Extract the data at the head and move
        // the head pointer forwards one node
        T data = head.data;
        head = head.next;
        --size;

        // If the list is empty set the tail to null
        if( isEmpty() ) tail = null;

            // Do a memory cleanup of the previous node
        else head.prev = null;

        // Return the data that was at the first node we just removed
        return data;
    }

    // Remove the last value at the tail of the linked list, O(1)
    public T removeLast()
    {
        // Can't remove data from an empty list
        if( isEmpty() ) throw new RuntimeException( "Empty list" );

        // Extract the data at the tail and move
        // the tail pointer backwards one node
        T data = tail.data;
        tail = tail.prev;
        --size;

        // If the list is now empty set the head to null
        if( isEmpty() ) head = null;

            // Do a memory clean of the node that was just removed
        else tail.next = null;

        // Return the data that was in the last node we just removed
        return data;
    }

    // Remove an arbitrary node from the linked list, O(1)
    private T remove( Node<T> node )
    {
        // If the node to remove is somewhere either at the
        // head or the tail handle those independently
        if( node.prev == null ) return removeFirst();
        if( node.next == null ) return removeLast();

        // Make the pointers of adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // Temporarily store the data we want to return
        T data = node.data;

        // Memory cleanup
        node.data = null;
        node.prev = node.next = null;

        --size;

        // Return the data in the node we just removed
        return data;
    }

    // Remove a node at a particular index, O(n)
    public T removeAt( int index )
    {
        // Make sure the index provided is valid
        if( index < 0 || index >= size )
        {
            throw new IllegalArgumentException();
        }

        int i;
        Node<T> traverse;

        // Search from the front of the list
        if( index < size / 2 )
        {
            for( i = 0, traverse = head; i != index; i++ )
            {
                traverse = traverse.next;
            }
            // Search from the back of the list
        }
        else
        {
            for( i = size - 1, traverse = tail; i != index; i-- )
            {
                traverse = traverse.prev;
            }
        }
        return remove( traverse );
    }

    // Remove a particular value in the linked list, O(n)
    public boolean remove( Object obj )
    {
        Node<T> traverse = head;

        // Support searching for null
        if( obj == null )
        {
            for( traverse = head; traverse != null; traverse = traverse.next )
            {
                if( traverse.data == null )
                {
                    remove( traverse );
                    return true;
                }
            }
            // Search for not null object
        }
        else
        {
            for( traverse = head; traverse != null; traverse = traverse.next )
            {
                if( obj.equals( traverse.data ) )
                {
                    remove( traverse );
                    return true;
                }
            }
        }
        return false;
    }

    // Find the index of a particular value in the linked list, O(n)
    public int indexOf( Object obj )
    {
        int index = 0;
        Node<T> traverse = head;

        // Support searching for null
        if( obj == null )
        {
            for( ; traverse != null; traverse = traverse.next, index++ )
            {
                if( traverse.data == null )
                {
                    return index;
                }
            }
            // Search for not null object
        }
        else
        {
            for( ; traverse != null; traverse = traverse.next, index++ )
            {
                if( obj.equals( traverse.data ) )
                {
                    return index;
                }
            }
        }
        return -1;
    }

    // Check is a value is contained within the linked list
    public boolean contains( Object obj )
    {
        return indexOf( obj ) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator()
    {
        return new java.util.Iterator<>()
        {

            private Node<T> traverse = head;

            @Override
            public boolean hasNext()
            {
                return traverse != null;
            }

            @Override
            public T next()
            {
                T data = traverse.data;
                traverse = traverse.next;
                return data;
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "[ " );
        Node<T> traverse = head;
        while( traverse != null )
        {
            sb.append( traverse.data );
            if( traverse.next != null )
            {
                sb.append( ", " );
            }
            traverse = traverse.next;
        }
        sb.append( " ]" );
        return sb.toString();
    }
}
