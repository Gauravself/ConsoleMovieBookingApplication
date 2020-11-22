package com.birlasoft.customrportal.model;

public class LoginVO {
	private String userName;
	private String Password;

	public LoginVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginVO(String userName, String password) {
		super();
		this.userName = userName;
		Password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "LoginVO [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}



	


	

}
