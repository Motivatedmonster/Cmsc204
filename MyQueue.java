package assignment2;

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {

	private T[] myQ;
	int front;
	int rear;
	int maxSize;
	int size;
	int numOfElements = 0;
	int availableSpot = 0;
	public MyQueue(int maxSize) {
			this.maxSize =  maxSize;
			myQ = (T[]) new Object[maxSize];
			front = 0;
	        rear = -1;
	        size = 0;
		}
		public boolean isEmpty() {
	if (size == 0){
		return true;
				}
			return false;
		}
		public boolean isFull() {
	if (size == maxSize) {
				return true;
			}
			return false;
			}
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
		        throw new QueueUnderflowException();  
			}
		T tobeReturned = myQ[front];
		for (int i = 0; i < myQ.length-1; i++) {
				myQ[i] = myQ[i+1];
		}
		myQ[myQ.length -1] = null;
	size--;
			availableSpot--;
			return tobeReturned;
		}
	public int size() {
		return size;
		} 
		public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
				throw new QueueOverflowException();

				}
			myQ[availableSpot] = e;
			availableSpot++;
			size++;
			return true;
		}
		@Override
		public String toString() {
			if (isEmpty()) {
				return "";
			}
			StringBuilder sb = new StringBuilder();
			 int count = 0;
			    for (int i = front; count < size; i = (i + 1) % maxSize) { 
			        sb.append(myQ[i]);
			    }
			    return sb.toString();
		}
		@Override
		public String toString(String delimiter) {
			if (size == 0) {
				return "";
			}
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for (int i = front; count < size; i = (i + 1) % maxSize) {
				sb.append(myQ[i]);
				if (count < size - 1) {
				sb.append(delimiter);
			} 
				count++;
			}
			return sb.toString();
		}
		
		public void fill(ArrayList<T> list) throws QueueOverflowException {
		    ArrayList<T> copiedList = new ArrayList<>(list);
		    for (T item : copiedList) {
		        if (isFull()) {
		            throw new QueueOverflowException();  
		        }
		        enqueue(item);  
		    }
		}

}
