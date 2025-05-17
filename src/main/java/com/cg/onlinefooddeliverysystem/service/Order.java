
package com.cg.onlinefooddeliverysystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.onlinefooddeliverysystem.entity.Customer;
import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;


/**
 * The Order class represents an order placed by a customer for food items in the Online Food Delivery System.
 * It manages the ordered items, assigns a delivery person if available, checks inventory, and maintains order status.
 * 
 * Usage:
 * Map<String, Integer> request = new HashMap<>();
 * request.put("Pizza", 2);
 * Map<FoodItem, Integer> inventory = ...;
 * List<DeliveryPerson> deliveryPersons = ...;
 * Customer customer = ...;
 * Order order = new Order(customer, request, inventory, deliveryPersons);
 * 
 * @author Aditi Saha 
 * @since 1.0
 */

public class Order {

    private Customer customer; 
    private DeliveryPerson deliveryPerson; 
    private Map<FoodItem, Integer> itemsOrdered; 
    private String status;

    /**
     * Constructs an Order object with the specified customer, requested items, inventory, and delivery persons.
     * Validates item existence and stock, deducts from inventory, and assigns an available delivery person.
     * 
     * @param customer The customer placing the order.
     * @param request A map of food item names to quantities requested.
     * @param inventory A map of FoodItem to available quantity.
     * @param deliveryPersons A list of potential delivery persons.
     * @throws InvalidOrderException if an item is not found, insufficient stock, or no delivery person is available.
     */
    public Order(Customer customer, Map<String, Integer> request, Map<FoodItem, Integer> inventory,
            List<DeliveryPerson> deliveryPersons) throws InvalidOrderException {
        this.customer = customer; 
        this.itemsOrdered = new HashMap<FoodItem, Integer>(); 

        for (Map.Entry<String, Integer> entry : request.entrySet()) {
            boolean found = false; 
            for (FoodItem item : inventory.keySet()) {
                if (item.getName().equalsIgnoreCase(entry.getKey())) {
                    if (inventory.get(item) >= entry.getValue()) {
                        inventory.put(item, inventory.get(item) - entry.getValue()); 
                        itemsOrdered.put(item, entry.getValue());
                        found = true; 
                        break; 
                    } else {
                        throw new InvalidOrderException("Insufficient stock " + item.getName());
                    }
                }
            }
            if (!found) {
                throw new InvalidOrderException("Item: " + entry.getKey() + " not found");
            }
        }
        for (DeliveryPerson dp : deliveryPersons) {
            if (dp.isAvailable()) {
                this.deliveryPerson = dp;
                dp.setAvailable(false); 
                break;
            }
        }

        if (this.deliveryPerson == null) {
            throw new InvalidOrderException("No delivery person available"); 
        }

        this.status = "In progress"; 
    }

    /**
     * Completes the current order, updates the status, and marks the delivery person as available.
     */
    public void completeOrder() {
        this.status = "Completed";
        this.deliveryPerson.setAvailable(true);
    }

    /**
     * Returns the details of the order, including customer, items, delivery person, and status.
     * 
     * @return A string describing the order details.
     */
    public String orderDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order for ").append(customer.getName()).append("\n");
        for (Map.Entry<FoodItem, Integer> e : itemsOrdered.entrySet()) {
            sb.append(e.getKey()).append(" x ").append(e.getValue()).append("\n");
        }
        sb.append("Delivery By: ").append(deliveryPerson.getName()).append("\nStatus: ").append(status);
        return sb.toString();
    }

    /**
     * Returns the current status of the order.
     * 
     * @return The order status.
     */
    public String getStatus() {
        return status;
    }
}