package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.spring2.ioc.dao.MessageDao;
import com.spring2.ioc.demo.Message;
import com.sun.media.jfxmedia.control.VideoDataBuffer;

public class JdbcTest {

	private ApplicationContext ab = new ClassPathXmlApplicationContext("config2/applicationContext4.xml");
	JdbcTemplate jdbcBean = ab.getBean(JdbcTemplate.class);
	NamedParameterJdbcTemplate named = ab.getBean(NamedParameterJdbcTemplate.class);

	@Test
	public void test() throws SQLException {

		System.out.println(jdbcBean);
		Connection connection = jdbcBean.getDataSource().getConnection();
		System.out.println(connection);
		connection.close();
	}

	@Test
	public void test2() {
		String sql = "update message set command=? where id=?";
		int update = jdbcBean.update(sql, "我想你了", 3);
//		System.out.println("更新完成: "+update);

		// 批量插入
		String sql2 = "insert into message(command,description) values(?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] { "我买票了", "准备去坐车" });
		batchArgs.add(new Object[] { "新闻", "今天美国进攻伊拉克" });
		batchArgs.add(new Object[] { "天气", "今天晴转多云" });
		batchArgs.add(new Object[] { "新闻", "今天中国人民站起来了" });
		int[] batchUpdate = jdbcBean.batchUpdate(sql2, batchArgs);
		for (int i : batchUpdate) {
			System.out.println(i);
		}
	}

	@Test
	public void test3() {
		String sql = "select id,command,content,description from message where id=?";
//		RowMapper每一行记录和JavaBean的属性如何映射
		Message queryForObject = jdbcBean.queryForObject(sql, new BeanPropertyRowMapper<>(Message.class), 4);
		System.out.println(queryForObject);

		String sql2 = "select id,command,content,description from message where id>?";
		List<Message> query = jdbcBean.query(sql2, new BeanPropertyRowMapper<>(Message.class), 8);
		for (Message message : query) {
			System.out.println(message);
		}
	}

	@Test
	public void test4() {
		String sql = "insert into message(command,description) values(:command,:description)";

		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map1.put("command", "新闻");
		map2.put("command", "天气");
		map1.put("description", "中国举行建国70周年大阅兵");
		map2.put("description", "今天天气小雨转多云");
		int update1 = named.update(sql, map1);
		int update2 = named.update(sql, map2);
		System.out.println(update1 + "  " + update2);

	}

//	使用带有具名参数的SQL语句插入一条记录，并以Map形式传入参数值
	@Test
	public void test5() {
		String sql = "insert into message(command,description) values(:command,:description)";
		Message message = new Message();
		message.setCommand("新闻");
		message.setDescription("今天A股跌了10%");
		int update = named.update(sql, new BeanPropertySqlParameterSource(message));
		System.out.println(update);
	}
	@Test
	public void test6() {
		MessageDao bean = ab.getBean(MessageDao.class);
		Message message=new Message();
		message.setCommand("车票");
		message.setDescription("这是一张北京到广州的车票");
		int saveMessage = bean.saveMessage(message);
		System.out.println(saveMessage);
	}
}
