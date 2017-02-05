package com.serveplus.web.request.register;

import java.util.List;

import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.request.ServePlusRequest;

public class RegisterCompanyRequest extends ServePlusRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8856245249012409024L;
	
	private String name;
	private List<AddressVO> addresses;
	private List<ContactVO> contactInfos;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<AddressVO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressVO> addresses) {
		this.addresses = addresses;
	}
	public List<ContactVO> getContactInfos() {
		return contactInfos;
	}
	public void setContactInfos(List<ContactVO> contactInfos) {
		this.contactInfos = contactInfos;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterCompanyRequest [name=").append(name)
				.append(", addresses=").append(addresses)
				.append(", contactInfos=").append(contactInfos).append("]");
		return builder.toString();
	}

}
