package com.serveplus.web.request.customer;

import com.serveplus.web.request.AddressVO;

public class CreateServiceRequest extends CustomerBaseRequest{
	private Long serviceId;
	private Long companyId;
	private Float latitude,longitude;
	private AddressVO localAddress;
	private String comment;
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "CreateServiceRequest [serviceId=" + serviceId + ", companyId="
				+ companyId + ", latitude=" + latitude + ", longitude="
				+ longitude + ", localAddress=" + localAddress + ", comment="
				+ comment + "]";
	}
}
