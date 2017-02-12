package com.serveplus.web.response.customer;

public class CompanyServiceVO {
	private Long serviceId;
	private String serviceName;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyServiceVO [serviceId=").append(serviceId)
				.append(", serviceName=").append(serviceName).append("]");
		return builder.toString();
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
