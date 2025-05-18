
package com.cg.onlinefooddeliverysystem.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * The {@code RoleCheck} annotation is used to specify a required role for a class.
 * This annotation can be applied to any type (class, interface, enum) at runtime,
 * and it is typically used for role-based security checks within the application.
 * @author Ujjaini Mukherjee
 * @since 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleCheck {
	/**
     * Specifies the required role for the annotated class.
     *
     * @return the name of the required role
     */
	String role();
}
