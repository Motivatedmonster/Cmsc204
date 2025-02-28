package assignment2;

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{
	private T[] myS;
	int maxSize;
	int size;
	int top;
	
	
	public MyStack(int maxSize) {
		this.maxSize =  maxSize;
		myS = (T[]) new Object[maxSize];
		top=-1;
	}
	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isFull() {
		if (top == maxSize - 1) {
			return true;
		}
		return false;
	}
	@Override
	public T pop() throws StackUnderflowException {
		T toBeReturned;
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		
		 toBeReturned = myS[top];
		 top--;
		return toBeReturned;
	}
	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
			
		
		return myS[top];
	}
	@Override
	public int size() {
		
		return top + 1;
	}
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		int newTop = top + 1;
		myS[newTop] = e;
		top++;
		return true;
	}
	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i= 0; i <= top; i++) {
			sb.append(myS[i]);
			
		} 
		return sb.toString();
	}
	@Override
	public String toString(String delimiter) {
		if (isEmpty()) {
			return "";
		}	
		StringBuilder sb = new StringBuilder();
			for(int i = 0; i <= top; i++) {
				sb.append(myS[i]);
				if(i < top) {
				sb.append(delimiter);
				}
			}
		return sb.toString();
	}
	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
	    ArrayList<T> copiedList = new ArrayList<>(list);
	    for (T i : copiedList) {
	        if (isFull()) {
	            throw new StackOverflowException();  
	        }
	        push(i);
	    }
	}

}
