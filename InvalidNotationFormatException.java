package assignment2;


public class InvalidNotationFormatException extends Exception {
    
    
    public InvalidNotationFormatException() {
        super("Invalid notation format detected.");
    }

    
    public InvalidNotationFormatException(String message) {
        super(message);
    }
}
