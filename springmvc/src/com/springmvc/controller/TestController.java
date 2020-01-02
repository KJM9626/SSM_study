package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.bean.Employee;
import com.springmvc.dao.EmployeeDao;

@Controller
public class TestController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	/**
	 * @return
	 * �����ص����ݷ�����Ӧ����,����Ƕ���jackson���Զ�������תΪjson��ʽ
	 */
	@ResponseBody
	@RequestMapping("/getAllAjax")
	public Collection<Employee> getAllAjax(){
		Collection<Employee> all = employeeDao.getAll();
		return all;
	}
	
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String info) {
		System.out.println("��ȡ�������������ݣ�"+info);
		return "success";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpEntity<String>str) {
		System.out.println("��ȡ���������ǣ�"+str);
		return "success";
	}

	/**
	 * @param username
	 * @param password
	 * @param file
	 * @param model
	 * @return
	 * ���ļ��ϴ�
	 */
	@RequestMapping("/simpleUpload")
	public String uploadTest(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("file")MultipartFile file,Model model) {
		System.out.println("�ϴ����ļ�����Ϣ�ǣ�");
		System.out.println("�ļ���������ǣ�"+file.getName());
		System.out.println("�ļ��������ǣ�"+file.getOriginalFilename());
//		�ļ�����
		try {
			file.transferTo(new File("F:\\�ȸ������\\�ϴ������ļ�\\"+file.getOriginalFilename()));
			model.addAttribute("msg", "�ļ��ϴ��ɹ�");
		} catch (Exception e) {
			model.addAttribute("msg", "�ļ��ϴ�ʧ��"+e.getMessage());
		} 
		
		return "forward:/testOthers.jsp";
	}
	
	/**
	 * @param username
	 * @param file
	 * @param model
	 * @return
	 * ���ļ��ϴ�
	 */
	@RequestMapping("/multiUpload")
	public String testMultiUpload(@RequestParam("username")String username,@RequestParam("file")MultipartFile[] file,Model model) {
		for(MultipartFile file2:file) {
			if (!file2.isEmpty()) {
				try {
					System.out.println("�ļ���������ǣ�"+file2.getName());
					System.out.println("ѡ�е��ļ��������ǣ�"+file2.getOriginalFilename());
					file2.transferTo(new File("F:\\�ȸ������\\�ϴ������ļ�\\"+file2.getOriginalFilename()));
					model.addAttribute("multimsg", "���ļ��ϴ��ɹ�");
				} catch (Exception e) {
					model.addAttribute("multimsg", "���ļ��ϴ�ʧ��"+e.getMessage());
				} 
			}
		}
		return "forward:/testOthers.jsp";
	}
	
	@RequestMapping("/testHandlerInterceptor")
	public String testHandlerInterceptor() {
		System.out.println("����������");
		return "success";
	}
}
