package com.cg.onlinefooddeliverysystem.entity;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

/**
 * This class contains unit tests for the {@link Customer} entity class in the Online Food Delivery System.
 * It tests the correct behavior of ID assignment, name storage, and the profile display functionality.
 *
 * The tests include:
 *     Resetting the static ID counter before each test to ensure test isolation.
 *     Verifying that the customer name and ID are set correctly upon creation.
 *     Checking that the ID is incremented as expected for multiple customers.
 *     Asserting the correct output from the {@code showProfile()} method.
 *
 * Example usage:
 *     Customer customer = new Customer("Alice");
 *     customer.showProfile(); // Output: Customer ID: 101, Name: Alice
 *
 * @author (Divya Sinha)
 * @since 1.0
 */

public class CustomerTest {

    /**
     * Resets the static idCounter field of {@link Customer} before each test.
     * This ensures that customer IDs start from a known value for each test.
     *
     * @throws Exception if reflection access fails
     */
    @Before
    public void resetIdCounter() throws Exception {
        Field field = Customer.class.getDeclaredField("idCounter");
        field.setAccessible(true);
        field.setInt(null, 100); 
    }

    /**
     * Tests that a customer is correctly created with the given name and an incremented ID.
     */
    @Test
    public void testCustomerAddition() {
        Customer customer = new Customer("Alice");

        assertEquals("Alice", customer.getName());
        assertEquals("101", customer.getId());
    }

    /**
     * Tests that each new customer receives a unique, incremented ID.
     */
    @Test
    public void testCustomerIdIncrement() {
        Customer customer1 = new Customer("Bob");
        Customer customer2 = new Customer("Carol");

        assertEquals("101", customer1.getId());
        assertEquals("102", customer2.getId());
    }

    /**
     * Tests that the showProfile method outputs the correct customer profile details.
     */
    @Test
    public void testShowProfile() {
        Customer customer = new Customer("David");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        customer.showProfile();

        String expectedOutput = "Customer ID: " + customer.getId() + ", Name: " + customer.getName() + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }
}
=======
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
>>>>>>> eb866dcd42427dd9d2930b888002567c73062b79
