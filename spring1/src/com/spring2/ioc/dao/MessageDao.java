package com.spring2.ioc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring2.ioc.demo.Message;

@Repository
public class MessageDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int saveMessage(Message message) {
		String sql2 = "insert into message(command,description) values(?,?)";
		int update = jdbcTemplate.update(sql2, message.getCommand(),message.getDescription());
		return update;
	}

}
