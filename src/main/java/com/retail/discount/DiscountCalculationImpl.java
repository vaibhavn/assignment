package com.retail.discount;

import java.util.List;
import java.util.stream.Collectors;

import com.retail.model.Customer;
import com.retail.model.Discount;
import com.retail.service.DiscountService;

/**
 * This class is responsible to calculate discount.
 * 
 * @author Vaibhav
 *
 */
public class DiscountCalculationImpl implements DiscountPolicy {

	@Override
	public double calculateDiscount(Customer customer, double amount) {
		// Get all Discounts
		List<Discount> discounts = DiscountService.getInstance().getDiscountList();
		
		// Filter Discount list with respective Customer type.
		discounts = discounts.stream().filter(d -> d.getCustomerType().equals(customer.getType()))
				.collect(Collectors.toList());

		// Calculate discounts on provided amount
		double discountAmount = 0;
		double tmpDiscountAmount = 0;
		double tmpAmount = 0;
		
		for (Discount discount : discounts) {
			
			if (discount.getMaxCriteriaAmount() < amount) {
				// works on Min-Max criteria amount, when amount is greater than max criteria discount amount.
				tmpAmount = discount.getMaxCriteriaAmount() - discount.getMinCriteriaAmount();
			} else {
				// When there is remaining amount from total amount.
				tmpAmount = amount - discount.getMinCriteriaAmount();
			}

			// Add discount amounts
			// TODO can be made more modular.
			if (discount.getMinCriteriaAmount() < amount) {
				tmpDiscountAmount = (tmpAmount * discount.getDiscountPercent()) / 100;
				discountAmount = discountAmount + tmpDiscountAmount;
			} else {
				return discountAmount;
			}
		}

		return discountAmount;
	}
}