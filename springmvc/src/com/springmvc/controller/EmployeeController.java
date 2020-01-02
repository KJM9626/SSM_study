package com.springmvc.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.bean.Department;
import com.springmvc.bean.Employee;
import com.springmvc.dao.DepartmentDao;
import com.springmvc.dao.EmployeeDao;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao; 
	@Autowired
	private DepartmentDao departmentDao;
	//��ѯ����Ա��
	@RequestMapping("/emps")
	public String getEmps(Model model) {
		Collection<Employee> all = employeeDao.getAll();
		model.addAttribute("emps", all);
		return "list";
	}
	//����ҳ��
	/**
	 * @param employee
	 * @param result
	 * @return
	 * �������У�鹦���Լ���������תҳ��
	 */
	@RequestMapping(value = "emp",method = RequestMethod.POST)
	public String addEmp(@Valid Employee employee,BindingResult result,Model model) {
		System.out.println("Ҫ��ӵ�Ա����"+employee);
		boolean hasErrors = result.hasErrors();
		Map<String, Object> errorMap=new HashMap<String, Object>();
		if(hasErrors) {
			System.out.println("�Բ���������������д���");
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError error:errors) {
				System.out.println("�������Ϣ�ǣ�"+error.getDefaultMessage());
				System.out.println("������ֶ��ǣ�"+error.getField());
				System.out.println(error);
				System.out.println("============");
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			Collection<Department> departments = departmentDao.getDepartments();
			model.addAttribute("deps", departments);
			model.addAttribute("errorInfo", errorMap);
			return "addEmps";
		}else {
			employeeDao.save(employee);
			return "redirect:/emps";
		}
		
	}
	/**
	 * @param model
	 * @return
	 * ���Ա��
	 */
	@RequestMapping("/toAddPage")
	public String addEmps(Model model) {
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("deps", departments);
		model.addAttribute("employee", new Employee());
		return "addEmps";
	}
	/**
	 * @param id
	 * @param model
	 * @return
	 * ��ȡԱ����Ϣ
	 */
	@RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
	public String getEmp(@PathVariable("id")Integer id,Model model) {
		Employee employee = employeeDao.getId(id);
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("employee", employee);
		model.addAttribute("depts", departments);
		return "edit";
	}
	
	/**
	 * @param employee
	 * @return
	 * �޸�Ա��
	 */
	@RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
	public String updateEmps(@ModelAttribute("employee")Employee employee) {
		System.out.println("Ҫ�޸ĵ�Ա����"+employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	/**
	 * @param id
	 * @param model
	 * ��edit֮ǰ�õ�Ҫ�޸�Ա����id
	 */
	@ModelAttribute
	public void myModelAttribute(@RequestParam(value = "id",required = false)Integer id,Model model) {
		if(id!=null) {
			Employee employee = employeeDao.getId(id);
			model.addAttribute("employee", employee);
		}
		System.out.println("haha");
	}
	@RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
	public String deleteEmps(@PathVariable("id")Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	/**
	 * @param employee
	 * @return
	 * дһ���Զ�������ת������empinfo=empAdmin-admin@qq.com-1-101��String����ת��ΪEmployee����
	 */
	@RequestMapping("/quickAdd")
	public String quickAdd(@RequestParam("empinfo")Employee employee) {
		System.out.println("��װ��employee��"+employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}

}
