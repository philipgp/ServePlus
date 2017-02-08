package com.serveplus.vo;

public class UserRoleVO {
	UserRole userRole;
	private Long id;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRoleVO [userRole=").append(userRole)
				.append(", id=").append(id).append("]");
		return builder.toString();
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
