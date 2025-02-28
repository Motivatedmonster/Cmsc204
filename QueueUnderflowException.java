package assignment2;

public class QueueUnderflowException extends Exception {
	 public QueueUnderflowException() {
	 super("Queue is empty");
	 }
}
