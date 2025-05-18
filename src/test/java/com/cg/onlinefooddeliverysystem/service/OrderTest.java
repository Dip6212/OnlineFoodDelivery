package com.cg.onlinefooddeliverysystem.service;

import com.cg.onlinefooddeliverysystem.Exceptions.InvalidOrderException;
import com.cg.onlinefooddeliverysystem.entity.Customer;
import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * All the methods of Order class are tested here.
 * Tests include successful order placement, invalid conditions, and order completion.
 * Enhanced for full branch and condition coverage of Order logic.
 * 
 * @author Divya Sinha
 * @since 1.0
 */
public class OrderTest {

    private Customer customer;
    private DeliveryPerson deliveryPerson;
    private FoodItem pizza;
    private FoodItem burger;
    private Map<FoodItem, Integer> inventory;
    private List<DeliveryPerson> deliveryPersons;

    /**
     * Sets up shared objects for each test, including inventory and delivery persons.
     */
    @Before
    public void setUp() {
        inventory = new HashMap<FoodItem, Integer>();
        deliveryPersons = new ArrayList<DeliveryPerson>();
        customer = new Customer("Alice");

        pizza = new FoodItem("Pizza", 5.0);
        burger = new FoodItem("Burger", 4.0);

        inventory.put(pizza, 3);
        inventory.put(burger, 5);

        deliveryPerson = new DeliveryPerson("Bob");
        deliveryPersons.add(deliveryPerson);
    }

    /**
     * Tests successful order creation, correct order details, status, and delivery person assignment.
     */
    @Test
    public void testSuccessfulOrderPlacement() throws InvalidOrderException {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Pizza", 2);

        Order order = new Order(customer, request, inventory, deliveryPersons);

        assertNotNull(order);
        assertEquals("In progress", order.getStatus());
        assertTrue(order.orderDetails().contains("Pizza"));
        assertTrue(order.orderDetails().contains("x 2"));
    }

    /**
     * Tests order creation fails if a requested item is not present in the inventory.
     */
    @Test(expected = InvalidOrderException.class)
    public void testOrderFailsIfItemNotInInventory() throws InvalidOrderException {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Sushi", 1); // Not in inventory

        new Order(customer, request, inventory, deliveryPersons);
    }

    /**
     * Tests order creation fails if requested quantity exceeds available inventory.
     */
    @Test(expected = InvalidOrderException.class)
    public void testOrderFailsIfStockIsInsufficient() throws InvalidOrderException {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Pizza", 10); // Only 3 available

        new Order(customer, request, inventory, deliveryPersons);
    }

    /**
     * Tests order creation fails if no delivery person is available.
     */
    @Test(expected = InvalidOrderException.class)
    public void testOrderFailsIfNoDeliveryPersonAvailable() throws InvalidOrderException {
        deliveryPersons.get(0).setAvailable(false); // Make the only delivery person unavailable

        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Pizza", 1);

        new Order(customer, request, inventory, deliveryPersons);
    }

    /**
     * Tests that completing an order updates its status and sets the delivery person as available.
     */
    @Test
    public void testCompleteOrderUpdatesStatusAndFreesDeliveryPerson() throws InvalidOrderException {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Pizza", 1);

        Order order = new Order(customer, request, inventory, deliveryPersons);
        order.completeOrder();

        assertEquals("Completed", order.getStatus());
        assertTrue(deliveryPerson.isAvailable());
    }

    /**
     * Tests ordering multiple different food items.
     */
    @Test
    public void testMultipleItemsOrder() {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Pizza", 1);
        request.put("Burger", 2);

        try {
            // Create an Order with multiple items
            Order order = new Order(customer, request, inventory, deliveryPersons);

            // Get the order details
            String details = order.orderDetails();

            // Assert that the order details contain the items and quantities
            assertTrue(details.contains("Pizza x 1"));
            assertTrue(details.contains("Burger x 2"));

        } catch (InvalidOrderException e) {
            // If InvalidOrderException is thrown, fail the test and output the exception message
            fail("Expected no InvalidOrderException, but got: " + e.getMessage());
        }
    }


    /**
     * Tests case-insensitive matching of item names in the order request.
     */
    @Test
    public void testCaseInsensitiveItemMatching() throws InvalidOrderException {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("pIzZa", 1); // Mixed case

        Order order = new Order(customer, request, inventory, deliveryPersons);

        assertTrue(order.orderDetails().contains("Pizza x 1"));
    }
}