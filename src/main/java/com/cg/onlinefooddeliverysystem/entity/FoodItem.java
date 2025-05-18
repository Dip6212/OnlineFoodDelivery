

package com.cg.onlinefooddeliverysystem.entity;

import java.util.Objects;

/**
 * This class represents Food Item in the Online Food Delivery System.
 * Each food item has a name and a price.
 * The class overrides equals() and hashCode() and also provides a custom toString() method for displaying item details
 * @author Debanjana Bag
 * @since 1.0
 */

public class FoodItem {

	// Name of food item
	private String name;

	// Price of food item
	private double price;

	
	/**
     * Constructor to initialize food item with name and price
     * @param name of the food item
     * @param price of the food item
     */
	public FoodItem(String name, double price) {
		setName(name);
		setPrice(price);
	}

	
	/**
     * Returns name of the food item
     * @return the name of the food item
     */
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;

	}

	/**
     * Returns the price of the food item
     *
     * @return the price of the food item
     */
	public double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		this.price = price;

	}

	
	/**
     * Overrides equals() for case-insensitive comparison based on name
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
// Overrides equals() for case-insensitive comparison based on name
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    FoodItem foodItem = (FoodItem) o;
	    return Double.compare(foodItem.price, price) == 0 &&
	           name.equalsIgnoreCase(foodItem.name);
	}
	
	/**
     * Overrides hashCode() to match the equals() logic using both name and price
     * @return a hash code value for the object
     */
	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase(),price);
	}

	
	/**
     * Returns a string representation of the food item
     * @return a string containing the name and price of the food item
     */
	@Override
	public String toString() {
		return name + " - $" + price;
	}
}
