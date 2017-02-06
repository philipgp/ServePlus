package com.serveplus.data.dao;

import java.util.HashMap;
import java.util.List;

public class ParameterMap {
	HashMap<String, Object> parameterMap = new HashMap<String, Object>();
	HashMap<String, List> parameterListMap = new HashMap<String, List>();
	public void add(String key,Object value){
		parameterMap.put(key, value);
	}
	public void addList(String key,List value){
		parameterListMap.put(key, value);
	}
	public HashMap<String, Object> getParameterMap() {
		return parameterMap;
	}
	public void setParameterMap(HashMap<String, Object> parameterMap) {
		this.parameterMap = parameterMap;
	}
	public HashMap<String, List> getParameterListMap() {
		return parameterListMap;
	}
	public void setParameterListMap(HashMap<String, List> parameterListMap) {
		this.parameterListMap = parameterListMap;
	}
}
