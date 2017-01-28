package com.serveplus.web.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.serveplus.DateFormats;

public class ServiceRequestVO {
	private String regnId,location,localAddress,image;
	private String userName,fullName,phoneNo,dept,type,typeId,preferedTime,comment;
	private String status;
	@JsonFormat(pattern = DateFormats.yyyyMMddHHmmss)
	private Date date;
	private Float latitude,longitude,payment;
	
	
	public String getRegnId() {
		return regnId;
	}
	public void setRegnId(String regnId) {
		this.regnId = regnId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	public String getPreferedTime() {
		return preferedTime;
	}
	public void setPreferedTime(String preferedTime) {
		this.preferedTime = preferedTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	
	@Override
	public String toString() {
		return "WorkVO [regnId=" + regnId + ", location=" + location
				+ ", localAddress=" + localAddress + ", image=" + image
				+ ", userName=" + userName + ", fullName=" + fullName
				+ ", phoneNo=" + phoneNo + ", dept=" + dept + ", type=" + type
				+ ", typeId=" + typeId + ", preferedTime=" + preferedTime
				+ ", comment=" + comment + ", status=" + status + ", date="
				+ date + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", payment=" + payment + "]";
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getPayment() {
		return payment;
	}
	public void setPayment(Float payment) {
		this.payment = payment;
	}
}
