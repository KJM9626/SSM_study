package com.springmvc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springmvc.bean.Employee;
import com.springmvc.dao.DepartmentDao;

/**
 * @author ��
 *S:source Դ����
 *T��target  Ŀ������
 *��SתΪT
 */
@Component
public class MyStringToEmployee implements Converter<String, Employee>{

	@Autowired
	private DepartmentDao departmentDao;
	/**
	 *�Զ���ת������
	 */
	@Override
	public Employee convert(String source) {
		//���轫empinfo=empAdmin-admin@qq.com-1-101��String����ת��ΪEmployee����
		System.out.println("ҳ���ύ�Ľ�Ҫת�����ַ�����"+source);
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
