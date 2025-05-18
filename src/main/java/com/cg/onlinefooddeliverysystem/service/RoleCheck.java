package com.cg.onlinefooddeliverysystem.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation is used to set what role is needed to use a class
 * @author Ujjaini Mukherjee
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

//custom annotation is used
@interface RoleCheck {
	
// returns the name of the required role	
	String role();
}
