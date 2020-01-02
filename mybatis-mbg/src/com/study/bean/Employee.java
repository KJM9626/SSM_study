package com.study.bean;

public class Employee {

	private Integer id;
	private String empname;
	private Integer gender;
	private String email;
	private String loginAccount;
	public Employee() {
		super();
		
	}
	
	public Employee(String empname, Integer gender, String email) {
		super();
		this.empname = empname;
		this.gender = gender;
		this.email = email;
	}

	public Employee(Integer id, String empname, Integer gender, String email) {
		super();
		this.id = id;
		this.empname = empname;
		this.gender = gender;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", gender=" + gender + ", email=" + email
				+ ", loginAccount=" + loginAccount + "]";
	}
	
	
}
