package com.spring1.demo;

public class AirPlane {

	private String engine;//������
	private String airCaptain;//����
	private String co_pilot;//������
	private String wingLength;//������
	private Integer capacity;//�ؿ�����
	
	public AirPlane() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getAirCaptain() {
		return airCaptain;
	}
	public void setAirCaptain(String airCaptain) {
		this.airCaptain = airCaptain;
	}
	public String getCo_pilot() {
		return co_pilot;
	}
	public void setCo_pilot(String co_pilot) {
		this.co_pilot = co_pilot;
	}
	public String getWingLength() {
		return wingLength;
	}
	public void setWingLength(String wingLength) {
		this.wingLength = wingLength;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "AirPlane [engine=" + engine + ", airCaptain=" + airCaptain + ", co_pilot=" + co_pilot + ", wingLength="
				+ wingLength + ", capacity=" + capacity + "]";
	}
	
	
}
