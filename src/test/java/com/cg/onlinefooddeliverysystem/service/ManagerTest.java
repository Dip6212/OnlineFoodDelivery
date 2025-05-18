package com.cg.onlinefooddeliverysystem.service;

import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * This class tests the methods of the Manager class, including adding food items,
 * restocking items, removing delivery person, and checking profile.
 * 
 * @author Divya Sinha
 * @since  1.0
 */
public class ManagerTest {

    Manager manager;
    List<DeliveryPerson> list;
    Map<FoodItem, Integer> inventory;
    private final ByteArrayOutputStream b = new ByteArrayOutputStream();
    private final PrintStream ori = System.out;

    /**
     * Sets up the test environment.
     * Initializes Manager, DeliveryPersons list, and food inventory before each test.
     */
    @Before
    public void setUp() {
        manager = new Manager("M1", "Alok");
        list = new ArrayList<>();
        inventory = new HashMap<>();
        list.add(new DeliveryPerson("Dipan"));
        list.add(new DeliveryPerson("Suman"));
        System.setOut(new PrintStream(b));
    }
    

    /**
     * Test case to ensure the Manager constructor correctly sets the ID and name.
     */
    @Test
    public void testManagerConstructor() {
        assertEquals("M1", manager.getId());
        assertEquals("Alok", manager.getName());
    }

    /**
     * Test case to add a new food item to the inventory.
     * Verifies that the food item is added successfully.
     */
    @Test
    public void testAddNewItem() {
        FoodItem item = new FoodItem("Pizza", 10.0);
        manager.addNewItem(inventory, "Pizza", 10.0, 5);

        assertTrue(inventory.containsKey(item));
        assertEquals(5, (int) inventory.get(item));
    }

    /**
     * Test case to restock an existing food item in the inventory.
     * Verifies that the quantity of the item is updated correctly.
     */
    @Test
    public void testRestockItem() {
        FoodItem item = new FoodItem("Burger", 5.0);
        manager.addNewItem(inventory, "Burger", 5.0, 5);  
        manager.restockItem(inventory, "Burger", 10);  

        assertEquals(15, (int) inventory.get(item));
    }

    /**
     * Test case to remove a delivery person from the list by their name.
     * Verifies that the delivery person is removed successfully.
     */
    @Test
    public void testRemoveDeliveryPerson() {
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
     * Test case to verify the behavior when trying to remove a non-existing delivery person.
     */
    @Test
    public void testRemoveNonExistingDeliveryPerson() {
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
     * Test case to verify the Manager's profile display.
     * Ensures the profile is correctly displayed.
     */
    @Test
    public void testShowProfile() {
    	
        manager.showProfile();
        assertTrue(b.toString().contains("Manager ID: M1, Name: Alok"));
    }
    
    /**
     * Testing whether the password is correct
     */
    @Test
    public void testPasswordAccess() {
        assertEquals("P@ssw0rd!123", manager.getPassword());
    }
    /**
     * Restores System.out after each test.
     */
    @After
    public void restore() {
        System.setOut(ori);
        b.reset();
    }
}
