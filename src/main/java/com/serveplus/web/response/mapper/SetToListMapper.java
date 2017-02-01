package com.serveplus.web.response.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToListMapper<T,V> { 
	
	public List<V> mapFrom(Set<T> sourceItems,Mapper<T,V> mapper){
		List<V> mappedItems = new ArrayList<V>();
		if(sourceItems!=null){
			for(T sourceItem:sourceItems){
				V destinationItem = mapper.mapFrom(sourceItem);
				mappedItems.add(destinationItem);
			}
		}
		return mappedItems;
	}
}
