package com.serveplus.web.request;

import com.serveplus.data.entity.ContactType;

public class ContactVO {
	private ContactType type;
	private String value;
	private Boolean IsDefault;
	private Boolean IsActive;
	public ContactType getType() {
		return type;
	}
	public void setType(ContactType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Boolean getIsDefault() {
		return IsDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		IsDefault = isDefault;
	}
	public Boolean getIsActive() {
		return IsActive;
	}
	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}
}
