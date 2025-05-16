package com.cg.onlinefooddeliverysystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.main.java.com.cg.onlinefooddeliverysystem.Customer;
import src.main.java.com.cg.onlinefooddeliverysystem.DeliveryPerson;
import src.main.java.com.cg.onlinefooddeliverysystem.FoodItem;

public class DeliverySystem {
	public List<Customer> customers = new ArrayList<Customer>();
	public List<DeliveryPerson> deliveryPersons = new ArrayList<DeliveryPerson>();
	public List<Order> orders = new ArrayList<Order>();
	public Map<FoodItem, Integer> inventory = new HashMap<FoodItem, Integer>();

//    Registers a new customer into the system
	public void registerCustomer(Customer c) {
		customers.add(c);
		System.out.println("Customer registered successfully.");
	}

//    Registers a new delivery person into the system.
	public void registerDeliveryPerson(DeliveryPerson d) {
		deliveryPersons.add(d);
		System.out.println("Delivery person registered successfully.");
	}

//    Adds a food item to the inventory or updates its quantity if it already exists.
	public void addFoodItem(FoodItem item, int quantity) {
		inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
		System.out.println("Food item added successfully.");
	}

//    Displays the available menu along with quantity for each food item.
	public void displayMenu() {
		for (Map.Entry<FoodItem, Integer> e : inventory.entrySet()) {
			System.out.println(e.getKey() + " | Available: " + e.getValue());
		}
	}

//    Places an order for a customer based on their food item request.

	public Order placeOrder(Customer c, Map<String, Integer> request) throws InvalidOrderException {
		Order order = new Order(c, request, inventory, deliveryPersons);
		orders.add(order);
		return order;
	}

//    Displays the profile of all registered delivery personnel.
	public void showAllDeliveryPersons() {
		for (DeliveryPerson d : deliveryPersons) {
			d.showProfile();s
		}
	}

}
