package com.retail.discount;

import com.retail.model.Customer;

/**
 * Functional interface responsible to calculate discount.
 * @author Vaibhav
 *
 */
@FunctionalInterface
public interface DiscountPolicy {	
	double calculateDiscount(Customer customer, double amount);
}