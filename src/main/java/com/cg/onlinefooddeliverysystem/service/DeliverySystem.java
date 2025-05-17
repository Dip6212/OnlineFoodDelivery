package com.cg.onlinefooddeliverysystem.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.main.java.com.cg.onlinefooddeliverysystem.Customer;
import src.main.java.com.cg.onlinefooddeliverysystem.DeliveryPerson;
import src.main.java.com.cg.onlinefooddeliverysystem.FoodItem;

/**
 * The DeliverySystem class manages customers, delivery personnel, food inventory, and order placement.
 * It provides methods for registration, adding inventory, order processing, and displaying available food items or delivery persons.
 * @author Yash Shaw
 * @since 1.0
 */

public class DeliverySystem {
    /** List of all customers registered in the system. */
    public List<Customer> customers = new ArrayList<Customer>();

    /** List of all delivery persons registered in the system. */
    public List<DeliveryPerson> deliveryPersons = new ArrayList<DeliveryPerson>();

    /** List of all orders placed in the system. */
    public List<Order> orders = new ArrayList<Order>();

    /** Food inventory with FoodItem as key and quantity as value. */
    public Map<FoodItem, Integer> inventory = new HashMap<FoodItem, Integer>();

    /**
     * Registers a new customer into the system.
     * @param c The customer to register.
     */
    public void registerCustomer(Customer c) {
        customers.add(c);
        System.out.println("Customer registered successfully.");
    }

    /**
     * Registers a new delivery person into the system.
     * @param d The delivery person to register.
     */
    public void registerDeliveryPerson(DeliveryPerson d) {
        deliveryPersons.add(d);
        System.out.println("Delivery person registered successfully.");
    }

    /**
     * Adds a food item to the inventory or updates its quantity if it already exists.
     * @param item The food item to add or update.
     * @param quantity The quantity to add.
     */
    public void addFoodItem(FoodItem item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
        System.out.println("Food item added successfully.");
    }

    /**
     * Displays the available menu along with quantity for each food item.
     */
    public void displayMenu() {
        for (Map.Entry<FoodItem, Integer> e : inventory.entrySet()) {
            System.out.println(e.getKey() + " | Available: " + e.getValue());
        }
    }

    /**
     * Places an order for a customer based on their food item request.
     * @param c The customer placing the order.
     * @param request A map of food item names to their requested quantities.
     * @return The created Order object.
     * @throws InvalidOrderException If the order cannot be fulfilled.
     */
    public Order placeOrder(Customer c, Map<String, Integer> request) throws InvalidOrderException {
        Order order = new Order(c, request, inventory, deliveryPersons);
        orders.add(order);
        return order;
    }

    /**
     * Displays the profile of all registered delivery personnel.
     */
    public void showAllDeliveryPersons() {
        for (DeliveryPerson d : deliveryPersons) {
            d.showProfile();
        }
    }
}

