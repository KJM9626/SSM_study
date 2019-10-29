package com.spring1.demo;

public class User {
	private String usreName;
	private Integer age;
	private String gender;
	public String getUsreName() {
		return usreName;
	}
	public void setUsreName(String usreName) {
		this.usreName = usreName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [usreName=" + usreName + ", age=" + age + ", gender=" + gender + "]";
	}
	

}
