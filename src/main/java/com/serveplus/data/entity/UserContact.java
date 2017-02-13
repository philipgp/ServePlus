package com.serveplus.data.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_CONTACT")
/*@AssociationOverrides({
    @AssociationOverride(name = "customerContactDetailId.customer",
        joinColumns = @JoinColumn(name = "CUSTOMER_ID")),
    @AssociationOverride(name = "customerContactDetailId.contactDetail",
        joinColumns = @JoinColumn(name = "CONTACT_DETAIL_ID")) })*/
public class UserContact {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CONTACT_DETAIL_ID")
	private ContactDetail contactDetail;
	
	@Column(name = "ISDEFAULT")
	private Boolean isDefault;
	
	@Column(name = "ACTIVE")
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ContactDetail getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(ContactDetail contactDetail) {
		this.contactDetail = contactDetail;
	}

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
	

}
