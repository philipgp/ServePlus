package com.serveplus.web.request.customer;

import com.serveplus.web.request.AddressVO;

public class CreateServiceRequestBase extends CustomerBaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 607950630363214525L;
	protected Float latitude;
	protected Float longitude;
	protected AddressVO localAddress;
	protected String request;

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
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

	/*public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}*/
	
}
