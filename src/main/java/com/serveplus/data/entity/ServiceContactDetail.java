package com.serveplus.data.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SR_CONTACT")
/*@AssociationOverrides({
    @AssociationOverride(name = "serviceContactDetailId.serviceRequest",
        joinColumns = @JoinColumn(name = "SR_ID")),
    @AssociationOverride(name = "serviceContactDetailId.contactDetail",
        joinColumns = @JoinColumn(name = "CONTACT_DETAIL_ID")) })*/
public class ServiceContactDetail implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6845845327519021190L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "SR_ID")
	private ServiceRequest serviceRequest;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CONTACT_DETAIL_ID")
	private ContactDetail contactDetail;

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public ContactDetail getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(ContactDetail contactDetail) {
		this.contactDetail = contactDetail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	/*@EmbeddedId
	private ServiceContactDetailId serviceContactDetailId =new ServiceContactDetailId();
	
	public ServiceContactDetailId getServiceContactDetailId() {
		return serviceContactDetailId;
	}

	public void setServiceContactDetailId(
			ServiceContactDetailId serviceContactDetailId) {
		this.serviceContactDetailId = serviceContactDetailId;
	}
*/
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((serviceContactDetailId == null) ? 0
						: serviceContactDetailId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceContactDetail other = (ServiceContactDetail) obj;
		if (serviceContactDetailId == null) {
			if (other.serviceContactDetailId != null)
				return false;
		} else if (!serviceContactDetailId.equals(other.serviceContactDetailId))
			return false;
		return true;
	}*/

}
