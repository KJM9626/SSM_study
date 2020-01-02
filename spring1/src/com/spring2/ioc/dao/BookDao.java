package com.spring2.ioc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @param userName
	 * @param price
	 * 减去某个用户的余额
	 */
	public void updateBalance(String userName,int price) {
		String sql="update account set balance=balance-? where userName=?";
		jdbcTemplate.update(sql, price,userName);
	}
	/**
	 * @param isbn
	 * @return
	 * 按照图书的ISBN返回图书价格
	 */
	public int getPrice(String isbn) {
		String sql="select price from book where isbn=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		
	}
	
	public void updateStock(String isbn) {
		String sql="update book_stock set stock=stock-1 where isbn=?";
		jdbcTemplate.update(sql, isbn);
	}
	
	public void updatePrice(String isbn,int price) {
		String sql="update book set price=? where isbn=?";
		jdbcTemplate.update(sql, price,isbn);
	}

}
