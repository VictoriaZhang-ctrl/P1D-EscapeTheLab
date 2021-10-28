/**
 * Write a description of class Queue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Iterator;
public class Queue<E> implements Iterable<E>
{
    // instance variables - replace the example below with your own
    private Node first;
    private Node last;

    private class Node
    {
        private E item;
        private Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void enqueue(E item)
    {
        Node oldlast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty())
        {
            first = last;
        }
        else
        {
            oldlast.next = last;
        }

		
    }

    public E dequeue()
    {
        E item = first.item;
        first = first.next;

        if(isEmpty())
        {
            last = null;
        }

        return item;
    }
    
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {

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
