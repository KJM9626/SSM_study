package com.springmvc.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.demo.Book;

@SessionAttributes(value = "msg")
@RequestMapping("/hello")
@Controller
public class MyController {
	//锟斤拷锟斤拷拥锟角帮拷锟侥匡拷驴锟绞硷拷锟斤拷锟斤拷锟角帮拷锟侥匡拷碌锟絟ello锟斤拷锟斤拷
	@RequestMapping("/world")
	public String getPage() {
		System.out.println("锟秸碉拷指锟筋，准锟斤拷锟斤拷转页锟斤拷");
		return "success";
	}
	
	@RequestMapping("/user/{id}")
	public String pathVaribaleTest(@PathVariable("id")String id) {
		System.out.println("id : "+id);
		return "success";
	}
	
	@RequestMapping("/username")
	public String test(@RequestParam("username")String username,@RequestHeader("User-Agent")String userAgent,@CookieValue("JSESSIONID")String jid) {
		System.out.println("username: "+username);
		System.out.println(userAgent);
		System.out.println(jid);
		return "success";
	}

	@RequestMapping("/book")
	public String test1(Book book) {
		System.out.println(book);
		return "success";
	}
	

	
	@RequestMapping("/nativeapi")
	public String test2(HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		request.setAttribute("requestArgs", "锟斤拷锟斤拷锟斤拷锟叫碉拷锟斤拷息");
		session.setAttribute("sessionArgs", "锟结话锟斤拷锟叫碉拷锟斤拷息");
		return "success";
	}
	@RequestMapping("/map")
	public String mapTest(Map<String, Object>map) {
		map.put("mapParam", "锟斤拷锟斤拷map锟叫达拷锟斤拷牟锟斤拷锟�");
		System.out.println("map锟斤拷锟斤拷锟斤拷锟角ｏ拷"+map.getClass());
		return "success";
	}
	@RequestMapping("/model")
	public String modelTest(Model model) {
		model.addAttribute("modelParam", "锟斤拷锟斤拷model锟叫达拷锟斤拷牟锟斤拷锟�");
		System.out.println("model锟斤拷锟斤拷锟斤拷锟角ｏ拷"+model.getClass());
		return "success";
	}
	@RequestMapping("/modelMap")
	public String modelMapTest(ModelMap modelMap) {
		modelMap.addAttribute("modelMapParam", "锟斤拷锟斤拷modelMap锟叫达拷锟斤拷牟锟斤拷锟�");
		System.out.println("modelMap锟斤拷锟斤拷锟斤拷锟角ｏ拷"+modelMap.getClass());
		return "success";
	}
	@RequestMapping("/modelAndView")
	public ModelAndView test3() {
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("msg", "锟斤拷锟斤拷ModelAndView锟叫憋拷锟斤拷牟锟斤拷锟�");
		return modelAndView;
	}
	@RequestMapping("forward")
	public String forwardTest() {
		System.out.println("锟斤拷锟斤拷forward转锟斤拷锟斤拷锟截讹拷页锟斤拷");
		return "forward:/hello.jsp";
	}
	@RequestMapping("test")
	public String test4() {
		System.out.println("锟斤拷锟斤拷forward锟斤拷锟斤拷转锟斤拷锟斤拷指锟斤拷锟斤拷路锟斤拷");
		return "redirect:/hello/book";
	}
	@RequestMapping("/testRedirect")
	public String test5() {
		System.out.println("锟斤拷锟斤拷forward锟斤拷锟斤拷转锟斤拷锟斤拷指锟斤拷锟斤拷路锟斤拷");
		return "redirect:/hello/test";
	}
	@RequestMapping("/loginTest")
	public String test6() {
		return "login";
	}
	
	@RequestMapping("/exTest")
	public String test7(int i) {
		System.out.println(10/i);
		return "success";
	}

	
}
