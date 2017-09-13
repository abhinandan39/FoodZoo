package com.foodzoo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.DAO.UserDAOImpl;
import com.avizva.Model.Users;
import com.avizva.service.ServiceDAO;

@Controller
public class MyController {
	
	@Autowired
	ServiceDAO serviceDao;

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
	
	@RequestMapping("/loginhere")
	public ModelAndView login(){
		return new ModelAndView("login");
	}
	@RequestMapping("/login")
	public ModelAndView logedin(HttpServletRequest request){

		boolean check = serviceDao.loginService(request);
		if(check){
			HttpSession session = request.getSession(false); 
			session.setAttribute("sessionusername", request.getParameter("username"));
			return new ModelAndView("index");
		}
		else{
			return new ModelAndView("login").addObject("errormsg", "Invalid Credentials");
		}
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("index");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(format, false));

	}
	@RequestMapping("/registeruser")
	public ModelAndView saveUser(@Valid @ModelAttribute Users user, BindingResult result){
		
		user.setEnabled(true);

		if(result.hasErrors()){
			
			return new ModelAndView("register");
		}
		
		if(serviceDao.saveService(user))
		{
			
			return new ModelAndView("index").addObject("username","user");
		}
		else {
			return new ModelAndView("register").addObject("msg","Error While Registering");
		}
	}
	@RequestMapping("/deactivate")
	public ModelAndView deactivate(){
		return new ModelAndView("deactivate");
	}
	
	@RequestMapping("/question")
	public ModelAndView deactivate1(@RequestParam("username") String username){
		return new ModelAndView("question");
		}
	@RequestMapping("/finaldeactivate")
	public ModelAndView finaldeactivate(HttpServletRequest request){
	HttpSession session = request.getSession();
	String username = (String)session.getAttribute("sessionusername");
	
	boolean check = serviceDao.deactivateService(username);
	if(check){
		session.invalidate();
//		HttpSession session = request.getSession();
//		session.invalidate();
		return new ModelAndView("index");
	}
	else{
		return new ModelAndView("deactivate").addObject("deactivateerror","Error in deactivation");
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

		serviceDao.mailService(request);

		return new ModelAndView("success");

	}

}
