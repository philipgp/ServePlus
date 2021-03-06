package com.serveplus.data.entity;


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
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRST_LINE")
	private String firstLine;
	
	@Column(name = "SECOND_LINE")
	private String secondLine;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "LOCATION_ID")
	private Location location;
	
	/*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="userAddressId.address")
	private Set<UserAddress> userAddresses;

	public Set<UserAddress> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(Set<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
