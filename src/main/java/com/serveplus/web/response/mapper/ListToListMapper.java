package com.serveplus.web.response.mapper;

import java.util.ArrayList;
import java.util.List;

public class ListToListMapper<T,V> { 
	
	public List<V> mapFrom(List<T> sourceItems,Mapper<T,V> mapper){
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
