package com.cg.onlinefooddeliverysystem.service;

<<<<<<< HEAD
import com.cg.onlinefooddeliverysystem.entity.Customer;
import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;
import com.cg.onlinefooddeliverysystem.service.DeliverySystem;
import com.cg.onlinefooddeliverysystem.service.InvalidOrderException;
import com.cg.onlinefooddeliverysystem.service.Order;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Unit tests for the {@link DeliverySystem} class in the Online Food Delivery System.
 * These tests verify customer and delivery person registration, food item inventory management,
 * menu display, order placement (both success and failure), and delivery person listing.
 * The tests use System.out output capturing for methods that print confirmations or menus.
 *   Registering customers and delivery persons and checking they are in the system and output is correct.
 *   Adding new and existing food items and verifying inventory updates and output.
 *   Displaying the menu and checking correct food items and quantities are shown.
 *   Placing orders: successful order creation and order failure for unavailable items.
 *   Listing all delivery persons and verifying their names appear in output.
 *
 * Example usage:
 *     DeliverySystem system = new DeliverySystem();
 *     Customer customer = new Customer("Alice");
 *     system.registerCustomer(customer);
 *     assertTrue(system.customers.contains(customer));
 *
 * @author (Divya Sinha)
 * @since 1.0
 */
public class DeliverySystemTest {

    private DeliverySystem system;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    /**
     * Sets up a new DeliverySystem and captures System.out before each test.
     */
    @Before
    public void setUp() {
        system = new DeliverySystem();

        // Capture System.out output
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Tests customer registration adds the customer to the system and prints confirmation.
     */
    @Test
    public void testRegisterCustomer() {
        Customer customer = new Customer("Alice");
        system.registerCustomer(customer);
        assertTrue(system.customers.contains(customer));
        assertTrue(outContent.toString().contains("Customer registered successfully."));
    }

    /**
     * Tests delivery person registration adds the person to the system and prints confirmation.
     */
    @Test
    public void testRegisterDeliveryPerson() {
        DeliveryPerson dp = new DeliveryPerson("Bob");
        system.registerDeliveryPerson(dp);
        assertTrue(system.deliveryPersons.contains(dp));
        assertTrue(outContent.toString().contains("Delivery person registered successfully."));
    }

    /**
     * Tests adding a new food item to inventory.
     */
    @Test
    public void testAddFoodItemNewItem() {
        FoodItem pizza = new FoodItem("Pizza", 10.0);
        system.addFoodItem(pizza, 5);
        assertEquals(5, (int) system.inventory.get(pizza));
        assertTrue(outContent.toString().contains("Food item added successfully."));
    }

    /**
     * Tests adding more of an existing food item updates the quantity.
     */
    @Test
    public void testAddFoodItemUpdatesQuantity() {
        FoodItem burger = new FoodItem("Burger", 8.0);
        system.addFoodItem(burger, 3);
        system.addFoodItem(burger, 2); 
        assertEquals(5, (int) system.inventory.get(burger));
    }

    /**
     * Tests displaying the menu prints correct food items and quantities.
     */
    @Test
    public void testDisplayMenu() {
        FoodItem pizza = new FoodItem("Pizza", 10.0);
        FoodItem fries = new FoodItem("Fries", 5.0);
        system.addFoodItem(pizza, 3);
        system.addFoodItem(fries, 2);

        outContent.reset();
        system.displayMenu();

        String output = outContent.toString();
        assertTrue(output.contains("Pizza - $10.0"));
        assertTrue(output.contains("Fries - $5.0"));
        assertTrue(output.contains("Available: 3") || output.contains("Available: 2"));
    }

    /**
     * Tests successful order placement with available delivery person and inventory.
     */
    @Test
    public void testPlaceOrderSuccess() throws InvalidOrderException {
        Customer customer = new Customer("Charlie");
        DeliveryPerson dp = new DeliveryPerson("Daisy");
        dp.setAvailable(true);
        system.registerCustomer(customer);
        system.registerDeliveryPerson(dp);

        FoodItem item = new FoodItem("Sandwich", 6.0);
        system.addFoodItem(item, 4);

        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Sandwich", 2);

        Order order = system.placeOrder(customer, request);

        assertNotNull(order);
        assertEquals(1, system.orders.size());
        assertEquals("In progress", order.getStatus());
        assertEquals(2, order.orderDetails().contains("x 2") ? 2 : 0);
    }

    /**
     * Tests that placing an order for a non-existing item throws InvalidOrderException.
     */
    @Test(expected = InvalidOrderException.class)
    public void testPlaceOrderFailsIfItemNotFound() throws InvalidOrderException {
        Customer customer = new Customer("Eve");
        DeliveryPerson dp = new DeliveryPerson("Frank");
        dp.setAvailable(true);
        system.registerCustomer(customer);
        system.registerDeliveryPerson(dp);

        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("NonExisting", 1);

        system.placeOrder(customer, request);
    }

    /**
     * Tests that all registered delivery persons are listed in the output.
     */
    @Test
    public void testShowAllDeliveryPersons() {
        DeliveryPerson dp1 = new DeliveryPerson("Grace");
        DeliveryPerson dp2 = new DeliveryPerson("Henry");
        system.registerDeliveryPerson(dp1);
        system.registerDeliveryPerson(dp2);

        outContent.reset();
        system.showAllDeliveryPersons();
        String output = outContent.toString();

        assertTrue(output.contains("Grace"));
        assertTrue(output.contains("Henry"));
    }

    /**
     * Restores System.out after each test.
     */
    @Before
    public void tearDown() {
        System.setOut(originalOut); 
    }
}
=======
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeliverySystemTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
>>>>>>> eb866dcd42427dd9d2930b888002567c73062b79
