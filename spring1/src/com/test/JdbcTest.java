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
		int update = jdbcBean.update(sql, "��������", 3);
//		System.out.println("�������: "+update);

		// ��������
		String sql2 = "insert into message(command,description) values(?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] { "����Ʊ��", "׼��ȥ����" });
		batchArgs.add(new Object[] { "����", "������������������" });
		batchArgs.add(new Object[] { "����", "������ת����" });
		batchArgs.add(new Object[] { "����", "�����й�����վ������" });
		int[] batchUpdate = jdbcBean.batchUpdate(sql2, batchArgs);
		for (int i : batchUpdate) {
			System.out.println(i);
		}
	}

	@Test
	public void test3() {
		String sql = "select id,command,content,description from message where id=?";
//		RowMapperÿһ�м�¼��JavaBean���������ӳ��
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
		map1.put("command", "����");
		map2.put("command", "����");
		map1.put("description", "�й����н���70������ı�");
		map2.put("description", "��������С��ת����");
		int update1 = named.update(sql, map1);
		int update2 = named.update(sql, map2);
		System.out.println(update1 + "  " + update2);

	}

//	ʹ�ô��о���������SQL������һ����¼������Map��ʽ�������ֵ
	@Test
	public void test5() {
		String sql = "insert into message(command,description) values(:command,:description)";
		Message message = new Message();
		message.setCommand("����");
		message.setDescription("����A�ɵ���10%");
		int update = named.update(sql, new BeanPropertySqlParameterSource(message));
		System.out.println(update);
	}
	@Test
	public void test6() {
		MessageDao bean = ab.getBean(MessageDao.class);
		Message message=new Message();
		message.setCommand("��Ʊ");
		message.setDescription("����һ�ű��������ݵĳ�Ʊ");
		int saveMessage = bean.saveMessage(message);
		System.out.println(saveMessage);
	}
}
