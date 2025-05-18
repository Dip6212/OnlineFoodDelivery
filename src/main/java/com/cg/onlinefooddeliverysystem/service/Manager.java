
package com.cg.onlinefooddeliverysystem.service;

import java.util.*;

import com.cg.onlinefooddeliverysystem.*;
import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;
import com.cg.onlinefooddeliverysystem.entity.User;

import Annotations.RoleCheck;

/**
 * The Manager class extends the User class and provides additional functionalities
 * specific to the "Manager" role in the Online Food Delivery System.
 * Managers can remove delivery persons, restock items, add new items to inventory,
 * and view their profile.
 * 
 * This class is annotated with @RoleCheck to ensure that only users with the "Manager"
 * role can access its methods.
 * @author Biswajit Adhikary
 * @since 1.0
 */

@RoleCheck(role = "Manager")
public class Manager extends User {

    /**
     * Constructs a Manager object with the specified id and name.
     *
     * @param id   the unique identifier for the manager
     * @param name the manager's name
     */
    public Manager(String id, String name) {
        super(id, name);
    }

    /**
     * Removes a DeliveryPerson from the provided list based on the provided name.
     * Only a user with the "Manager" role is allowed to perform this operation.
     *
     * @param list the list of DeliveryPerson objects
     * @param name the name of the delivery person to remove
     */
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

    /**
     * Restocks an existing food item in the inventory by increasing its quantity.
     * If the item does not exist, notifies that the item will be added as new.
     *
     * @param inventory the inventory map with FoodItem as key and quantity as value
     * @param itemName  the name of the item to restock
     * @param quantity  the quantity to add
     */
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

    /**
     * Adds a new food item to the inventory.
     *
     * @param inventory the inventory map with FoodItem as key and quantity as value
     * @param name      the name of the new food item
     * @param price     the price of the new food item
     * @param quantity  the initial quantity of the new food item
     */
    public void addNewItem(Map<FoodItem, Integer> inventory, String name, double price, int quantity) {
        FoodItem newItem = new FoodItem(name, price);
        inventory.put(newItem, quantity);
        System.out.println("Item added.");
    }

    /**
     * Displays the manager's profile information.
     */
    @Override
    public void showProfile() {
        System.out.println("Manager ID: " + getId() + ", Name: " + getName());
    }
}