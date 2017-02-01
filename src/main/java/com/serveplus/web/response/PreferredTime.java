package com.serveplus.web.response;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PreferredTime {
	private String timeStart;
	private String timeEnd;
	private List<String> days;
	
	public void setPrefferedTime(String prefferedTime){
		String[] splitStrings = StringUtils.split(prefferedTime,"-");
		if(splitStrings!=null && splitStrings.length==2){
			setTimeStart(splitStrings[0]);
			setTimeEnd(splitStrings[1]);
		}
	}
	public void setPrefferedDays(String prefferedDays){
		String[] splitStrings = StringUtils.split(prefferedDays,",");
		if(splitStrings!=null){
			List<String> prefferedDayList = new  ArrayList<String>();
			setDays(prefferedDayList);
			for(String splitString:splitStrings){
				prefferedDayList.add(splitString);
			}
		}
	}
	@JsonIgnore
	public String getPrefferedTime(){
		if(StringUtils.isNotEmpty(timeStart))
			return timeStart+"-"+timeEnd;
		else
			return "";
	}
	@JsonIgnore
	public String getPrefferedDays(){
		StringBuilder sb = new StringBuilder();
		int index = 0;
		if(days!=null){
			for(String day:days){
				if(index!=0)
					sb.append(",");
				sb.append(day);
				index++;
			}
		}
		return sb.toString();
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public List<String> getDays() {
		return days;
	}
	public void setDays(List<String> days) {
		this.days = days;
	} 
}
