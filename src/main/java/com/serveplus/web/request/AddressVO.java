package com.serveplus.web.request;

import com.serveplus.web.response.LocationVO;

public class AddressVO {
	private String firstLine,secondLine;
	private Boolean primary,active;
	private LocationVO location;
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public LocationVO getLocation() {
		return location;
	}

	public void setLocation(LocationVO location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressVO [firstLine=").append(firstLine)
				.append(", secondLine=").append(secondLine)
				.append(", primary=").append(primary).append(", active=")
				.append(active).append(", location=").append(location)
				.append("]");
		return builder.toString();
	}
	
}
