
package com.cg.onlinefooddeliverysystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.onlinefooddeliverysystem.entity.Customer;
import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;

import Exceptions.InvalidOrderException;


/**
 * The Order class represents an order placed by a customer for food items in the Online Food Delivery System.
 * It manages the ordered items, assigns a delivery person if available, checks inventory, and maintains order status.
 * 
 * Usage:
 * Map<String, Integer> request = new HashMap<>();
 * request.put("Pizza", 2);
 * Map<FoodItem, Integer> inventory = ...;
 * List<DeliveryPerson> deliveryPersons = ...;
 * Customer customer = ...;
 * Order order = new Order(customer, request, inventory, deliveryPersons);
 * 
 * @author Aditi Saha 
 * @since 1.0
 */

public class Order {

}