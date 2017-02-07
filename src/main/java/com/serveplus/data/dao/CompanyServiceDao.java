package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Service;

public interface CompanyServiceDao {
	
	public CompanyService findBy(Company company,Service service);
	public void save(CompanyService companyService);
	public void remove(CompanyService companyService);
}
