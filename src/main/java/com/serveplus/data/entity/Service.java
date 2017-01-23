package com.serveplus.data.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE")
public class Service {
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "COMPANY_SERVICE",  joinColumns = {
			@JoinColumn(name = "SERVICE_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "COMPANY_ID",
					nullable = false, updatable = false) })
	private Set<Company> companies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", category="
				+ category + "]";
	}
	
	
}
