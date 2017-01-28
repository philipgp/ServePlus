package com.serveplus.web.response.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListToSetMapper<T,V> { 
	
	public Set<V> mapFrom(List<T> sourceItems,Mapper<T,V> mapper){
		Set<V> mappedItems = new HashSet<V>();
		if(sourceItems!=null){
			for(T sourceItem:sourceItems){
				V destinationItem = mapper.mapFrom(sourceItem);
				mappedItems.add(destinationItem);
			}
		}
		return mappedItems;
	}
}
