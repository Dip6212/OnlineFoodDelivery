

package com.cg.onlinefooddeliverysystem.entity;
/**
*This abstract class declares a User in the Online Food Delivery System.
* It has fields such as 'id' and 'name' and their setter and getter.
* It defines an abstract method 'showProfile()', which needs to be overridden by subclasses.
 * @author Debanjana Bag
 * @since 1.0
 */

public abstract class User {

	// Unique identifier for user
	protected String id;

	// Name of user
	protected String name;

	public User(String id, String name) {
		setId(id);
		setName(name);
	}

	
	/**
     * Returns the user's ID
     * @return the user's ID as a String
     */
	public String getId() {
		return id;
	}

	
	/**
     * Sets the user's ID
     * @param id the unique identifier for the user
     */
	public void setId(String id) {
		this.id = id;
	}

	
	 /**
     * Returns the user's name
     * @return the user's name as a String
     */
	public String getName() {
		return name;
	}

	
	/**
     * Sets the user's name
     * @param name of the user
     */
	public void setName(String name) {
		this.name = name;
	}

	// Abstract method to display the user's profile
	public abstract void showProfile();
}
