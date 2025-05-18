package com.cg.onlinefooddeliverysystem.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

/**
 * This class contains test cases for all the methods in the Customer class 
 * All the possible test cases have been implemented in this class.
 *
 * @author Divya Sinha
 * @since 1.0
 */

public class CustomerTest {

	/**
     * This case resets the idCounter variable of the Customer class.
     * If an exception occurs in case the reflection access fails, it is handled using try-catch block.
     */
	@Before
	public void resetIdCounter() {
	    try {
	        Field field = Customer.class.getDeclaredField("idCounter");
	        field.setAccessible(true);
	        field.setInt(null, 100);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to reset idCounter", e);
	    }
	}


    /**
     * Tests that a customer is correctly created with the given name and an incremented ID.
     */
    @Test
    public void testCustomerAddition() {
        Customer customer = new Customer("Aditi");

        assertEquals("Aditi", customer.getName());
        assertEquals("101", customer.getId());
    }

    /**
     * Tests that each new customer receives a unique, incremented ID.
     */
    @Test
    public void testCustomerId() {
        Customer customer1 = new Customer("Biswajit");
        Customer customer2 = new Customer("Dipon");

        assertNotEquals(customer1.getId(),customer2.getId());
    }

    /**
     * Tests that the showProfile method outputs the correct customer profile details.
     */
    @Test
    public void testShowProfile() {
        Customer customer = new Customer("Divya");

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream ori = System.out;
        System.setOut(new PrintStream(b));

        customer.showProfile();

        String expected = "Customer ID: " + customer.getId() + ", Name: " + customer.getName() + System.lineSeparator();
        assertEquals(expected, b.toString());

        System.setOut(ori);
    }
    
    /**
     * @param unexpected
     * @param actual
     */
 // AssertNotEquals() was not there in JUnit 4 so we declare it as our own custom method
    private void assertNotEquals(Object unexpected, Object actual) {
        assertFalse("Expected values to be different, but both were: " + actual,
                (unexpected == null && actual == null) || (unexpected != null && unexpected.equals(actual)));
    }
}