package com.springmvc.demo;


public class Book {
	private String bookName;
	private String author;
	private double price;
	private double sales;
	private String type;
	private Address address;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String bookName, String author, double price, double sales, String type, Address address) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.type = type;
		this.address = address;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + ", price=" + price + ", sales=" + sales + ", type="
				+ type + ", address=" + address + "]";
	}
	
	

}
