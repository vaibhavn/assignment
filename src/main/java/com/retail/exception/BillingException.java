package com.retail.exception;

/**
 * Billing related user defined Exception.
 * 
 * @author Vaibhav
 *
 */
public class BillingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BillingException(String messge) {
		super(messge);
	}
}