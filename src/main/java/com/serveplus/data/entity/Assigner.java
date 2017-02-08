package com.serveplus.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ASSIGNER")
public class Assigner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "COMPANY_ID")
	private Company company;
	
	@Column(name = "ACTIVE")
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Assigner [id=" + id + ", user=" + user + ", company=" + company
				+ "]";
	}

	
	
	
}
