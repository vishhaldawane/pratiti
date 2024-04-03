import java.util.ArrayList;
import java.util.Stack;

public class QueueTest {
	public static void main(String[] args) {
		
		MyQueue<Integer> que = new MyQueue<Integer>(5);
		que.add(10);
		que.add(20);
		System.out.println(que.last());

		que.add(30);
		que.add(40);
		System.out.println(que.last());

		
		que.add(50);
		//que.add(60);
		//que.add(70);
		
	//	que.remove();
	//	que.remove();
	//	que.remove();
	//	que.remove();
	//	que.remove();
	//	que.remove();
		
		System.out.println(que.front());
		
		System.out.println(que.last());
		
		
				
/*		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
*/
		
		//System.out.println(stack.pop());

	}
}

class MyQueue<T>
{
	//T array[]; // = new int[ ? ]
	ArrayList<T> A;
	int start=0;
	int end=0;
	
	int size;
	
	public MyQueue(int size) { //5
		this.size = size;
		//this.end = start;
		A = new ArrayList<T>(size);
	}
	void add(T item) {
		
		if(end > size-1  )
			throw new QueueFullException("Queue is full");
		
		++end;
		A.add(item);
		System.out.println(start+" added "+item+" at : "+end);

	}
	
	T remove() {
		
		if(start >= end ) 
			throw new EmptyQueueExeption("Queue is Empty");

		return A.get(start++);
/*
		if(start==end) {
			System.out.println("removing from : end is "+end);
			return A.get(end);
		}
		else {
			System.out.println("removing from start is "+(start+1));
			return A.get(start++);
		}*/
		
	}
	
	T front() {
		if(start >= end) 
			throw new EmptyQueueExeption("Stack is Empty");
		
		return A.get(start);
	}
	
	T last() {
		if(start >= end) 
			throw new EmptyQueueExeption("Stack is Empty");
		
		return A.get(end-1);
	}
}

class QueueFullException extends RuntimeException
{

	public QueueFullException(String message) {
		super(message);
	}
	
}

class EmptyQueueExeption extends RuntimeException {
	EmptyQueueExeption(String str) {
		super(str);
	}
}

