package com.retail.model;

import java.time.Instant;

import com.retail.model.audit.UserDateAudit;

/**
 * The {@code SaleEvent} class provides information about an event start and end
 * date time.
 * 
 * @author Vaibhav
 *
 */
public class SaleEvent extends UserDateAudit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	private Instant startAt;
	private Instant endAt;
	
	
	/**
	 * Constructor
	 * @param name
	 * @param description
	 * @param startAt
	 * @param endAt
	 */
	public SaleEvent(String name, String description, Instant startAt, Instant endAt) {
		super();
		this.name = name;
		this.description = description;
		this.startAt = startAt;
		this.endAt = endAt;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getStartAt() {
		return startAt;
	}

	public void setStartAt(Instant startAt) {
		this.startAt = startAt;
	}

	public Instant getEndAt() {
		return endAt;
	}

	public void setEndAt(Instant endAt) {
		this.endAt = endAt;
	}

}
