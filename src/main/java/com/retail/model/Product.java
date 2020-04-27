package com.retail.model;

import com.retail.constant.ItemType;

/**
 * Class for actual product items
 */
public class Product implements Item {

	private final String name;
	private final double price;
	private final ItemType type;

	public Product(String name, double price, ItemType type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public double priceForQuantity(int quantity) {
		return price * quantity;
	}

	public ItemType getType() {
		return type;
	}
}
