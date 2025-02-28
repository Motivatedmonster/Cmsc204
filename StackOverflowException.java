package assignment2;

public class StackOverflowException extends Exception {
 public StackOverflowException() {
	 super("Stack is full. Can't push");
 }
 
}
