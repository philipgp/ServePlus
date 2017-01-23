package com.serveplus.data.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ADDRESS")
@AssociationOverrides({
    @AssociationOverride(name = "userAddressId.user",
        joinColumns = @JoinColumn(name = "USER_ID")),
    @AssociationOverride(name = "userAddressId.address",
        joinColumns = @JoinColumn(name = "ADDRESS_ID")) })
public class UserAddress {
		
	@Id
	private UserAddresId userAddressId;
	
	@Column(name = "DEFAULT")
	private Boolean isDefault;
	
	@Column(name = "ACTIVE")
	private Boolean active;

	public UserAddresId getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(UserAddresId userAddressId) {
		this.userAddressId = userAddressId;
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
