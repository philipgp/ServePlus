package com.serveplus.data.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.serveplus.data.dao.EntityBaseEventListener;

@Entity
@Table(name = "User")
@EntityListeners(EntityBaseEventListener.class)
public class User  extends EntityBase{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="LOGIN_CREDENTIAL_ID")
	private LoginCredentials loginCredentials;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="user")
	private Set<UserAddress> userAddresses;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="user")
	private Set<UserContact> userContactDetails = new HashSet<UserContact>(0);
	
	public UserContact getPrimaryEmail(){
		if(userContactDetails!=null){
			for(UserContact userContactDetail:userContactDetails){
				if(Boolean.TRUE.equals(userContactDetail.getActive())
						&& Boolean.TRUE.equals(userContactDetail.getIsDefault())
						&& ContactType.EMAIL == userContactDetail.getContactDetail().getContactType() ){
					return userContactDetail;
				}
			}
		}
		return null;
	}
	
	/*public Address getDefaultAddress(){
		if(userAddresses!=null){
			for(UserAddress userAddress:userAddresses){
				if(Boolean.TRUE.equals(userAddress.getIsDefault()) && userAddress.getUserAddressId()!=null){
					userAddress.getUserAddressId().getAddress();
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<UserAddress> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(Set<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public Set<UserContact> getUserContactDetails() {
		return userContactDetails;
	}

	public void setUserContactDetails(Set<UserContact> userContactDetails) {
		this.userContactDetails = userContactDetails;
	}

	public LoginCredentials getLoginCredentials() {
		return loginCredentials;
	}

	public void setLoginCredentials(LoginCredentials loginCredentials) {
		this.loginCredentials = loginCredentials;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", userAddresses="
				+ userAddresses + "]";
	}

	
	
	
}
