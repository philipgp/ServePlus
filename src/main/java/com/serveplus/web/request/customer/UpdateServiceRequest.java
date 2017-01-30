package com.serveplus.web.request.customer;

public class UpdateServiceRequest extends CreateServiceRequestBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = -469684772569934750L;
	private Long serviceRequestId;

	public Long getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateServiceRequest [serviceRequestId=")
				.append(serviceRequestId).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}

	

	
}
