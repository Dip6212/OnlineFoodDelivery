

package com.cg.onlinefooddeliverysystem.Exceptions;
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


}

