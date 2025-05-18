package com.cg.onlinefooddeliverysystem.service;

import com.cg.onlinefooddeliverysystem.entity.Customer;
import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;
import com.cg.onlinefooddeliverysystem.service.DeliverySystem;
import com.cg.onlinefooddeliverysystem.service.InvalidOrderException;
import com.cg.onlinefooddeliverysystem.service.Order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 *Testing all the methods of DeliverySystem class.
 * @author Divya Sinha
 * @since 1.0
 */
public class DeliverySystemTest {

    private DeliverySystem system;
    private ByteArrayOutputStream b;
    private PrintStream ori;

    /**
     * Sets up a new DeliverySystem and captures System.out before each test.
     */
    @Before
    public void setUp() {
        system = new DeliverySystem();

        // Capture System.out output in console
        b = new ByteArrayOutputStream();
        ori = System.out;
        System.setOut(new PrintStream(b));
    }

    /**
     * Tests whether customer registration adds the customer to the system and prints confirmation.
     */
    @Test
    public void testRegisterCustomer() {
        Customer customer = new Customer("Debanjana");
        system.registerCustomer(customer);
        assertTrue(system.customers.contains(customer));
        assertTrue(b.toString().contains("Customer registered successfully."));
    }

    /**
     * Tests if delivery person registration adds the person to the system and prints confirmation.
     */
    @Test
    public void testRegisterDeliveryPerson() {
        DeliveryPerson dp = new DeliveryPerson("Divya");
        system.registerDeliveryPerson(dp);
        assertTrue(system.deliveryPersons.contains(dp));
        assertTrue(b.toString().contains("Delivery person registered successfully."));
    }

    /**
     * Tests adding a new food item to inventory.
     */
    @Test
    public void testAddFoodItemNewItem() {
        FoodItem pizza = new FoodItem("Pizza", 10.0);
        system.addFoodItem(pizza, 5);
        assertEquals(5, (int) system.inventory.get(pizza));
        assertTrue(b.toString().contains("Food item added successfully."));
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

        b.reset();
        system.displayMenu();

        String output = b.toString();
        assertTrue(output.contains("Pizza - $10.0"));
        assertTrue(output.contains("Fries - $5.0"));
        assertTrue(output.contains("Available: 3") || output.contains("Available: 2"));
    }

    /**
     * Tests successful order placement with available delivery person and inventory.
     */
    @Test
    public void testPlaceOrderSuccess() {
        try {
            Customer customer = new Customer("Chandan");
            DeliveryPerson dp = new DeliveryPerson("Dona");
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
            assertTrue(order.orderDetails().contains("x 2"));

        } catch (InvalidOrderException e) {
            fail("Order should have been placed successfully, but exception was thrown: " + e.getMessage());
        }
    }

    /**
     * Tests that placing an order for a non-existing item throws InvalidOrderException.
     */
    @Test
    public void testPlaceOrderFailsIfItemNotFound() {
        Customer customer = new Customer("Esha");
        DeliveryPerson dp = new DeliveryPerson("Fazal");
        dp.setAvailable(true);

        system.registerCustomer(customer);
        system.registerDeliveryPerson(dp);

        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("NonExisting", 1);  // Item not added to inventory

        try {
            system.placeOrder(customer, request);
            fail("Expected InvalidOrderException to be thrown");
        } catch (InvalidOrderException e) {
            assertEquals("Item: NonExisting not found", e.getMessage());
        }
    }

    /**
     * Tests that all registered delivery persons are listed in the output.
     */
    @Test
    public void testShowAllDeliveryPersons() {
        DeliveryPerson dp1 = new DeliveryPerson("Gaurav");
        DeliveryPerson dp2 = new DeliveryPerson("Harsh");
        system.registerDeliveryPerson(dp1);
        system.registerDeliveryPerson(dp2);

        b.reset();
        system.showAllDeliveryPersons();
        String output = b.toString();

        assertTrue(output.contains("Gaurav"));
        assertTrue(output.contains("Harsh"));
    }

    /**
     * Restores System.out after each test.
     */
    @After
    public void restore() {
        System.setOut(ori); 
    }
}
