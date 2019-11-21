/**
 * File: MyQueue.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.Iterator; 
public class MyQueue<T> implements Iterable<T>
{

	private int numItems; 
	private Node head;
	private Node tail;
	
	//node class
	private class Node {
		Node next;
		Node prev;
		T data;
		
		//node constructor 
		public Node( T data, Node prev, Node next ) {
			this.next = next;
			this.prev = prev;
			this.data = data;
		}
		
		//returns next
		public Node getNext()
		{
			return this.next; 
		}
		//returns previous
		public Node getPrev()
		{
			return this.prev; 
		}
		//returns the value
		public T getValue()
		{
			return this.data; 
		}
		//sets next to a given value
		public void setNext(Node n)
		{
			this.next = n; 
		}
		//sets prev to a given value
		public void setPrev(Node p)
		{
			this.prev = p; 
		}
		//sets the value to a given value
		public void setValue(T v)
		{
			this.data= v; 
		}
	}
		//returns the size of the queue
		public int size()
		{
			// return numItems; 
			Node t = head; 
			int size = 0; 
			while (t != null)
			{
				t = t.getNext(); 
				size++; 
			}
			return size; 
		
			
		}

	//allows for the use of foreach loops
	private class MyQueueIterator implements Iterator<T> 
	{
		private Node next_node;
		
		//sets next_node to head 
		public MyQueueIterator(Node head)
		{
			this.next_node = head;
		}
		//returns the next node as null
		public boolean hasNext() 
		{
			return this.next_node != null;
		}
		
		public T next()  
		{
			if (next_node != null)
			{
				T d = this.next_node.getValue();
				this.next_node = next_node.getNext();
				return d;
			}
			return null; 
		}
		
		public void remove() {;}
	}
	//queue constructor 
	public MyQueue() {
		numItems = 0; 
		this.head = null;
		this.tail = null;
	}
	//returns the iterator with head as a parameter 
	public Iterator <T> iterator()
	{
		return new MyQueueIterator(this.head); 
	}
	
	//acts as add method
	public void offer( T data ) {
		Node n = new Node( data, null, null );
		if (this.head == null) {
			this.head = n;
			this.tail = n;
			numItems++; 
			return; 
		}
		this.tail.next = n;
		n.prev = this.tail;
		this.tail = n;
		numItems++; 
	}
	//acts as remove method
	public T poll() {
		if (this.head == null) {
			return null;
		}
		T ret = this.head.data;
		this.head = this.head.next;
		if (this.head == null) {
			this.tail = null;
		}
		else {
			this.head.prev = null;
		}
		numItems--; 
		return ret;
		
	}
	//looks at the front of the list 
	public T peek()
	{
		if (this.head == null) 
		{
		return null;
		}
		else
		{
		return this.head.getValue(); 
		}
	}
	
	//main test code 
	public static void main( String[] args ) 
	{
	MyQueue<String> s = new MyQueue<String>(); 
	s.offer("A"); 
	s.offer("B"); 
	s.offer("C"); 
	System.out.println(s.size()); 
	for (String o: s ) {
		System.out.println( o );
	}
	s.poll();  
	s.poll(); 
	s.poll(); 
	for (String o: s ) {
		System.out.println( o );
	}
	System.out.println("peek"); 
	System.out.println(s.peek()); 
	System.out.println(s.size()); 
	}
	
}