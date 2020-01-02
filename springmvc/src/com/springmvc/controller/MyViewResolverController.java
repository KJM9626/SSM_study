package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyViewResolverController {
	
	@RequestMapping("/handle")
	public String handle(Model model) {
		List<String> vName=new ArrayList<>();
		List<String> iName=new ArrayList<>();
		vName.add("无间道");
		vName.add("小猪佩奇");
		iName.add("天梯");
		iName.add("当你老了");
		model.addAttribute("vName", vName);
		model.addAttribute("iName", iName);
		return "meinv:/gaoqing";
	}

}
