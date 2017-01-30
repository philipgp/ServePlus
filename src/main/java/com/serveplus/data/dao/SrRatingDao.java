package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestRatingFeedback;

public interface SrRatingDao {
	public List<ServiceRequestRatingFeedback> findByServiceRequest(ServiceRequest serviceRequest);
	public void saveAll(List<ServiceRequestRatingFeedback> feedbacks);
}
