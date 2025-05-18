package com.cg.onlinefooddeliverysystem.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Here we have test cases for the FoodItem class.
 * The test cases verify object creation, field access, equals logic, and string representation.
 * @author Divya Sinha
 * @since 1.0
 */
public class FoodItemTest {

    /**
     * Tests that FoodItem object is correctly created and fields are accessible.
     */
    @Test
    public void testFoodItemCreation() {
        FoodItem item = new FoodItem("Pizza", 8.99);

        assertEquals("Pizza", item.getName());
        assertEquals(8.99, item.getPrice(), 0.001);
    }

    /**
     * Tests equals() for case-insensitive comparison based on name with different price.
     */
    @Test
    public void testEqualsWithSameNameDifferentPrice() {
        FoodItem item1 = new FoodItem("Burger", 5.0);
        FoodItem item2 = new FoodItem("burger", 7.0);

        assertFalse(item1.equals(item2));
    }

    /**
     * Test equals() returns false for different names.
     */
    @Test
    public void testEqualsWithDifferentNames() {
        FoodItem item1 = new FoodItem("Pasta", 6.5);
        FoodItem item2 = new FoodItem("Sandwich", 6.5);

        assertFalse(item1.equals(item2));
    }

    /**
     * Tests overridden hashCode corresponding to equals().
     */
    @Test
    public void testHashCodeConsistency() {
        FoodItem item1 = new FoodItem("Salad", 4.0);
        FoodItem item2 = new FoodItem("salad", 4.0);

        // Since equals() returns true, hashCode should be the same
        assertEquals(item1.hashCode(), item2.hashCode());
    }

    /**
     * Tests the output of toString().
     */
    @Test
    public void testToString() {
        FoodItem item = new FoodItem("Soup", 3.5);
        assertEquals("Soup - $3.5", item.toString());
    }
}
