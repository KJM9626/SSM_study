package com.springmvc.demo;

public class School {

	private String sname;
	private String address;
	public School() {
		// TODO Auto-generated constructor stub
	}
	public School(String sname, String address) {
		super();
		this.sname = sname;
		this.address = address;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
