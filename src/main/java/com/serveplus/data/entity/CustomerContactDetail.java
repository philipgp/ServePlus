package com.serveplus.data.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_CONTACT")
@AssociationOverrides({
    @AssociationOverride(name = "customerContactDetailId.customer",
        joinColumns = @JoinColumn(name = "CUSTOMER_ID")),
    @AssociationOverride(name = "customerContactDetailId.contactDetail",
        joinColumns = @JoinColumn(name = "CONTACT_DETAIL_ID")) })
public class CustomerContactDetail {

	
	@Id
	private CustomerContactDetailId customerContactDetailId;

	public CustomerContactDetailId getCustomerContactDetailId() {
		return customerContactDetailId;
	}

	public void setCustomerContactDetailId(
			CustomerContactDetailId customerContactDetailId) {
		this.customerContactDetailId = customerContactDetailId;
	}

	
	

}
