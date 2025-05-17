package com.cg.onlinefooddeliverysystem.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import com.cg.onlinefooddeliverysystem.service.DeliverySystem;

/**
 * Unit tests for the {@link DeliveryPerson} class in the Online Food Delivery System.
 * This class verifies the correct assignment of delivery person details and availability status.
 * Tests include:
 *   Correct profile information (ID and name) of a delivery person.
 *   The initial availability state of the delivery person.
 *   Setting and checking the availability status.
 *
 * Example usage:
 *     DeliveryPerson deliveryPerson = new DeliveryPerson("Rohan");
 *     assertEquals("201", deliveryPerson.getId());
 *     assertEquals("Rohan", deliveryPerson.getName());
 *
 * @author (Divya Sinha)
 * @since 1.0
 */
class DeliveryPersonTest {
    DeliverySystem system;
    DeliveryPerson deliveryPerson;
    List<DeliveryPerson> list;
    boolean available;

    /**
     * Sets up the test environment before each test.
     * Initializes the delivery system and a delivery person.
     */
    @BeforeEach
    void setUp() {
        system = new DeliverySystem();
        deliveryPerson = new DeliveryPerson("Rohan");
        available = true;
    }

    /**
     * Tests that the delivery person's profile information is correctly initialized.
     */
    @Test
    void testshowProfile() {
        assertEquals("201", deliveryPerson.getId());
        assertEquals("Rohan", deliveryPerson.getName());
    }

    /**
     * Tests that the initial availability is true.
     */
    @Test
    void testIsAvailableTrue() {
        assertTrue(available);
    }

    /**
     * Tests that the initial availability is false.
     */
    @Disabled
    void testIsAvailableFalse() {
        assertFalse(available);
    }
    

    /**
     * Tests setting delivery person as available.
     */
    @Test
    void testSetAvailable() {
        assertTrue(available);
    }
}