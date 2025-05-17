

package com.cg.onlinefooddeliverysystem.entity;
/**
 * This class represents a Customer in the Online Food Delivery System.
 * It extends the abstract User class and provides a concrete implementation
 * of the showProfile() method. Each Customer is assigned a unique ID 
 * using a static counter that increments with every new instance.
 * @author Debanjana Bag
 * @since 1.0
 */


public class Customer extends User {

    // Static counter to generate unique customer IDs
    private static int idCounter = 100;

    // Constructor to initialize the customer with a name and auto-generated ID
    public Customer(String name) {
        super(); // Call to superclass constructor
        this.setId(String.valueOf(++idCounter)); // Set a unique ID
        this.setName(name); // Set the name
    }

    // Implementation of the abstract method to display customer's profile
    @Override
    public void showProfile() {
        System.out.println("Customer ID: " + getId() + ", Name: " + getName());
    }
}
