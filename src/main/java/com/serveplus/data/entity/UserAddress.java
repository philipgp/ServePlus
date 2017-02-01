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
@Table(name = "USER_ADDRESS")
/*@AssociationOverrides({
    @AssociationOverride(name = "userAddressId.user",
        joinColumns = @JoinColumn(name = "USER_ID")),
    @AssociationOverride(name = "userAddressId.address",
        joinColumns = @JoinColumn(name = "ADDRESS_ID")) })*/
public class UserAddress {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user; 

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
