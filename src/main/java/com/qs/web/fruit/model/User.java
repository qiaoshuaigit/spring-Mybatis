package com.qs.web.fruit.model;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -239497834337193791L;

	private Integer id;	
	
	private String loginName;
	
	private String userName;
	
	private String password;
	
	private String telephone;

	public User(){}

	public User(String telephone, String userName) {
		this.telephone = telephone;
		this.userName = userName;
	}

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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", loginName='" + loginName + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", telephone='" + telephone + '\'' +
				'}';
	}
}
