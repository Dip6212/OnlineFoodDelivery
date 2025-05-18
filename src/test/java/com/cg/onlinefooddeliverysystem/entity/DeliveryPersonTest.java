package com.cg.onlinefooddeliverysystem.entity;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * All the methods of DeliveryPerson class are being tested here.
 * 
 * @author Divya Sinha
 * @since  1.0
 */
public class DeliveryPersonTest {

    /**
     * This case resets the idCounter variable of the DeliveryPerson class.
     * If an exception occurs in case the reflection access fails, it is handled using try-catch block.
     */
    @Before
    public void resetIdCounter() {
    	Field field;
    	try {
        field = DeliveryPerson.class.getDeclaredField("idCounter");
        field.setAccessible(true);
        field.setInt(null, 200);
    	} catch(Exception e) {
    		e.getMessage();
    	}
    }

    /**
     * This case tests that a DeliveryPerson object is created with the correct name,
     * correct incremented ID, and the isAvailable() returns true.
     */
    @Test
    public void testDeliveryPersonCreation() {
        DeliveryPerson dp = new DeliveryPerson("Sumon");

        assertEquals("Sumon", dp.getName());
        assertNotNull(dp.getId());
        assertTrue(dp.getId().matches("\\d+"));
        assertTrue(dp.isAvailable());
    }

    /**
     * This case tests that the availability status of the delivery person can be changed from true to false.
     */
    @Test
    public void testAvailabilitySetter() {
        DeliveryPerson dp = new DeliveryPerson("Ujjaini");
        dp.setAvailable(false);

        assertFalse(dp.isAvailable());
    }

    /**
     * This case tests that each Delivery Person receives a unique ID.
     */
    @Test
    public void testDeliveryPersonId() {
        DeliveryPerson dp1 = new DeliveryPerson("Yash");
        DeliveryPerson dp2 = new DeliveryPerson("Dipon");

        assertNotEquals(dp1.getId(), dp2.getId());
    }

    /**
     * Tests the output of the showProfile() method to ensure
     * it displays correct ID, name, and availability status.
     */
    @Test
    public void testShowProfile() {
        DeliveryPerson dp = new DeliveryPerson("Arjun");
        dp.setAvailable(false);

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream ori = System.out;
        System.setOut(new PrintStream(b));

        try {
            dp.showProfile();
        } finally {
            System.setOut(ori);
        }

        String output = b.toString().trim();
        assertTrue(output.contains("Delivery Person ID: " + dp.getId()));
        assertTrue(output.contains("Name: " + dp.getName()));
        assertTrue(output.contains("Available: false"));
    }

    /**
     * @param unexpected 
     * @param actual     
     */
 // AssertNotEquals() was not there in JUnit 4 so we declare it as our own custom method
    private void assertNotEquals(Object unexpected, Object actual) {
        assertFalse("Expected different values but got: " + actual,
                (unexpected == null && actual == null) ||
                (unexpected != null && unexpected.equals(actual)));
    }
}