package com.cg.onlinefooddeliverysystem.entity;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link FoodItem} class in the Online Food Delivery System.
 * This class checks the correctness of the equals, hashCode, and toString implementations.
 * Tests include:
 *   Reflexive equality (object equals itself).
 *   Case-insensitive equality based only on name, not price.
 *   Different names are not equal.
 *   Comparison with null and different classes returns false.
 *   hashCode is consistent for names differing only in case.
 *   toString produces the expected format.
 *
 * Example usage:
 *     FoodItem item1 = new FoodItem("Pizza", 10.0);
 *     FoodItem item2 = new FoodItem("pizza", 12.0);
 *     assertEquals(item1, item2);
 *     assertEquals(item1.hashCode(), item2.hashCode());
 *
 * @author (Divya Sinha)
 * @since 1.0
 */
public class FoodItemTest {

    /**
     * Tests that a FoodItem equals itself (reflexivity).
     */
    @Test
    public void testEqualsSame() {
        FoodItem item = new FoodItem("Pizza", 10.0);
        assertEquals(item, item); 
    }

    /**
     * Tests that FoodItems with the same name (case-insensitive) but different prices are equal.
     */
    @Test
    public void testEqualsSameNameDifferentPrice() {
        FoodItem item1 = new FoodItem("Pizza", 10.0);
        FoodItem item2 = new FoodItem("pizza", 12.0); 
        assertEquals(item1, item2);
    }

    /**
     * Tests that FoodItems with different names are not equal.
     */
    @Test
    public void testEqualsDifferentNames() {
        FoodItem item1 = new FoodItem("Burger", 8.0);
        FoodItem item2 = new FoodItem("Fries", 8.0);
        assertNotEquals(item1, item2);
    }

    /**
     * Tests that a FoodItem is not equal to null.
     */
    @Test
    public void testEqualsNullComparison() {
        FoodItem item = new FoodItem("Sushi", 15.0);
        assertNotEquals(item, null);
    }

    /**
     * Tests that a FoodItem is not equal to an object of a different class.
     */
    @Test
    public void testEqualsDifferentClass() {
        FoodItem item = new FoodItem("Pasta", 9.0);
        String other = "Pasta";
        assertNotEquals(item, other);
    }

    /**
     * Tests that FoodItems with the same name (case-insensitive) have the same hash code.
     */
    @Test
    public void testHashCodeLowerCase() {
        FoodItem item1 = new FoodItem("Salad", 4.5);
        FoodItem item2 = new FoodItem("salad", 6.0);
        assertEquals(item1.hashCode(), item2.hashCode());
    }

    /**
     * Tests that toString returns the correct string format.
     */
    @Test
    public void testToString() {
        FoodItem item = new FoodItem("Noodles", 7.75);
        assertEquals("Noodles - $7.75", item.toString());
    }
}
=======
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodItemTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
>>>>>>> eb866dcd42427dd9d2930b888002567c73062b79
