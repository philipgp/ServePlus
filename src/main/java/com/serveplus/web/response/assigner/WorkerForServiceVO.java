package com.serveplus.web.response.assigner;

import java.util.List;

import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;

public class WorkerForServiceVO {
	private Long workerId;
	private List<ContactVO> contactInfos;
	private List<AddressVO> addresses;
	private String firstName,middleName,lastName;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	public List<ContactVO> getContactInfos() {
		return contactInfos;
	}
	public void setContactInfos(List<ContactVO> contactInfos) {
		this.contactInfos = contactInfos;
	}
	public List<AddressVO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressVO> addresses) {
		this.addresses = addresses;
	}
}
