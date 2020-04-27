package com.retail.model;

import com.retail.constant.ItemType;

/**
 * Interface for all items
 * @author Vaibhav
 */
public interface Item {
	/**
	 * It returns an item's base price.
	 * @return
	 */
	double getPrice(); // We also need to consider currency formatter in future scope.

	/**
	 * It returns price * item quantity.
	 * @param quantity
	 * @return
	 */
	double priceForQuantity(int quantity);

	String getName();

	ItemType getType();
}
