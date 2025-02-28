package assignment2;

public class QueueOverflowException extends Exception {
		public  QueueOverflowException() {
			super("Queue is full");
		}
}
