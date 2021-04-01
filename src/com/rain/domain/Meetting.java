package com.rain.domain;

import java.io.Serializable;

public class Meetting implements Serializable{

	private Integer id;
	private String user_id;
	private String meetting_name;
	private String start_time;
	private String end_time;
	private String meetting_address;
	private String createdate;
	private String username;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMeetting_name() {
		return meetting_name;
	}
	public void setMeetting_name(String meetting_name) {
		this.meetting_name = meetting_name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getMeetting_address() {
		return meetting_address;
	}
	public void setMeetting_address(String meetting_address) {
		this.meetting_address = meetting_address;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
}
