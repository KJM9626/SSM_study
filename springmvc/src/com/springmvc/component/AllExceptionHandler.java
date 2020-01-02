package com.springmvc.component;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AllExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception exception) {
		System.out.println("全局的异常信息是:"+exception);
		ModelAndView modelAndView = new ModelAndView("errors");
		modelAndView.addObject("errors", exception);
		return modelAndView;
	}
}
