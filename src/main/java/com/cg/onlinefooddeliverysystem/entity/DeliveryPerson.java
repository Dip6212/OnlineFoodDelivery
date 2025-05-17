

package com.cg.onlinefooddeliverysystem.entity;
/**
 * This class represents a Delivery Person in the Online Food Delivery System.
 * It extends the abstract User class and includes an availability status to track
 * whether the delivery person is available for delivery tasks.
 * Each DeliveryPerson is assigned a unique ID using a static counter.
 * @author Debanjana Bag
 * @since 1.0
 */

public class DeliveryPerson extends User {

    // Static counter to generate unique delivery person IDs
    private static int idCounter = 200;

    // Boolean flag to indicate if the delivery person is currently available
    private boolean available = true;

    // Constructor to initialize delivery person with a name and auto-generated ID
    public DeliveryPerson(String name) {
        super(); // Call to superclass constructor
        this.setId(String.valueOf(++idCounter)); // Set a unique ID
        this.setName(name); // Set the name
    }

    // Returns the availability status of the delivery person
    public boolean isAvailable() {
        return available;
    }

    // Sets the availability status of the delivery person
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Implementation of the abstract method to display delivery person's profile
    @Override
    public void showProfile() {
        System.out.println("Delivery Person ID: " + getId() + ", Name: " + getName() + ", Available: " + available);
    }
}
