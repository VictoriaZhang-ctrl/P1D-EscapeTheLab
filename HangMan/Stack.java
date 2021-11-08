/**
 -/**
 * Write a description of class Stack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Iterator;
public class Stack<E> implements Iterable<E>
{
    private Node first;
    private class Node
    {
        private E item;
        private Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public E pop()
    {
        E item = first.item;
        first = first.next;
        return item;
    }

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