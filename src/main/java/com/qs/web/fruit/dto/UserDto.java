package com.qs.web.fruit.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -239497834337193791L;
	
	private Integer id;
	
	private String loginName;
	
	private String userName;
	
	private String password;
	
	private String telephone;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
