package com.retail.service;

import java.util.ArrayList;
import java.util.List;

import com.retail.model.CustomerType;
import com.retail.model.Discount;

/**
 * This class is singleton, works on Discount related tasks.
 * Responsible to work with database.
 * 
 * @author Vaibhav
 *
 */
public class DiscountService {

	// TODO we will have static DAO object for complete implementation.
	public static DiscountService discountService = null;

	private List<Discount> discountList;

	/**
	 * Make it provate so that can not instantiate from externally.  
	 */
	private DiscountService() {
	}

	/**
	 * Get instance of Discount Service.
	 * @return returns instance of discount service.
	 */
	public static DiscountService getInstance() {
		if (discountService == null) {

			// synchronized required otherwise two threads execute as same time
			// then it will create 2 objects.
			synchronized (DiscountService.class) {
				if (discountService == null) // Double checking
				{
					discountService = new DiscountService();
				}
			}
		}
		return discountService;
	}

	/**
	 * Get all available discount list.
	 * @return
	 */
	public List<Discount> getDiscountList() {
		if (discountList == null) {
			discountList = new ArrayList<Discount>();

			Discount discount = new Discount();
			discount.setCustomerType(CustomerType.REGULAR);
			discount.setDiscountPercent(0);
			discount.setMinCriteriaAmount(0);
			discount.setMaxCriteriaAmount(5000);
			discountList.add(discount);

			discount = new Discount();
			discount.setCustomerType(CustomerType.REGULAR);
			discount.setDiscountPercent(10);
			discount.setMinCriteriaAmount(5000);
			discount.setMaxCriteriaAmount(10000);
			discountList.add(discount);

			discount = new Discount();
			discount.setCustomerType(CustomerType.REGULAR);
			discount.setDiscountPercent(20);
			discount.setMinCriteriaAmount(10000);
			discount.setMaxCriteriaAmount(Float.MAX_VALUE); // TODO set some max transaction limit per order
			discountList.add(discount);

			discount = new Discount();
			discount.setCustomerType(CustomerType.PREMIUM);
			discount.setDiscountPercent(10);
			discount.setMinCriteriaAmount(0);
			discount.setMaxCriteriaAmount(4000);
			discountList.add(discount);

			discount = new Discount();
			discount.setCustomerType(CustomerType.PREMIUM);
			discount.setDiscountPercent(15);
			discount.setMinCriteriaAmount(4000);
			discount.setMaxCriteriaAmount(8000);
			discountList.add(discount);

			discount = new Discount();
			discount.setCustomerType(CustomerType.PREMIUM);
			discount.setDiscountPercent(20);
			discount.setMinCriteriaAmount(8000);
			discount.setMaxCriteriaAmount(12000);
			discountList.add(discount);

			discount = new Discount();
			discount.setCustomerType(CustomerType.PREMIUM);
			discount.setDiscountPercent(30);
			discount.setMinCriteriaAmount(12000);
			discount.setMaxCriteriaAmount(Float.MAX_VALUE);
			discountList.add(discount);

		}

		return discountList;
	}
}
