package com.retail;

import com.retail.constant.ItemType;
import com.retail.constant.RoleName;
import com.retail.exception.BillingException;
import com.retail.model.Customer;
import com.retail.model.CustomerType;
import com.retail.model.Item;
import com.retail.model.Order;
import com.retail.model.Product;
import com.retail.model.Role;
import com.retail.model.User;

/**
 * This {@code RetailStoreBillingService} class is main class to run retail
 * store application. It displays final amount payable to customer.
 * 
 * @author Vaibhav
 *
 */
public class RetailStoreBillingService {

	public static void main(String[] args) {
		try {
			
			//TODO Change following inputs to run an application and see results. 
			
			// Login user
			Role role = new Role(RoleName.ROLE_MANAGER);
			User employee = new User(role, "John");
			
			// Items added in to cart
			Item groceryItem = new Product("Track Pant", 2000, ItemType.GROCERY);
			Item otherItem = new Product("T-Shirt", 2000, ItemType.OTHER);

			// Customer details
			Customer customer = new Customer("Vaibhav", CustomerType.REGULAR);

			if (customer.getType() == null) {
				throw new BillingException("Customer Type should be correct.");
			}

			// Handling final Order
			Order order = new Order(customer);
			order.addItem(groceryItem);
			order.addItems(otherItem, 1);
			order.setCreatedBy(employee.getId());
			customer.setOrder(order);

			if (customer.getOrder().getTotalAmount() <= 0.0) {
				throw new BillingException("Billed amount should be a positive number.");
			}

			// Display result
			System.out.println("Total Amount : " + order.getTotalAmount());
			System.out.println("Net Amount( After applying discount) : " + order.getNetAmount());

		} catch (Exception e) {
			System.err.println("Transaction failed : " + e.getMessage());
		}

	}

}
