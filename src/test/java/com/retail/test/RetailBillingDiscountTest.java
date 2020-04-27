package com.retail.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.retail.constant.ItemType;
import com.retail.constant.RoleName;
import com.retail.model.Customer;
import com.retail.model.CustomerType;
import com.retail.model.Item;
import com.retail.model.Order;
import com.retail.model.Product;
import com.retail.model.Role;
import com.retail.model.User;

/*
 * Test Cases for discount policy
 */
public class RetailBillingDiscountTest {

	private Customer regularCustomer;
	private Customer premiumCustomer;
	private Item groceryItem;
	private Item otherItem;
	private User salesman;

	@Before
	public void setUp() throws Exception {
		// Login user
		Role role = new Role(RoleName.ROLE_SALES);
		salesman = new User(role, "John");
					
		// Items added in to cart
		groceryItem = new Product("Track Pant", 2000, ItemType.GROCERY);
		otherItem = new Product("T-Shirt", 2000, ItemType.OTHER);

		// Customer details
		regularCustomer = new Customer("Vaibhav", CustomerType.REGULAR);
		premiumCustomer = new Customer("Vivek", CustomerType.PREMIUM);
		
	}

	@Test
	public void test_regularCustomer() {
		
		// Handling final Order
		Order order = new Order(regularCustomer);
		order.addItem(groceryItem);
		order.addItems(otherItem, 1);
		order.setCreatedBy(salesman.getId());
		regularCustomer.setOrder(order);
		
		// Validate net amount
		assertEquals(4000, order.getNetAmount(), 0.1);
		
		Item randomItem =  new Product("Mobile", 11000, ItemType.GROCERY); 
		order.addItem( randomItem);
		
		// Validate net amount
		assertEquals(13500, order.getNetAmount(), 0.1);
	}
	
	
	@Test
	public void test_premiumcustomer() {
		
		// Order for 
		Order order = new Order(premiumCustomer);
		order.addItem(groceryItem);
		order.addItems(otherItem, 1);
		order.setCreatedBy(salesman.getId());
		regularCustomer.setOrder(order);
		
		// Display result
		assertEquals(3600, order.getNetAmount(), 0.1);
		
		Item randomItem =  new Product("Mobile", 8000, ItemType.GROCERY); 
		order.addItems( randomItem, 2); // quantity 2
		
		// Validate net amount
		assertEquals(15800, order.getNetAmount(), 0.1);
		
	}
	
	//TODO add some negative tests.

}
