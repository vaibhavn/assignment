package com.retail.model;

/**
 * Different discounts/offers when festival/sales events.
 * 
 * @author Vaibhav
 *
 */
public class Discount {
	private Integer id;
	
	// Associated sale event
	private Integer eventId;
	
	// Minimum amount range to get an discount
	private double minCriteriaAmount;
	
	// Maximum amount range to get an discount
	private double maxCriteriaAmount;
	
	// Flat discount amount
	private double discount;
	
	// Discount in percentage
	private double discountPercent;

	// TODO we can create different discount types too like discount on product,
	// product types, customer type etc.
	private CustomerType customerType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public double getMinCriteriaAmount() {
		return minCriteriaAmount;
	}

	public void setMinCriteriaAmount(double minCriteriaAmount) {
		this.minCriteriaAmount = minCriteriaAmount;
	}

	public double getMaxCriteriaAmount() {
		return maxCriteriaAmount;
	}

	public void setMaxCriteriaAmount(double maxCriteriaAmount) {
		this.maxCriteriaAmount = maxCriteriaAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

}
