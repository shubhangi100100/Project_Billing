package com.bms.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalController {
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView error405Handler(HttpServletRequest request, Exception e) {
		ModelAndView mv= new ModelAndView("Login");
		mv.addObject("text", "you tried to access an invalid session");
		return mv;
		
	}
	
	

}
