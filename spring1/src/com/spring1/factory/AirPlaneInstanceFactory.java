package com.spring1.factory;

import com.spring1.demo.AirPlane;

public class AirPlaneInstanceFactory {

	public AirPlane getAirPlane(String airCaptain) {
		System.out.println("实例工厂运行");
		AirPlane airPlane=new AirPlane();
		airPlane.setAirCaptain(airCaptain);
		airPlane.setCapacity(145);
		airPlane.setCo_pilot("lisi");
		airPlane.setEngine("good发动机");
		airPlane.setWingLength("15.12m");
		return airPlane;
	}
}
