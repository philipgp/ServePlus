package com.serveplus.data.dao;

import java.util.List;
import java.util.Set;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.ContactDetail;
import com.serveplus.data.entity.ServiceContactDetail;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.User;

public interface ServiceContactDetailDao {
	
	
	public void saveServiceContactDetails(Set<ServiceContactDetail> serviceContactDetails);
	public void save(ServiceContactDetail serviceContactDetail);
	
}
