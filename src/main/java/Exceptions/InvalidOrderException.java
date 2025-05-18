package Exceptions;
/**
 * Exception thrown to indicate that an order is invalid.
 * @author Dipan Mukherjee
 * @since 1.0
 */
public class InvalidOrderException extends RuntimeException {

    /**
     * Default exception message for invalid orders.
     */
    public static String message;

    /**
     * @param message the detail message. This will override the default message.
     */
    InvalidOrderException(String message) {
        this.message = message;
    }

    /**a
     * @return the detail message string.
     */
    public String getmessage() {
        return message;
    }
}
