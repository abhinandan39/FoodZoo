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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.Model.Users;
import com.avizva.service.ServiceDAO;

@Controller
public class MyController {
	
	@Autowired
	ServiceDAO serviceDao;

	@RequestMapping("/")
	public ModelAndView indexcall() {
		
		return new ModelAndView("index").addObject("homeactive","active");
	}

	@RequestMapping("/home")
	public ModelAndView getHome(){
		return new ModelAndView("index").addObject("homeactive","active");
	}
	@RequestMapping("/signup")
	public ModelAndView getRgistration(){
		return new ModelAndView("register").addObject("registeractive","active");
	}
	
	@RequestMapping("/registeruser")
	public ModelAndView saveUser(@Valid @ModelAttribute Users user, 
			BindingResult result, HttpServletRequest request){
		
		user.setEnabled(true);

		if(result.hasErrors()){
			
			return new ModelAndView("register").addObject("registeractive","active");
		}
		
		if(serviceDao.saveService(user))
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionusername",user.getUsername());
			return new ModelAndView("redirect:/","userregister","Your registration was Successfull");
		}
		else {
			return new ModelAndView("register")
					.addObject("msg","Error While Registering")
					.addObject("registeractive","active");
		}
	}
	

	@RequestMapping("/loginhere")
	public ModelAndView login(){
		return new ModelAndView("login").addObject("loginactive","active");
	}
	@RequestMapping("/login")
	public ModelAndView logedin(HttpServletRequest request){

		boolean check = serviceDao.loginService(request);
		if(check){
			HttpSession session = request.getSession(false); 
			session.setAttribute("sessionusername", request.getParameter("username"));
			return new ModelAndView("redirect:/");
		}
		else{
			return new ModelAndView("login")
					.addObject("errormsg", "Invalid Credentials")
					.addObject("loginactive","active");
		}
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(format, false));

	}
	
	/**
	 * 
	 * This method will fetch the User Object from databas and populate it to the Update Page
	 * Where the fileds will be auto filled
	 * 
	 * 
	 */
	 @RequestMapping("/update")
	public ModelAndView getUpdate(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("sessionusername");
		Users user = serviceDao.viewUserService(username);
		System.out.println("Inside profile "+user);
		return new ModelAndView("updatepage","command",user);
	}
	 
	 /**
	  * User details are fetched and then the user is updated in the database
	  * 
	  * @param user
	  * @return
	  */
	 @RequestMapping("/updateuser")
		    public ModelAndView updateUser(@ModelAttribute Users user){
		 System.out.println("Inside controller: "+user);
			boolean check = serviceDao.updateService(user);
			if(check)
				{
					return new ModelAndView("redirect:/","userupdated","Your details have been updated");
				}
			else{
				return new ModelAndView("redirect:/","error","Some erroe");
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
		return new ModelAndView("redirect:/","userdeactivated","Your deactivation request was successfull");
	}
	else{
		return new ModelAndView("deactivate").addObject("deactivateerror","Error in deactivation");
	}
	}
	
	@RequestMapping("/aboutus")
	public ModelAndView Aboutuscall() {

		return new ModelAndView("aboutus1").addObject("aboutusactive","active");

	}

	@RequestMapping("/contact")
	public ModelAndView Contactuscall() {

	
		return new ModelAndView("contact").addObject("contactactive","active");

	}

	@RequestMapping("/contact1")
	public ModelAndView send(HttpServletRequest request) {

		serviceDao.mailService(request);

		return new ModelAndView("success");

	}
	
	@RequestMapping("/forgot")
	public ModelAndView fotgot(){
		return new ModelAndView("forgetpassword");
	}
	
	@RequestMapping("/forgetpassword")
	public ModelAndView Forgetpasswordcall(@RequestParam("username") String username )
    {
		System.out.println("Username: "+username);
        String question = serviceDao.questionService(username);
		return new ModelAndView("forgetpassword1").addObject("securityque",question);

	}
	
	@RequestMapping("/forgetvalid")
	public ModelAndView Forgetvalidcall(@RequestParam("securityans") String securityans,@RequestParam("username") String username,@RequestParam("password") String password )
    {
		
		System.out.println("username"+ username +"Ans "+securityans);
		
        if(serviceDao.answerService(securityans, username))
        {
        	if(serviceDao.passwordService(username, password))
        	{
        	  
              return	new ModelAndView("login").addObject("passwordreset", "Password reset successful");
        	}
        }
        
        	return new ModelAndView("forgetpassword1").addObject("msg", "Please Enter Correct Answer!");
        

	}
	
	
	/**
	 * 
	 * This method redirects the click of profile from a page to Profile Page with user details
	 * 
	 * @param request Takes the HttpSession from this request parameter to fetch username
	 * 
	 */
	@RequestMapping("/profile")
	public ModelAndView getprofile(HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("sessionusername");
		Users user = serviceDao.viewUserService(username);
		Date d = user.getDob();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(d);
		return new ModelAndView("profilepage").addObject("user",user).addObject("date",date);
	} 


	

}
