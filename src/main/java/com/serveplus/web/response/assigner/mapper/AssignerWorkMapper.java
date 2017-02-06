package com.serveplus.web.response.assigner.mapper;

import java.util.List;

import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.ServiceContactDetail;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.UserContact;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.AddressMapper;
import com.serveplus.web.response.assigner.AssignerWork;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.SetToListMapper;
import com.serveplus.web.response.mapper.customer.ServiceRequestContactDetailVOMapper;

public class AssignerWorkMapper implements Mapper<ServiceRequest,AssignerWork>{

	@Override
	public AssignerWork mapFrom(ServiceRequest source) {
		AssignerWork assignerWork = new AssignerWork();
		
		AddressMapper addressMapper = new AddressMapper();
		//SetToListMapper<UserAddress,AddressVO> addressListMapper = new SetToListMapper<UserAddress, AddressVO>();
		AddressVO addresses = addressMapper.mapFrom(source.getAddress());
		assignerWork.setAddresses(addresses);
		
		ServiceRequestContactDetailVOMapper srContactMapper = new ServiceRequestContactDetailVOMapper();
		SetToListMapper<ServiceContactDetail,ContactVO> userContactListMapper = new SetToListMapper<ServiceContactDetail,ContactVO>();
		List<ContactVO> contacts = userContactListMapper.mapFrom(source.getServiceContactDetails(),srContactMapper); 
		assignerWork.setContactInfos(contacts);
		if(source.getAssigner()!=null)
			assignerWork.setAssignerId(source.getAssigner().getId());
		
		if(source.getCompanyService()!=null){
			CompanyService companyService = source.getCompanyService();
			assignerWork.setCompanyId(companyService.getCompany().getId());
			assignerWork.setServiceId(companyService.getService().getId());
		}
		if(source.getWorker()!=null)
			assignerWork.setWorkerId(source.getWorker().getId());
		
		if(source.getCustomer()!=null)
			assignerWork.setCustomerId(source.getCustomer().getId());
		
		
		assignerWork.setServiceRequestId(source.getId());
		assignerWork.setRequestSummary(source.getRequest());
		assignerWork.setStatus(source.getStatus());
		return assignerWork;
	}

}
