package com.serveplus.data.entity;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN_SESSION")
public class LoginSession {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "LOGIN_CREDENTIAL_ID")
	private LoginCredentials loginCredentials;
	
	@Column(name = "CHANNEL")
	private String channel;
	
	@Column(name = "TOKEN")
	private String token;
	
	@Column(name = "last_login_time")
	private Date lastLoginTime;
	
	@Column(name = "last_active_time")
	private Date lastActiveTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LoginCredentials getLoginCredentials() {
		return loginCredentials;
	}

	public void setLoginCredentials(LoginCredentials loginCredentials) {
		this.loginCredentials = loginCredentials;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(Date lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	@Override
	public String toString() {
		return "LoginSession [id=" + id + ", loginCredentials="
				+ loginCredentials + ", channel=" + channel + ", token="
				+ token + ", lastLoginTime=" + lastLoginTime
				+ ", lastActiveTime=" + lastActiveTime + "]";
	}

	
	
}
