package com.serveplus.web.response.mapper;

public interface Mapper<T,V> {
	public V mapFrom(T source);
}
