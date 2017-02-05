package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.User;

public interface CompanyDao {
	
	List<Company> getAllCompanies();
	
	public Company findById(Long id);
	
	public void save(Company company);
}
