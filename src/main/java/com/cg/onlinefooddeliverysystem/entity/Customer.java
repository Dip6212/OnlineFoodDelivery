package com.cg.onlinefooddeliverysystem.entity;

/**
* This class illustrates a Customer in the Online Food Delivery System.
* It inherits the abstract User class and implements it.
 * @author Debanjana Bag
 * @since 1.0
 */


public class Customer extends User {

	// Static counter to generate unique customer IDs
	private static int idCounter = 100;

	
	/**
     * Constructor to initialize customer with a name and auto-generated ID
     * @param name of the customer
     */
	public Customer(String name) {
		super(String.valueOf(++idCounter),name); // Call to superclass constructor
		
	}

	// Implementation of abstract method to display customer's profile
	@Override
	public void showProfile() {
		System.out.println("Customer ID: " + getId() + ", Name: " + getName());
	}

}
