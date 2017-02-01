package com.serveplus.web.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.serveplus.DateFormats;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;

public class ServiceRequestVO {
	private String regnId,image;
	private String userName,dept,type,typeId;
	private String firstName,middleName,lastName,title;
	private String status;
	@JsonFormat(pattern = DateFormats.yyyyMMddHHmmss)
	private Date date;
	private String request;
	private Float payment;
	private PreferredTime preferredTime;
	private AddressVO address;
	private LocationVO location;
	private List<ContactVO> contactInfos; 
	public String getRegnId() {
		return regnId;
	}
	public void setRegnId(String regnId) {
		this.regnId = regnId;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	
	
	
	public AddressVO getAddress() {
		return address;
	}
	public void setAddress(AddressVO address) {
		this.address = address;
	}
	public PreferredTime getPreferredTime() {
		return preferredTime;
	}
	public void setPreferredTime(PreferredTime preferredTime) {
		this.preferredTime = preferredTime;
	}
	public LocationVO getLocation() {
		return location;
	}
	public void setLocation(LocationVO location) {
		this.location = location;
	}
	
	public Float getPayment() {
		return payment;
	}
	public void setPayment(Float payment) {
		this.payment = payment;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<ContactVO> getContactInfos() {
		return contactInfos;
	}
	public void setContactInfos(List<ContactVO> contactInfos) {
		this.contactInfos = contactInfos;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceRequestVO [regnId=").append(regnId)
				.append(", image=").append(image).append(", userName=")
				.append(userName).append(", dept=").append(dept)
				.append(", type=").append(type).append(", typeId=")
				.append(typeId).append(", firstName=").append(firstName)
				.append(", middleName=").append(middleName)
				.append(", lastName=").append(lastName).append(", title=")
				.append(title).append(", status=").append(status)
				.append(", date=").append(date).append(", request=")
				.append(request).append(", payment=").append(payment)
				.append(", preferredTime=").append(preferredTime)
				.append(", address=").append(address).append(", location=")
				.append(location).append(", contactInfos=")
				.append(contactInfos).append("]");
		return builder.toString();
	}
}
