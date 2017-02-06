package com.serveplus.web.response.assigner.mapper;

import java.util.List;

import com.serveplus.data.entity.User;
import com.serveplus.data.entity.UserAddress;
import com.serveplus.data.entity.UserContact;
import com.serveplus.data.entity.WorkerService;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.assigner.WorkerForServiceVO;
import com.serveplus.web.response.customer.UserAddressVOMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.SetToListMapper;
import com.serveplus.web.response.mapper.customer.UserContactVoMapper;

public class WorkerForServiceVOMapper implements Mapper<WorkerService,WorkerForServiceVO>{

	@Override
	public WorkerForServiceVO mapFrom(WorkerService source) {
		WorkerForServiceVO workerServiceVO = new WorkerForServiceVO();
		User user = source.getWorkerServiceId().getWorker().getUser();
		workerServiceVO.setFirstName(user.getFirstName());
		workerServiceVO.setMiddleName(user.getMiddleName());
		workerServiceVO.setLastName(user.getLastName());
		
		UserAddressVOMapper useraddressMapper = new UserAddressVOMapper();
		SetToListMapper<UserAddress,AddressVO> addressListMapper = new SetToListMapper<UserAddress, AddressVO>();
		List<AddressVO> addresses = addressListMapper.mapFrom(user.getUserAddresses(), useraddressMapper);
		workerServiceVO.setAddresses(addresses);
		
		UserContactVoMapper userContactMapper = new UserContactVoMapper();
		SetToListMapper<UserContact,ContactVO> userContactListMapper = new SetToListMapper<UserContact,ContactVO>();
		List<ContactVO> contacts = userContactListMapper.mapFrom(user.getUserContactDetails(), userContactMapper);
		workerServiceVO.setContactInfos(contacts);
		
		return workerServiceVO;
	}

}
