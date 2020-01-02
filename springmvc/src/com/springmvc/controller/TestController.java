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
	 * 将返回的数据放在响应体中,如果是对象，jackson包自动将对象转为json格式
	 */
	@ResponseBody
	@RequestMapping("/getAllAjax")
	public Collection<Employee> getAllAjax(){
		Collection<Employee> all = employeeDao.getAll();
		return all;
	}
	
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String info) {
		System.out.println("获取到的请求体内容："+info);
		return "success";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpEntity<String>str) {
		System.out.println("获取到的内容是："+str);
		return "success";
	}

	/**
	 * @param username
	 * @param password
	 * @param file
	 * @param model
	 * @return
	 * 单文件上传
	 */
	@RequestMapping("/simpleUpload")
	public String uploadTest(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("file")MultipartFile file,Model model) {
		System.out.println("上传的文件的信息是：");
		System.out.println("文件项的名字是："+file.getName());
		System.out.println("文件的名字是："+file.getOriginalFilename());
//		文件保存
		try {
			file.transferTo(new File("F:\\谷歌浏览器\\上传测试文件\\"+file.getOriginalFilename()));
			model.addAttribute("msg", "文件上传成功");
		} catch (Exception e) {
			model.addAttribute("msg", "文件上传失败"+e.getMessage());
		} 
		
		return "forward:/testOthers.jsp";
	}
	
	/**
	 * @param username
	 * @param file
	 * @param model
	 * @return
	 * 多文件上传
	 */
	@RequestMapping("/multiUpload")
	public String testMultiUpload(@RequestParam("username")String username,@RequestParam("file")MultipartFile[] file,Model model) {
		for(MultipartFile file2:file) {
			if (!file2.isEmpty()) {
				try {
					System.out.println("文件项的名字是："+file2.getName());
					System.out.println("选中的文件的名字是："+file2.getOriginalFilename());
					file2.transferTo(new File("F:\\谷歌浏览器\\上传测试文件\\"+file2.getOriginalFilename()));
					model.addAttribute("multimsg", "多文件上传成功");
				} catch (Exception e) {
					model.addAttribute("multimsg", "多文件上传失败"+e.getMessage());
				} 
			}
		}
		return "forward:/testOthers.jsp";
	}
	
	@RequestMapping("/testHandlerInterceptor")
	public String testHandlerInterceptor() {
		System.out.println("测试拦截器");
		return "success";
	}
}
