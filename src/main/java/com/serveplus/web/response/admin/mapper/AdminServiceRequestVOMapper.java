package com.serveplus.web.response.admin.mapper;

import java.util.List;

import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.ServiceContactDetail;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.AddressMapper;
import com.serveplus.web.response.admin.AdminServiceRequestVO;
import com.serveplus.web.response.assigner.AssignerWork;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.SetToListMapper;
import com.serveplus.web.response.mapper.customer.ServiceRequestContactDetailVOMapper;

public class AdminServiceRequestVOMapper implements Mapper<ServiceRequest,AdminServiceRequestVO>{

	@Override
	public AdminServiceRequestVO mapFrom(ServiceRequest source) {
		AdminServiceRequestVO adminServiceRequestVO = new AdminServiceRequestVO();

		
		AddressMapper addressMapper = new AddressMapper();
		//SetToListMapper<UserAddress,AddressVO> addressListMapper = new SetToListMapper<UserAddress, AddressVO>();
		AddressVO addresses = addressMapper.mapFrom(source.getAddress());
		adminServiceRequestVO.setAddresses(addresses);
		
		ServiceRequestContactDetailVOMapper srContactMapper = new ServiceRequestContactDetailVOMapper();
		SetToListMapper<ServiceContactDetail,ContactVO> userContactListMapper = new SetToListMapper<ServiceContactDetail,ContactVO>();
		List<ContactVO> contacts = userContactListMapper.mapFrom(source.getServiceContactDetails(),srContactMapper); 
		adminServiceRequestVO.setContactInfos(contacts);
		if(source.getAssigner()!=null)
			adminServiceRequestVO.setAssignerId(source.getAssigner().getId());
		
		if(source.getCompanyService()!=null){
			CompanyService companyService = source.getCompanyService();
			adminServiceRequestVO.setCompanyId(companyService.getCompany().getId());
			adminServiceRequestVO.setServiceId(companyService.getService().getId());
		}
		if(source.getWorker()!=null)
			adminServiceRequestVO.setWorkerId(source.getWorker().getId());
		
		if(source.getCustomer()!=null)
			adminServiceRequestVO.setCustomerId(source.getCustomer().getId());
		
		
		adminServiceRequestVO.setServiceRequestId(source.getId());
		adminServiceRequestVO.setRequestSummary(source.getRequest());
		adminServiceRequestVO.setStatus(source.getStatus());
		return adminServiceRequestVO;
	}

}
