package com.study.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.study.bean.Employee;

public interface EmployeeDao {

	/**
	 * @param id
	 * @return
	 * ����Ա��id��ѯԱ��
	 */
	public Employee getEmpById(Integer id);
	public Employee getEmpByIdAndEmpName(@Param("id")Integer id,@Param("empname")String empname);
	public Employee getEmpByIdAndEmpName2(Map<String, Object>map);
	public int deleteEmp(Integer id);
	public int insertEmp(Employee employee);
	public int insertEmp2(Employee employee);
	public int updateEmp(Employee employee);
//	��ѯ������¼����list
	public List<Employee> getAllEmps();
//	��ѯ������¼����map
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
//	��ѯ������¼����map
//	key���������¼��������value����������¼��װ�õĶ���
	@MapKey("id")
	public Map<String, Employee> getAllEmpsReturnMap();
	
}
