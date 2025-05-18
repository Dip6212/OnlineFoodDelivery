package com.cg.onlinefooddeliverysystem.service;

import com.cg.onlinefooddeliverysystem.entity.Customer;
import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;
import com.cg.onlinefooddeliverysystem.service.Order;

import Exceptions.InvalidOrderException;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Unit tests for the {@link Order} class in the Online Food Delivery System.
 * Tests the creation, validation, and status changes of orders, including inventory updates and delivery person assignment.
 * The tests include:
 *   Successful creation of an order with correct details, status, and delivery person assignment.
 *   Order failure if a requested item is not in the inventory.
 *   Order failure if requested quantity exceeds available stock.
 *   Order failure if no delivery person is available.
 *   Completing an order updates its status and frees the delivery person.
 *
 * Example usage:
 *     Map<String, Integer> request = new HashMap<>();
 *     request.put("Pizza", 2);
 *     Order order = new Order(customer, request, inventory, deliveryPersons);
 *     assertEquals("In progress", order.getStatus());
 *     order.completeOrder();
 *     assertEquals("Completed", order.getStatus());
 *
 * @author (Divya Sinha)
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
    public void setup() {
        customer = new Customer("Alice");
        deliveryPerson = new DeliveryPerson("Bob");
        deliveryPerson.setAvailable(true);

        pizza = new FoodItem("Pizza", 10.0);
        burger = new FoodItem("Burger", 8.0);

        inventory = new HashMap<FoodItem, Integer>();
        inventory.put(pizza, 5);
        inventory.put(burger, 3);

        deliveryPersons = new ArrayList<DeliveryPerson>();
        deliveryPersons.add(deliveryPerson);
    }

    /**
     * Tests successful order creation, correct order details, status, and delivery person assignment.
     */
    @Test
    public void testValidOrderCreationAndDetails() throws InvalidOrderException {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Pizza", 2);
        request.put("Burger", 1);

        Order order = new Order(customer, request, inventory, deliveryPersons);

        String expected = "Order for Alice\n" +
                pizza.toString() + " x 2\n" +
                burger.toString() + " x 1\n" +
                "Delivery By: Bob\nStatus: In progress";

        assertEquals(expected, order.orderDetails());
        assertEquals("In progress", order.getStatus());
        assertFalse(deliveryPerson.isAvailable());
    }

    /**
     * Tests order creation fails if a requested item is not present in the inventory.
     */
    @Test(expected = InvalidOrderException.class)
    public void testOrderFailsIfItemNotInInventory() throws InvalidOrderException {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Sushi", 1);

        new Order(customer, request, inventory, deliveryPersons);
    }

    /**
     * Tests order creation fails if requested quantity exceeds available inventory.
     */
    @Test(expected = InvalidOrderException.class)
    public void testOrderFailsIfStockIsInsufficient() throws InvalidOrderException {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("Pizza", 10);

        new Order(customer, request, inventory, deliveryPersons);
    }

    /**
     * Tests order creation fails if no delivery person is available.
     */
    @Test(expected = InvalidOrderException.class)
    public void testOrderFailsIfNoDeliveryPersonAvailable() throws InvalidOrderException {
        deliveryPerson.setAvailable(false);

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
}
