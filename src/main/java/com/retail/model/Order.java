package com.retail.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.retail.discount.DiscountCalculationImpl;
import com.retail.model.audit.UserDateAudit;

/**
 * The {@code Order} class responsible to add items in cart and calculate the
 * final net amount.
 */
public class Order extends UserDateAudit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double totalAmount;
	private double discountAmount;
	private double netAmount;
	private Map<Item, Integer> items;
	private Customer customer;
	private DiscountCalculationImpl discountCalculationImpl = new DiscountCalculationImpl();;

	public Order(Customer customer) {
		items = new LinkedHashMap<Item, Integer>(); // To maintain same order as product added
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getNetAmount() {
		// Final billing call
		if (discountCalculationImpl != null) {
			discountAmount = discountCalculationImpl.calculateDiscount(customer, getTotalAmount());
		}
		netAmount = totalAmount - discountAmount;
		
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	// To add an item in cart with default 1 quantity.
	public void addItem(Item itemToBuy) {
		addItems(itemToBuy, 1);
	}

	/**
	 * Add an item in cart with quantity.
	 * 
	 * @param itemToBuy
	 * @param quantity
	 */
	public void addItems(Item itemToBuy, int quantity) {

		// TODO Handle if there are any product related discounts
		
		// Update map with items
		int previousQuantity = items.containsKey(itemToBuy) ? items.get(itemToBuy) : 0;
		items.put(itemToBuy, previousQuantity + quantity);
		
		// Update total amount
		totalAmount += itemToBuy.priceForQuantity(quantity);
	}
	
	//TODO handle remove item

}
