package com.serveplus.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.serveplus.data.dao.EntityBaseEventListener;

@MappedSuperclass
@EntityListeners(EntityBaseEventListener.class)
public class EntityBase {

	/*@Column(name="CREATED_BY")
	protected String createdBy;*/ 
	
	@Column(name="CREATED_DATE", nullable = false, updatable = false)
	//@CreatedDate
	protected Date createdDate;
	
	/*@Column(name="LAST_MODIFIED_BY")
	@LastModifiedBy
	protected String modifiedBy;*/
	
	@Column(name="LAST_MODIFIED_DATE")
	//@LastModifiedDate
	protected Date modifiedDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
