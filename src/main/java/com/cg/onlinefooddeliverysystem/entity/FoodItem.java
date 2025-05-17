

package com.cg.onlinefooddeliverysystem.entity;
/**
 * This class represents a Food Item in the Online Food Delivery System.
 * Each food item has a name and a price.
 * The class overrides equals() and hashCode() to allow case-insensitive comparison by name,
 * and also provides a custom toString() method for displaying item details.
 * @author Debanjana Bag
 * @since 1.0
 */

public class FoodItem {

	// Name of the food item
	private String name;

	// Price of the food item
	private double price;

	// Constructor to initialize food item with name and price
	public FoodItem(String name, double price) {
		setName(name);
		setPrice(price);
	}

	// Returns the name of the food item
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;

	}

	// Returns the price of the food item
	public double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		this.price = price;

	}

	// Overrides equals() for case-insensitive comparison based on name
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FoodItem foodItem = (FoodItem) o;
		return name.equalsIgnoreCase(foodItem.name);
	}

	// Overrides hashCode() to match the equals() logic
	@Override
	public int hashCode() {
		return name.toLowerCase().hashCode();
	}

	// Returns a string representation of the food item
	@Override
	public String toString() {
		return name + " - $" + price;
	}
}