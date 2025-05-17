package com.cg.onlinefooddeliverysystem.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;


/**
 * Unit tests for the {@link Manager} class in the Online Food Delivery System.
 * This class verifies the Manager's role annotation, as well as methods for managing delivery persons and inventory.
 * The tests include:
 *   Presence and correctness of the {@link RoleCheck} annotation on the Manager class.
 *   Removal of a delivery person by name, including handling of non-existing names.
 *   Restocking inventory for existing and non-existing food items.
 *   Addition of new food items to inventory.
 *   Correct initialization and access of Manager profile details (ID and name).
 *
 * Example usage:
 *     Manager manager = new Manager("001", "Biswajit");
 *     manager.restockItem(inventory, "Burger", 5);
 *     assertEquals(15, inventory.get(new FoodItem("Burger", 5.0)));
 *
 * @author (Divya Sinha)
 * @since 1.0
 */
class ManagerTest {

    Manager manager;
    List<DeliveryPerson> list;
    Map<FoodItem, Integer> inventory;
	
    /**
     * Sets up common test data before each test.
     */
    @BeforeEach
    void setUp() {
        manager = new Manager("001", "Biswajit");

        list = new ArrayList<>();
        list.add(new DeliveryPerson("Dipan"));
        list.add(new DeliveryPerson("Suman"));

        inventory = new HashMap<>();
        inventory.put(new FoodItem("Burger", 5.0), 10);
    }
	
    /**
     * Tests that the Manager class has the RoleCheck annotation with the correct role.
     */
    @Test
    void testManagerHasRoleCheckAnnotation() {
        RoleCheck role = Manager.class.getAnnotation(RoleCheck.class);
        assertNotNull(role, "Manager class should have RoleCheck annotation");
        assertEquals("Manager", role.role());
    }

    /**
     * Tests that a delivery person can be removed by name.
     */
    @Test
    void testRemoveDeliveryPerson() {
        manager.removeDeliveryPerson(list, "Dipan");
        assertEquals(1, list.size());
        boolean found= false;
        for(DeliveryPerson p : list) {
            if(p.getName().equals("Dipan"))
                found= true;
            break;
        }
        assertFalse(found);
    }

    /**
     * Tests that removing a non-existing delivery person does not affect the list.
     */
    @Test
    void testRemoveNonExistingDeliveryPerson() {
        manager.removeDeliveryPerson(list, "Yash");
        boolean found= false;
        for(DeliveryPerson p : list) {
            if(p.getName().equals("Yash"))
                found= true;
            break;
        }
        assertFalse(found);
    }

    /**
     * Tests that restocking an existing item increases its quantity.
     */
    @Test
    void testRestockExistingItem() {
        manager.restockItem(inventory, "Burger", 5);
        assertEquals(15, inventory.get(new FoodItem("Burger", 5.0)));
    }

    /**
     * Tests that restocking a non-existing item does not add it.
     */
    @Test
    void testRestockNonExistingItem() {
        manager.restockItem(inventory, "Pizza", 10);        
        assertNull(inventory.get(new FoodItem("Pizza", 0)));
    }

    /**
     * Tests that adding a new item inserts it into inventory with the correct quantity.
     */
    @Test
    void testAddNewItem() {
        manager.addNewItem(inventory, "Fries", 2.5, 20);
        assertEquals(20, inventory.get(new FoodItem("Fries", 2.5)));
    }
    
    /**
     * Tests that the manager's profile details are correctly initialized and accessible.
     */
    @Test
    void testshowProfile() {
        assertEquals("001", manager.getId());
        assertEquals("Biswajit", manager.getName());
    }
}