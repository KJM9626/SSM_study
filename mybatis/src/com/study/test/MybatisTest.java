package com.study.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.study.bean.Employee;
import com.study.bean.Key;
import com.study.bean.Lock;
import com.study.bean.Teacher;
import com.study.dao.EmployeeDao;
import com.study.dao.KeyDao;
import com.study.dao.LockDao;
import com.study.dao.TeacherDao;

public class MybatisTest {
	private SqlSessionFactory factory;

	@Before
	public void init() throws IOException {
//		根据全局配置文件创建出一个SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(is);

	}

	@Test
	public void test1() {
//		init();
//		获取和数据库的一次会话;true代表自动提交
		SqlSession session = factory.openSession(true);
		Employee employee = null;
		try {
//			使用SqlSession操作数据库，获取到dao接口的实现
			EmployeeDao mapper = session.getMapper(EmployeeDao.class);
			int insertEmp = mapper.insertEmp(new Employee("李四", 0, "632774@123.com"));
			System.out.println(insertEmp);
			employee = mapper.getEmpById(1);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test2() {
		SqlSession openSession = factory.openSession(true);
		EmployeeDao dao = openSession.getMapper(EmployeeDao.class);
		Employee employee = new Employee("Jack", 0, "632774@123.com");
		dao.insertEmp(employee);
//		dao.updateEmp(new Employee(13, "王五", 1, "23244@qq.com"));
		System.out.println("刚才插入的id：" + employee.getId());
		System.out.println(dao.getEmpById(11));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("empname", "admin");
		map.put("tableName", "new_table");
		System.out.println(dao.getEmpByIdAndEmpName2(map));
	}

	@Test
	public void test3() {
		SqlSession session = factory.openSession();
		try {
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
//			List<Employee> emps = dao.getAllEmps();
//			for(Employee emp:emps) {
//				System.out.println(emp);
//			}
			Map<String, Object> empByIdReturnMap = dao.getEmpByIdReturnMap(26);
			System.out.println(empByIdReturnMap);

			Map<String, Employee> allEmpsReturnMap = dao.getAllEmpsReturnMap();
			System.out.println(allEmpsReturnMap);
		} finally {
			session.close();
		}

	}

	@Test
	public void test4() {
		SqlSession session = factory.openSession(true);
		try {
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			Employee employee = dao.getEmpByIdAndEmpName(1, "admin");
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test5() {
		SqlSession session = factory.openSession(true);
		try {
			KeyDao mapper = session.getMapper(KeyDao.class);
//			Key key = mapper.getKeyById(2);
			Key keyByIdSimple = mapper.getKeyByIdSimple(1);
			System.out.println(keyByIdSimple.getKeyName());
		} finally {
			session.close();
		}
	}

	@Test
	public void test6() {
		SqlSession openSession = factory.openSession(true);
		try {
			LockDao dao = openSession.getMapper(LockDao.class);
//			Lock lock = dao.getLockById(3);
			Lock lock = dao.getLockByStep(3);
			List<Key> keys = lock.getKeys();
			for (Key key : keys) {
				System.out.println(key);
			}
//			System.out.println(lock);
		} finally {
			openSession.close();
		}
	}

	@Test
	public void test7() {
		SqlSession sqlSession = factory.openSession(true);
		try {
			TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
			Teacher tea = mapper.getTeacherById(2);
			System.out.println("include包含语句的查询结果：" + tea);
			Teacher teacher = new Teacher();
			teacher.setId(2);
			teacher.setTeacher("王五");
//			teacher.setDate(new Date());
//			List<Teacher> list = mapper.getTeacherByCondition(teacher);
			List<Teacher> list = mapper.getTeacherByConditionChoose(teacher);
//			List<Integer> ids=new ArrayList<Integer>();
//			ids.add(1);
//			ids.add(2);
//			List<Teacher> teachers = mapper.getTeachers(ids);
//			List<Teacher> teachers = mapper.getTeachers(Arrays.asList(1,2,3));
			int updateTeacher = mapper.updateTeacher(teacher);
			System.out.println(list);
			System.out.println(updateTeacher);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 一级缓存测试
	 */
	@Test
	public void test8() {
		SqlSession session = factory.openSession(true);
		try {
			TeacherDao dao = session.getMapper(TeacherDao.class);
			Teacher teacher = dao.getTeacherById(2);
			System.out.println(teacher);
			System.out.println("======");
//			session.clearCache();//手动清空缓存
			Teacher teacher2 = dao.getTeacherById(2);
			System.out.println(teacher2);
		} finally {
			session.close();
		}
	}

	@Test
	public void test9() {
		SqlSession sqlSession = factory.openSession(true);
		SqlSession sqlSession2 = factory.openSession(true);
		TeacherDao dao1 = sqlSession.getMapper(TeacherDao.class);
		TeacherDao dao2 = sqlSession2.getMapper(TeacherDao.class);
		Teacher teacher1 = dao1.getTeacherById(1);
		System.out.println(teacher1);
		sqlSession.close();

		Teacher teacher2 = dao2.getTeacherById(1);
		System.out.println(teacher2);
		sqlSession2.close();

	}
	
	/**
	 * 分页查询测试
	 */
	@Test
	public void test10() {
		SqlSession openSession = factory.openSession(true);
		TeacherDao mapper = openSession.getMapper(TeacherDao.class);
		List<Teacher> teachers=new ArrayList<>();
		for(int i=0;i<500;i++) {
			Teacher teacher=new Teacher();
			teacher.setTeacher(UUID.randomUUID().toString().substring(0, 5));
			teacher.setCourse(UUID.randomUUID().toString().substring(0, 4));
			teachers.add(teacher);
		}
		mapper.insertBatch(teachers);
		System.out.println("批量插入完成");
		openSession.close();
	}
}
