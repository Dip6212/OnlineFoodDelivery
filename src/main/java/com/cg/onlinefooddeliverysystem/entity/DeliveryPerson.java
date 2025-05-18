package com.cg.onlinefooddeliverysystem.entity;
/**
 * This class models a Delivery Person in the Online Food Delivery System.
 * It inherits from the abstract User class and adds an availability status to monitor
 * if the delivery person is available for delivery tasks.
 * @author Debanjana Bag
 * @since 1.0
 */

public class DeliveryPerson extends User {

	// Static counter to generate unique delivery person IDs
	private static int idCounter = 200;

	// Boolean flag to indicate if the delivery person is available
	private boolean available = true;

	
	/**
     * Constructor to initialize delivery person with name and auto-generated ID
     * @param name of the delivery person
     */
	public DeliveryPerson(String name) {
		super(String.valueOf(++idCounter),name); // Call to superclass constructor

	}

	
	 /**
     * Returns availability status of the delivery person
     * @return true if delivery person is available, false otherwise
     */
	public boolean isAvailable() {
		return available;
	}

	
	/**
     * Sets availability status of delivery person
     * @param the availability status
     */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	// Implementation of abstract method to display delivery person's profile
	@Override
	public void showProfile() {
		System.out.println("Delivery Person ID: " + getId() + ", Name: " + getName() + ", Available: " + available);
	}
}
