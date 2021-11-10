/**
 -/**
 * Write a description of class Stack here.
 */

import java.util.Iterator;
// This enables the stack method
public class Stack<E> implements Iterable<E>
{
    private Node first;
    // This will link the nodes
    private class Node
    {
        private E item;
        private Node next;
    }

    // If the stack is empty it will return nothing
    public boolean isEmpty()
    {
        return first == null;
    }

    // This is the pop method that pops the first item off the stack
    public E pop()
    {
        E item = first.item;
        first = first.next;
        return item;
    }

    // This is the push method that pushes an item on the the stack
    public void push(E item)
    {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
    }

    public Iterator<E> iterator()
    {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E>
    {
        private Node n = first;
        
        public boolean hasNext() {
            return n != null;
        }
        public E next() {
            E item = n.item;
            n = n.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}