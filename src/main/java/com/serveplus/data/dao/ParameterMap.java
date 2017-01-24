package com.serveplus.data.dao;

import java.util.HashMap;

public class ParameterMap {
	HashMap<String, Object> parameterMap = new HashMap<String, Object>();
	public void add(String key,Object value){
		parameterMap.put(key, value);
	}
	public HashMap<String, Object> getParameterMap() {
		return parameterMap;
	}
	public void setParameterMap(HashMap<String, Object> parameterMap) {
		this.parameterMap = parameterMap;
	}
}
