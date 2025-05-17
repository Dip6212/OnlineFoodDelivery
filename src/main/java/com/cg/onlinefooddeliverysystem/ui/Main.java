package com.cg.onlinefooddeliverysystem.ui;

import java.util.*;

import com.cg.onlinefooddeliverysystem.entity.*;
import com.cg.onlinefooddeliverysystem.service.*;

/**
 * Main class to run the Delivery System application. This class handles user
 * interactions and manages the flow of the application.
 * @author Suman Roy
 * @since 1.0
 */
public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DeliverySystem system = new DeliverySystem();
		Manager manager = new Manager("0", "Manager");

		// Main loop for user interaction
		while (true) {
			System.out.println(
					"\n1. Register Customer\n2. Register Delivery Person\n3. Show Menu & Place Order\n4. Add Food Item (Manager)\n5. Restock Food Item (Manager)\n6. Show All Delivery Personnel\n7. Exit\nEnter choice: ");

			String input = sc.nextLine();
			int choice = validateMenuChoice(input); // Validate user menu choice

			switch (choice) {
			case 1:
				// Register a new customer
				String cname = askName("Enter Name (alphabetic): ");
				system.registerCustomer(new Customer(cname));
				break;

			case 2:
				// Register a new delivery person
				String dname = askName("Enter Name (alphabetic): ");
				system.registerDeliveryPerson(new DeliveryPerson(dname));
				break;

			case 3:
				// Show menu and place an order
				if (system.customers.isEmpty()) {
					System.out.println("No registered customers.");
					break;
				}

				if (system.inventory.isEmpty()) {
					System.out.println("Menu is empty. Please add food items first.");
					break;
				}

				Customer customer = system.customers.get(0); // Selecting the first customer for simplicity
				system.displayMenu(); // Display the food menu

				Map<String, Integer> orderMap = new HashMap<String, Integer>();
				while (true) {
					System.out.print("Enter food item name to order (or 'done'): ");
					String item = sc.nextLine();
					if (item.equalsIgnoreCase("done"))
						break;
					System.out.print("Enter quantity: ");
					int qty = Integer.parseInt(validateNumericInput()); // Validate quantity input
					orderMap.put(item, qty);
				}

				try {
					// Place the order
					Order order = system.placeOrder(customer, orderMap);
					System.out.println(order.orderDetails()); // Show order details
				} catch (InvalidOrderException e) {
					System.out.println("Order failed: " + e.getMessage());
				}
				break;

			case 4:
				// Add a new food item (Manager only)
				String fname = askName("Enter food name: ");
				System.out.print("Enter price: ");
				double price = Double.parseDouble(validateDoubleInput()); // Validate price input
				System.out.print("Enter quantity: ");
				int q = Integer.parseInt(validateNumericInput()); // Validate quantity input
				manager.addNewItem(system.inventory, fname, price, q);
				break;

			case 5:
				// Restock an existing food item (Manager only)
				String rname = askName("Enter food name: ");
				System.out.print("Enter quantity to restock: ");
				int rq = Integer.parseInt(validateNumericInput()); // Validate quantity input
				manager.restockItem(system.inventory, rname, rq);
				break;

			case 6:
				// Show all delivery personnel
				system.showAllDeliveryPersons();
				break;

			case 7:
				// Exit the application
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid input. Try again.");
			}
		}
	}

// Validate the user's menu choice input
	private static int validateMenuChoice(String input) {
		while (!input.matches("[1-7]")) {
			System.out.print("Invalid input. Enter choice again (1-7): ");
			input = sc.nextLine();
		}
		return Integer.parseInt(input);
	}

// Validate numeric input
	private static String validateNumericInput() {
		String input = sc.nextLine();
		while (!input.matches("\\d+")) {
			System.out.print("Invalid input. Enter numeric value: ");
			input = sc.nextLine();
		}
		return input;
	}

// Validate double input
	private static String validateDoubleInput() {
		String input = sc.nextLine();
		while (!input.matches("\\d+(\\.\\d+)?")) {
			System.out.print("Invalid input. Enter a decimal number: ");
			input = sc.nextLine();
		}
		return input;
	}

// Ask for a name input
	private static String askName(String message) {
		System.out.print(message);
		String input = sc.nextLine();
		while (!input.matches("[a-zA-Z ]+")) {
			System.out.print("Invalid input. Enter alphabetic value: ");
			input = sc.nextLine();
		}
		return input;
	}
}
