
import java.util.Iterator;
public class Queue<E> implements Iterable<E> 
{
    //create first and last node to make a stack
    private Node first;
    private Node last;
    private class Node
    {
        private E item;
        private Node next;
    }
    
    //fact Check if the stack is MT
    public boolean isEmpty()
    {
        return first == null;
    }
    
    //make a queue method
    public void enqueue(E item)
    {
        Node oldlast = last;

        last = new Node();
        last.item = item;
        last.next = null;
        
        //fact check if the stack is MT, it will make the first point to the node last
        //else the node last will call will call "oldlast" and the next node will call "last".
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
        //output the item fromt the equeue 
        E item = first.item;
        first = first.next;
        
        //fact check if the queue slot is MT
        //if MT, the last will set as null(empty)
        if(isEmpty())
        {
            last = null;
        }

        return item; //return method
    }
    
    public Iterator<E> iterator()
    {
        return new MyIterator();
    }
    
    class MyIterator implements Iterator<E>
    {
        private Node n = first;
        
        //this check if the node is MT
        public boolean hasNext() {
            return n != null;
        }
        
        
        //this will change the next item
        public E next() {
            E item = n.item;
            n = n.next;
            return item;
        }
        
        //this will stop the game
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
