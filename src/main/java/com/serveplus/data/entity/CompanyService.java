package com.serveplus.data.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_SERVICE")
@AssociationOverrides({
    @AssociationOverride(name = "companyServiceId.company",
        joinColumns = @JoinColumn(name = "COMPANY_ID")),
    @AssociationOverride(name = "companyServiceId.service",
        joinColumns = @JoinColumn(name = "SERVICE_ID")) })
public class CompanyService {
		
	@Id
	private CompanyServiceId companyServiceId;
	
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

	public CompanyServiceId getCompanyServiceId() {
		return companyServiceId;
	}

	public void setCompanyServiceId(CompanyServiceId companyServiceId) {
		this.companyServiceId = companyServiceId;
	}

	
}
