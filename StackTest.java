import java.util.ArrayList;
import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack st = new Stack();
		
		MyStack<Integer> stack = new MyStack(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		
	//	System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		//System.out.println(stack.pop());

	}
}

class MyStack<T>
{
	//T array[]; // = new int[ ? ]
	ArrayList<T> A;
	int top=-1;
	int size;
	
	public MyStack(int size) {
		this.size = size;
		A = new ArrayList<T>(size);
		//array = (T[]) new Object [ size ];
	}
	void push(T item) {
			
		if(top+1 >= size)
			throw new StackOverFlowException("Stack is full");
		
		++top;
		A.add(item);
		//array [ ++top ] = item;
	}
	
	T pop() {
		if(top==-1) 
			throw new EmptyStackExeption("Stack is Empty");
		
		return A.get(top--);
		//return array [ top-- ];
	}
	
	T peek() {
		if(top==-1) 
			throw new EmptyStackExeption("Stack is Empty");
		
		return A.get(top);
	}
}

class StackOverFlowException extends RuntimeException
{

	public StackOverFlowException(String message) {
		super(message);
	}
	
}

class EmptyStackExeption extends RuntimeException {
	EmptyStackExeption(String str) {
		super(str);
	}
}

