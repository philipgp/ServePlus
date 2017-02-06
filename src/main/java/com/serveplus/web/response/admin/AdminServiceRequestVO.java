package com.serveplus.web.response.admin;

import java.util.List;

import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.LocationVO;

public class AdminServiceRequestVO {
	private Long serviceRequestId;
	private Long assignerId;
	private Long workerId;
	private Long companyId;
	private Long serviceId;
	private String requestSummary;
	private LocationVO location;
	private List<ContactVO> contactInfos;
	private AddressVO addresses;
	private Long customerId;
	private ServiceRequestStatus status;
	public ServiceRequestStatus getStatus() {
		return status;
	}
	public void setStatus(ServiceRequestStatus status) {
		this.status = status;
	}
	public Long getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public Long getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(Long assignerId) {
		this.assignerId = assignerId;
	}
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public String getRequestSummary() {
		return requestSummary;
	}
	public void setRequestSummary(String requestSummary) {
		this.requestSummary = requestSummary;
	}
	public LocationVO getLocation() {
		return location;
	}
	public void setLocation(LocationVO location) {
		this.location = location;
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
		builder.append("AssignerWork [serviceRequestId=")
				.append(serviceRequestId).append(", assignerId=")
				.append(assignerId).append(", workerId=").append(workerId)
				.append(", companyId=").append(companyId)
				.append(", serviceId=").append(serviceId)
				.append(", requestSummary=").append(requestSummary)
				.append(", location=").append(location)
				.append(", contactInfos=").append(contactInfos)
				.append(", addresses=").append(addresses)
				.append(", customerId=").append(customerId).append("]");
		return builder.toString();
	}
	public AddressVO getAddresses() {
		return addresses;
	}
	public void setAddresses(AddressVO addresses) {
		this.addresses = addresses;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
