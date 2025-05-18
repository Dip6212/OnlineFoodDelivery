
package com.cg.onlinefooddeliverysystem.service;

import java.util.*;

import com.cg.onlinefooddeliverysystem.*;
import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;
import com.cg.onlinefooddeliverysystem.entity.User;

import Annotations.RoleCheck;

/**
  Manager class extends User and lets managers manage delivery staff and inventory
 * @author Biswajit Adhikary
 * @since 1.0
 */

@RoleCheck(role = "Manager")
public class Manager extends User {

	// Constructor to create a Manager using id and name
    public Manager(String id, String name) {
        super(id, name);
    }

 // Removes a delivery person by name from the given list
    public void removeDeliveryPerson(List<DeliveryPerson> list, String name) {
        try {
            RoleCheck role = this.getClass().getAnnotation(RoleCheck.class);
            if (!"Manager".equals(role.role())) {
                throw new SecurityException("Access denied.");
            }
            Iterator<DeliveryPerson> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(name)) {
                    it.remove();
                    System.out.println("Delivery Person removed.");
                    return;
                }
            }
            System.out.println("No such Delivery Person found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

 // Adds stock to an existing food item, or tells if item is not found
    public void restockItem(Map<FoodItem, Integer> inventory, String itemName, int quantity) {
        for (FoodItem item : inventory.keySet()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.put(item, inventory.get(item) + quantity);
                System.out.println("Restocked successfully.");
                return;
            }
        }
        System.out.println("Item not found. Adding new item.");
    }

 // Adds a brand new food item to the inventory
    public void addNewItem(Map<FoodItem, Integer> inventory, String name, double price, int quantity) {
        FoodItem newItem = new FoodItem(name, price);
        inventory.put(newItem, quantity);
        System.out.println("Item added.");
    }

 // Shows the manager’s profile details
    @Override
    public void showProfile() {
        System.out.println("Manager ID: " + getId() + ", Name: " + getName());
    }
}


