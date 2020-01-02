package com.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.demo.Book;

@Controller
public class BookController {
	@RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
	public String getBook(@PathVariable("bid")String id) {
		System.out.println("��ѯ"+id+"��ͼ��");
		return "success";
	}
	@RequestMapping(value = "/book/{bid}",method = RequestMethod.POST)
	public String addBook(@PathVariable("bid")String id) {
		System.out.println("���"+id+"��ͼ��");
		return "success";
	}
	@RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
//	@ResponseBody
	public String deleteBook(@PathVariable("bid")String id) {
		System.out.println("ɾ��"+id+"��ͼ��");
		return "success";
	}
	@RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
//	@ResponseBody
	public String updateBook(@PathVariable("bid")String id) {
		System.out.println("����"+id+"��ͼ��");
		return "success";
	}


}
