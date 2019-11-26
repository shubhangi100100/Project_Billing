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
	
	
	@ExceptionHandler(java.lang.IndexOutOfBoundsException.class)
	public ModelAndView error500Handler(HttpServletRequest request, Exception e) {
		ModelAndView mv= new ModelAndView("AdminPage");
		mv.addObject("text1", "it seems you havent configured a role this project");
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView errorHandler(HttpServletRequest request, Exception e) {
		ModelAndView mv= new ModelAndView("HomePage");
		mv.addObject("text2", "some unknown error occurred");
		return mv;
		
	}
}
