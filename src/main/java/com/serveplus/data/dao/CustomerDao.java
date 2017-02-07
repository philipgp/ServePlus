package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Customer;



public interface CustomerDao {
	
	
	Customer findById(Long id); 
	public void save(Customer customer);
	public List<Customer> getAll();

}
