

package com.cg.onlinefooddeliverysystem.Exceptions;

/**
 * Exception thrown to indicate that an order is invalid.
 * @author Dipan Mukherjee
 * @since 1.0
 */
public class InvalidOrderException extends RuntimeException {

    /**
     * Default exception message for invalid orders.
     */

    public static String message = "Invalid Order";

    /**
     * Constructs a new InvalidOrderException with the specified detail message.
     * @param message the detail message. This will override the default message.
     */
    public InvalidOrderException(String message) {
        this.message = message;
    }
    /**a
     * @return the detail message string.
     */
    public String getmessage() {
        return message;
    }

}

