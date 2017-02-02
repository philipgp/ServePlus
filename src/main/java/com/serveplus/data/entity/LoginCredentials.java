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

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "LOGIN_CREDENTIALS")
public class LoginCredentials {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USERNAME")
	private String userName;

	
	@Column(name = "PASSWORD")
	private String password;
	

	
	@Column(name = "ACCOUNT_SUSPENDED")
	private Boolean accountSuspended;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="loginCredentials")
	private Set<LoginSession> loginSessions;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="password_reset")
	private Otp passwordResetOtp;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="regn_otp_id")
	private Otp regnOtpId;
	
	@Column(name = "WRONG_PASSWORD_TRY ")
	private Integer wrongPasswordTry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginCredentials [id=").append(id)
				.append(", userName=").append(userName).append(", password=")
				.append(password).append(", accountSuspended=")
				.append(accountSuspended).append(", loginSessions=")
				.append(loginSessions).append(", wrongPasswordTry=")
				.append(wrongPasswordTry).append("]");
		return builder.toString();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<LoginSession> getLoginSessions() {
		return loginSessions;
	}

	public void setLoginSessions(Set<LoginSession> loginSessions) {
		this.loginSessions = loginSessions;
	}
	public LoginSession getLoginSession(String channel){
		if(loginSessions!=null){
			for(LoginSession loginSession:loginSessions){
				if(StringUtils.equalsIgnoreCase(loginSession.getChannel(), channel)){
					return loginSession;
				}
			}
		}
		return null;
	}

	public Integer getWrongPasswordTry() {
		return wrongPasswordTry;
	}

	public void setWrongPasswordTry(Integer wrongPasswordTry) {
		this.wrongPasswordTry = wrongPasswordTry;
	}
	
	public Boolean hasWrongPasswordTries(){
		if(wrongPasswordTry>0)
			return true;
		else
			return false;
	}



	public Boolean getAccountSuspended() {
		return accountSuspended;
	}

	public void setAccountSuspended(Boolean accountSuspended) {
		this.accountSuspended = accountSuspended;
	}

	public Otp getPasswordResetOtp() {
		return passwordResetOtp;
	}

	public void setPasswordResetOtp(Otp passwordResetOtp) {
		this.passwordResetOtp = passwordResetOtp;
	}

	public Otp getRegnOtpId() {
		return regnOtpId;
	}

	public void setRegnOtpId(Otp regnOtpId) {
		this.regnOtpId = regnOtpId;
	}

	
	
	
}
