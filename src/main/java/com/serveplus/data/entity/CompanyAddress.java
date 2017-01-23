package com.serveplus.data.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_ADDRESS")
@AssociationOverrides({
    @AssociationOverride(name = "companyAddressId.company",
        joinColumns = @JoinColumn(name = "COMPANY_ID")),
    @AssociationOverride(name = "companyAddressId.address",
        joinColumns = @JoinColumn(name = "ADDRESS_ID")) })
public class CompanyAddress {
		
	@Id
	private CompanyAddresId companyAddressId;
	
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

	public CompanyAddresId getCompanyAddressId() {
		return companyAddressId;
	}

	public void setCompanyAddressId(CompanyAddresId companyAddressId) {
		this.companyAddressId = companyAddressId;
	}
}
