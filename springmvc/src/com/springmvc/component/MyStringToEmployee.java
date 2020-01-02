package com.springmvc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springmvc.bean.Employee;
import com.springmvc.dao.DepartmentDao;

/**
 * @author 明
 *S:source 源类型
 *T：target  目标类型
 *将S转为T
 */
@Component
public class MyStringToEmployee implements Converter<String, Employee>{

	@Autowired
	private DepartmentDao departmentDao;
	/**
	 *自定义转换规则
	 */
	@Override
	public Employee convert(String source) {
		//如需将empinfo=empAdmin-admin@qq.com-1-101的String类型转换为Employee类型
		System.out.println("页面提交的将要转换的字符串："+source);
		Employee employee = new Employee();
		if(source.contains("-")) {
			String[] split = source.split("-");
			employee.setLastName(split[0]);
			employee.setEmail(split[1]);
			employee.setGender(Integer.valueOf(split[2]));
			employee.setDepartment(departmentDao.getDepartment(Integer.valueOf(split[3])));
		}
		return employee;
	}

	
}
