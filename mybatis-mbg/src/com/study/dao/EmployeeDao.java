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
	 * 按照员工id查询员工
	 */
	public Employee getEmpById(Integer id);
	public Employee getEmpByIdAndEmpName(@Param("id")Integer id,@Param("empname")String empname);
	public Employee getEmpByIdAndEmpName2(Map<String, Object>map);
	public int deleteEmp(Integer id);
	public int insertEmp(Employee employee);
	public int insertEmp2(Employee employee);
	public int updateEmp(Employee employee);
//	查询多条记录返回list
	public List<Employee> getAllEmps();
//	查询单条记录返回map
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
//	查询多条记录返回map
//	key就是这个记录的主键，value就是这条记录封装好的对象
	@MapKey("id")
	public Map<String, Employee> getAllEmpsReturnMap();
	
}
