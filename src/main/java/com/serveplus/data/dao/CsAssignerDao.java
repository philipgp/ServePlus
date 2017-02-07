package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Service;

public interface CsAssignerDao {
	
	public List<CsAssigner> findBy(CompanyService companyService);
	public CsAssigner findBy(CompanyService companyService,Assigner assigner);
	public List<CsAssigner> findByAssigner(Assigner assigner);
	public void save(CsAssigner csAssigner);
	public void remove(CsAssigner csAssigner);
}
