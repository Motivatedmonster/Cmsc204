package assignment2;

public class StackUnderflowException extends Exception {
		public StackUnderflowException() {
			super("Stack is empty. Can't pop");
		}
}
