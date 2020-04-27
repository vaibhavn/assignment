package com.retail.model;

import com.retail.constant.RoleName;

/**
 * User role for store management system.
 * 
 * @author Vaibhav
 *
 */
public class Role {
	private Long id;

	private RoleName name;

	public Role() {
	}

	public Role(RoleName name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

}
