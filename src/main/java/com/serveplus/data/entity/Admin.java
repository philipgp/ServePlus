package com.serveplus.data.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	

	
	
	/*public ContactDetail getContact(ContactType contactType){
		if(customerContactDetails!=null){
			for(CustomerContactDetail customerContactDetail:customerContactDetails){
				if(customerContactDetail.getCustomerContactDetailId()!=null 
						&& customerContactDetail.getCustomerContactDetailId().getContactDetail()!=null
						&& customerContactDetail.getCustomerContactDetailId().getContactDetail().getContactType() ==contactType){
					return customerContactDetail.getCustomerContactDetailId().getContactDetail();
				}
			}
		}
		return null;
	}*/
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

	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", user=" + user + "]";
	}

	

	
	
}
