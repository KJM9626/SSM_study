package com.spring1.demo;

public class Book {
	private String bookName;
	private double price;
	private String author;
	
	public void myInit() {
		System.out.println("������������");
	}
	public void myDestroy() {
		System.out.println("�������ٶ���");
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("book����");
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", price=" + price + ", author=" + author + "]";
	}
	

}
