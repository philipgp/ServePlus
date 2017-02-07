package com.serveplus.web.response.admin.mapper;

import java.util.List;

import com.serveplus.data.entity.User;
import com.serveplus.data.entity.UserAddress;
import com.serveplus.data.entity.UserContact;
import com.serveplus.data.entity.Worker;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.admin.WorkerSummaryVO;
import com.serveplus.web.response.customer.UserAddressVOMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.SetToListMapper;
import com.serveplus.web.response.mapper.customer.UserContactVoMapper;

public class WorkerSummaryVOMapper implements Mapper<Worker,WorkerSummaryVO>{

	@Override
	public WorkerSummaryVO mapFrom(Worker source) {
		WorkerSummaryVO workerSummary = new WorkerSummaryVO();
		User user = source.getUser();
		workerSummary.setFirstName(user.getFirstName());;
		workerSummary.setMiddleName(user.getMiddleName());
		workerSummary.setLastName(user.getLastName());;
		workerSummary.setWorkerId(source.getId());
		
		UserAddressVOMapper useraddressMapper = new UserAddressVOMapper();
		SetToListMapper<UserAddress,AddressVO> addressListMapper = new SetToListMapper<UserAddress, AddressVO>();
		List<AddressVO> addresses = addressListMapper.mapFrom(user.getUserAddresses(), useraddressMapper);
		workerSummary.setAddresses(addresses);
		
		UserContactVoMapper userContactMapper = new UserContactVoMapper();
		SetToListMapper<UserContact,ContactVO> userContactListMapper = new SetToListMapper<UserContact,ContactVO>();
		List<ContactVO> contacts = userContactListMapper.mapFrom(user.getUserContactDetails(), userContactMapper);
		workerSummary.setContactInfos(contacts);
		
		return workerSummary;
	}

}
