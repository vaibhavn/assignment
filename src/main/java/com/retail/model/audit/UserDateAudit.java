package com.retail.model.audit;

public abstract class UserDateAudit extends DateAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long createdBy;

	private Long updatedBy;

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
}
