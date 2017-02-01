package com.serveplus.data.dao.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ContactDetailDao;
import com.serveplus.data.dao.ServiceContactDetailDao;
import com.serveplus.data.entity.ServiceContactDetail;
@Component
public class ServiceContactDetailDaoImpl extends BaseDataService<ServiceContactDetail> implements ServiceContactDetailDao{

	@Autowired
	ContactDetailDao contactDetailDao;
	@Override
	public void saveServiceContactDetails(
			Set<ServiceContactDetail> serviceContactDetails) {
		for(ServiceContactDetail serviceContactDetail:serviceContactDetails){
			//contactDetailDao.save(serviceContactDetail.getServiceContactDetailId().getContactDetail());
			save(serviceContactDetail);
		}
		
		// TODO Auto-generated method stub
		
	}
  
}
