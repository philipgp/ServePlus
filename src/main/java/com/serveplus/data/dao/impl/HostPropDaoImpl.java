package com.serveplus.data.dao.impl;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.HostPropDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.HostProp;

@Component
public class HostPropDaoImpl extends BaseDataService<HostProp> implements HostPropDao{

	@Override
	public String getValue(String key) {
		String hql = "from HostProp where key = :key";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("key", key);
		HostProp result = getOneResult(hql, parameterMap);
		return result.getValue();
	}

}
