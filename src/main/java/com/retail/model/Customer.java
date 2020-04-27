package com.retail.model;

import com.retail.model.audit.DateAudit;

/**
 * Associated with <code>Customer</code>
 * @author Vaibhav
 *
 */
public class Customer extends DateAudit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String Address;
	private String city;
	private CustomerType type;
	
	// Composition association - Order associated with Customer.
	private Order order;

	public Customer(String name, CustomerType customerType) {
		this.name = name;
		this.type = customerType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}