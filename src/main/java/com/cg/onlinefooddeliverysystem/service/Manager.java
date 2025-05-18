import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cg.onlinefooddeliverysystem.entity.DeliveryPerson;
import com.cg.onlinefooddeliverysystem.entity.FoodItem;

/**
 * The Manager class extends the User class and acts as a manager it can remove
 * delivery personnel, restock items, and add new items to the inventory. Also
 * is protected with a role check annotation to ensure only authorized users are
 * granted access.
 * 
 * @author Biswajit Adhikary
 * @since 1.0
 */
@RoleCheck(role = "Manager")
public class Manager extends User {
	// Manager's password.
	private final String password = "P@ssw0rd!123"; // One password has set

	/**
	 * Constructs a Manager with the specified ID and name.
	 * 
	 * @param id   the unique identifier for the manager
	 * @param name the name of the manager
	 */
	public Manager(String id, String name) {
		super();
	}

	/**
	 * Getter methods to get the manager's password.
	 * 
	 * @return the manager's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Removes a delivery person from the provided list by their ID. Only allowed
	 * for users with the "Manager" role.
	 * 
	 * @param list the list of delivery persons
	 * @param id   the ID of the delivery person to remove
	 */
	public void removeDeliveryPerson(List<DeliveryPerson> list, String id) {
		try {
			RoleCheck role = this.getClass().getAnnotation(RoleCheck.class);
			if (!"Manager".equals(role.role())) {
				throw new SecurityException("Access denied.");
			}
			Iterator<DeliveryPerson> it = list.iterator();
			while (it.hasNext()) {
				if (it.next().getId().equals(id)) {
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
	 * Restocks an existing food item in the inventory with the specified
	 * quantity,if the item does not exist, informs the user.
	 * 
	 * @param inventory the inventory map of FoodItem to quantity
	 * @param itemName  the name of the item to restock
	 * @param quantity  the quantity to add
	 */
	public void restockItem(Map<FoodItem, Integer> inventory, String itemName, int quantity) {
		// Check if the item exists in the inventory
		boolean itemExists = false;
		for (FoodItem item : inventory.keySet()) {
			if (item.getName().equalsIgnoreCase(itemName)) {
				itemExists = true;
				inventory.put(item, inventory.get(item) + quantity);
				System.out.println("Restocked successfully.");
				return;
			}
		}

		// If the item does not exist, printing a message
		if (!itemExists) {
			System.out.println("Item '" + itemName + "' is not present in the inventory. Please add the item first.");
		}
	}

	/**
	 * Adds a new food item to the inventory with the given name, price, and
	 * quantity.
	 * 
	 * @param inventory the inventory map of FoodItem to quantity
	 * @param name      the name of the new item
	 * @param price     the price of the new item
	 * @param quantity  the quantity of the new item
	 */
	public void addNewItem(Map<FoodItem, Integer> inventory, String name, double price, int quantity) {
		FoodItem newItem = new FoodItem(name, price);
		inventory.put(newItem, quantity);
		System.out.println("Item added.");
	}

	// Displays the profile information of the manager.

	@Override
	public void showProfile() {
		System.out.println("Manager ID: " + getId() + ", Name: " + getName());
	}
}
