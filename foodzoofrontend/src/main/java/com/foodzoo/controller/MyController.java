package com.foodzoo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.DAO.UserDAOImpl;
import com.avizva.Model.Users;

@Controller
public class MyController {

	@Autowired
	UserDAOImpl userDAOImpl;
	
	@Autowired
	SendEmail mail;
	
	@RequestMapping("/")
	public ModelAndView indexcall() {

		return new ModelAndView("index");

	}

	@RequestMapping("/home")
	public ModelAndView getHome(){
		return new ModelAndView("index");
	}
	@RequestMapping("/signup")
	public ModelAndView getRgistration(){
		return new ModelAndView("register");
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(format, false));

	}
	@RequestMapping("/registeruser")
	public ModelAndView saveUser(@Valid @ModelAttribute Users user, BindingResult result){

		if(result.hasErrors()){
			return new ModelAndView("register");
		}
		else if(userDAOImpl.saveUser(user))
		{
			
			String from = "FoodZoo";
//			System.out.println(email);
//			System.out.println(password);
//			String to = email;
			String subject = "Welcome To FoodZoo";
//			String msg = "We are glad to have you on Board. Your login credentials are: "+email+" Password: "+password;
			System.out.println("inside controller");
		//	ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		//	SendEmail m = (SendEmail) context.getBean("sendEmail");
		//	mail.sendMail(from, to, subject, msg);
			return new ModelAndView("index").addObject("username","user");
		}
		else {
			return new ModelAndView("register").addObject("msg","Error While Registering");
		}
	}
	
	@RequestMapping("/aboutus")
	public ModelAndView Aboutuscall() {

		return new ModelAndView("aboutus1");

	}

	@RequestMapping("/contact")
	public ModelAndView Contactuscall() {

	
		return new ModelAndView("contact");

	}

	@RequestMapping("/contact1")
	public ModelAndView send(HttpServletRequest request) {

		String from = request.getParameter("from");
		String to = "abhinandangupta39@gmail.com";
		String subject = request.getParameter("subject");
		String msg = request.getParameter("message");
		System.out.println("inside controller");
//		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//		SendEmail m = (SendEmail) context.getBean("sendEmail");

		mail.sendMail(from, to, subject, msg);
		System.out.println("after sendmail");
		return new ModelAndView("success");

	}

}
