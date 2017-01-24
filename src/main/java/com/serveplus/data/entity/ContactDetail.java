package com.serveplus.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_DETAIL")
public class ContactDetail extends EntityBase{
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	
	@Column(name = "VALUE")
	private String value;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
