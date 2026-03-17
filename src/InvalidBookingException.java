/**
 * Custom exception for invalid booking operations.
 * Version: 9.0
 */
public class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}