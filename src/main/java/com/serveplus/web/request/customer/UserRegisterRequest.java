package com.serveplus.web.request.customer;

import java.util.Date;
import java.util.List;

import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.request.ServePlusRequest;

public class UserRegisterRequest extends ServePlusRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6095795038534237946L;
	private List<ContactVO> contactInfos;
	private String firstName;
	private String middleName;
	private String title;
	private String lastName;
	private Date dateOfBirth;
	private List<AddressVO> addresses;

	public List<ContactVO> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(List<ContactVO> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<AddressVO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressVO> addresses) {
		this.addresses = addresses;
	}

	
	
}
