package com.serveplus.data.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CS_ASSIGNER")
@AssociationOverrides({
    @AssociationOverride(name = "csAssignerId.companyService",
        joinColumns = @JoinColumn(name = "CS_ID")),
    @AssociationOverride(name = "csAssignerId.assigner",
        joinColumns = @JoinColumn(name = "ASSIGNER_ID")) })
public class CsAssigner {
		
	@Id
	private CsAssignerId csAssignerId;
	
	@Column(name = "DEFAULT")
	private Boolean isDefault;
	
	@Column(name = "ACTIVE")
	private Boolean active;

	
	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public CsAssignerId getCsAssignerId() {
		return csAssignerId;
	}

	public void setCsAssignerId(CsAssignerId csAssignerId) {
		this.csAssignerId = csAssignerId;
	}

	
}
