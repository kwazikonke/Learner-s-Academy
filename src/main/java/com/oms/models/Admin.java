package com.oms.models;

public class Admin {

	private int adminId;
	private String userName;
	private String email;
	private int password;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String userName, String email, int password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ",  email=" + email
				+ ", password=" + password + "]";
	}
	
}