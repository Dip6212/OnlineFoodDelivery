

package com.cg.onlinefooddeliverysystem.entity;
/**
 * This abstract class defines a generic User entity in the Online Food Delivery System.
 * It contains common fields like 'id' and 'name', along with their getter and setter methods.
 * The class also declares an abstract method 'showProfile()', which must be implemented by subclasses.
 * This design allows for flexible and reusable user-related functionality across different user roles.
 * @author Debanjana Bag
 * @since 1.0
 */

public abstract class User {

	// Unique identifier for the user
	protected String id;

	// Name of the user
	protected String name;

	public User() {
		setId(id);
		setName(name);
	}

	// Returns the user's ID
	public String getId() {
		return id;
	}

	// Sets the user's ID
	public void setId(String id) {
		this.id = id;
	}

	// Returns the user's name
	public String getName() {
		return name;
	}

	// Sets the user's name
	public void setName(String name) {
		this.name = name;
	}

	// Abstract method to display the user's profile; must be implemented by subclasses
	public abstract void showProfile();
}