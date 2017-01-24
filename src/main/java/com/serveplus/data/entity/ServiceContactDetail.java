package com.serveplus.data.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SR_CONTACT")
@AssociationOverrides({
    @AssociationOverride(name = "serviceContactDetailId.serviceRequest",
        joinColumns = @JoinColumn(name = "SR_ID")),
    @AssociationOverride(name = "serviceContactDetailId.contactDetail",
        joinColumns = @JoinColumn(name = "CONTACT_DETAIL_ID")) })
public class ServiceContactDetail {

	
	@Id
	private ServiceContactDetailId serviceContactDetailId;
	
	public ServiceContactDetailId getServiceContactDetailId() {
		return serviceContactDetailId;
	}

	public void setServiceContactDetailId(
			ServiceContactDetailId serviceContactDetailId) {
		this.serviceContactDetailId = serviceContactDetailId;
	}

}
