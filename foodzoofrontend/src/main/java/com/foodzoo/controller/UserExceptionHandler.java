package com.foodzoo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class UserExceptionHandler {
	
	
	@ExceptionHandler(value=NoClassDefFoundError.class)
	public ModelAndView classDefException(NoClassDefFoundError e){
		System.out.println(""+e);
		return new ModelAndView("exceptionpage","exception","Some error occured. Contact Us please");
	}

	
	@ExceptionHandler(value=FileNotFoundException.class)
	public ModelAndView fileException(FileNotFoundException e){
		System.out.println(""+e);
		return new ModelAndView("exceptionpage","exception","Some error occured. Contact Us please");
	}

	
	@ExceptionHandler(value=NullPointerException.class)
	public ModelAndView nullException(NullPointerException e){
		System.out.println(""+e);
		return new ModelAndView("exceptionpage","exception","Some error occured. Contact Us please");
	}

	@ExceptionHandler(value=SQLException.class)
	public ModelAndView sqlException(SQLException e){
		System.out.println(""+e);
		return new ModelAndView("exceptionpage","exception","Some error occured. Contact Us please");
	}

	@ExceptionHandler(value=IOException.class)
	public ModelAndView ioException(IOException e){
		System.out.println(""+e);
		return new ModelAndView("exceptionpage","exception","Some error occured. Contact Us please");
	}
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView dateException(Exception e){
		System.out.println(""+e);
		return new ModelAndView("exceptionpage","exception","Some error occured. Contact Us please");
	}

	

}
