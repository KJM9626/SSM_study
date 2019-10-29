package com.spring1.demo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private String name;
	private String email;
	private String gender;
	private Integer age;
	private Car car;
	private List<Book>books;
	private Map<String, Object>map;
	private Properties properties;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("person创建");
	}
	public Person(Car car) {
		System.out.println("Person中的car已经创建");
		this.car=car;
	}

	public Person(String name, String email, String gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	
	public Person(String name, Integer age, String gender) {
		this.name = name;
		this.age=age;
		this.gender = gender;
	}
	public Person(String name, String email, String gender, Integer age) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", gender=" + gender + ", age=" + age + ", car=" + car
				+ ", books=" + books + ", map=" + map + ", properties=" + properties + "]";
	}

}
