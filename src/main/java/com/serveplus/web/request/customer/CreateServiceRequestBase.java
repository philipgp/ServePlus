package com.serveplus.web.request.customer;

import java.util.List;

import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.LocationVO;
import com.serveplus.web.response.PreferredTime;

public class CreateServiceRequestBase extends CustomerBaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 607950630363214525L;
	private LocationVO location;
	protected AddressVO localAddress;
	protected String request;
	private PreferredTime preferredTime;
	private List<ContactVO> contactInfos;
	

	public LocationVO getLocation() {
		return location;
	}

	public void setLocation(LocationVO location) {
		this.location = location;
	}

	public AddressVO getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(AddressVO localAddress) {
		this.localAddress = localAddress;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public PreferredTime getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(PreferredTime preferredTime) {
		this.preferredTime = preferredTime;
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
		builder.append("CreateServiceRequestBase [location=").append(location)
				.append(", localAddress=").append(localAddress)
				.append(", request=").append(request)
				.append(", preferredTime=").append(preferredTime)
				.append(", contactInfos=").append(contactInfos).append("]");
		return builder.toString();
	}

	/*public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}*/
	
}
