package com.cg.onlinefooddeliverysystem.service;
/**
 * Exception thrown to indicate that an order is invalid.
 * <p>
 * This exception is a custom unchecked exception, extending {@link RuntimeException}.
 * It can be used to signal invalid order conditions in e-commerce or ordering systems.
 * </p>
 *
 * <pre>
 * Example usage:
 *   if (order == null || !order.isValid()) {
 *       throw new InvalidOrderException("Order is invalid: missing product details");
 *   }
 * </pre>
 *
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
     *
     * @param message the detail message. This will override the default message.
     */
    InvalidOrderException(String message) {
        this.message = message;
    }

    /**
     * Returns the detail message string of this exception.
     *
     * @return the detail message string.
     */
    public String getmessage() {
        return message;
    }
}
