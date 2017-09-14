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
	/**
	 * for creating object of ServiceDAO using annotation 
	 */
	@Autowired
	ServiceDAO serviceDao;

	/**
	 * requestmapping annotation maps the user request to particular action 
	 *"/" redirects the user to the index page
	 *returns the object of ModelAndView that passes the jsp page as parameter and redirects to that page
	 *with addObject passes the data in key value pair in a way that active value is passed to the key homeactive
	 * @return ModelAndView object with index page and key value pair data through addObject
	 */
	@RequestMapping("/")
	public ModelAndView indexcall() {

		return new ModelAndView("index").addObject("homeactive","active");
	}

	/**
	 * when the home action is done it redirects user to index page with data in key value pair
	 * 
	 * @return ModelAndView object with jsp page and data in key value pair that will make the home active
	 */
	@RequestMapping("/home")
	public ModelAndView getHome(){
		return new ModelAndView("index").addObject("homeactive","active");
	}
	/**
	 * when signup action is performed then it redirects to register page
	 * @return ModelAndView object with register page and making the register active
	 */
	@RequestMapping("/signup")
	public ModelAndView getRgistration(){
		return new ModelAndView("register").addObject("registeractive","active");
	}
	
	/**
	 * when loginhere action is performed then it redirects to the login page and makes the login button active
	 * @return ModelAndView object with login page and making login button active
	 */
	@RequestMapping("/loginhere")
	public ModelAndView login(){
		return new ModelAndView("login").addObject("loginactive","active");
	}
	
	/**
	 * when login action is performed then it calls the service's loginService method with the request paramter
	 * if it returns true then user is logged in successfully and its session is maintained
	 * else
	 * it redirects to login page with an error message
	 * @param request
	 * @return ModelAndView object with data according to the condition whether true or false
	 */
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
	
	/**
	 * when logout action is performed then it redirects to index page
	 * and session is invalidated
	 * @param request
	 * @return ModelAndView object with index page
	 */
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
	 * whnen register user action is performed and the result have errors then it redirects to register page making register active
	 * and if there are no errors in the result then service's saveService method is called and is redirected to index page
	 * session is maintained that is used to send a confirmation mail to that user
	 * else
	 * returns to registe page with an error message
	 * @param user
	 * @param result
	 * @param request
	 * @return ModelAndView object with corresponding page according to the condition
	 */
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
			return new ModelAndView("redirect:/");
		}
		else {
			return new ModelAndView("register")
					.addObject("msg","Error While Registering")
					.addObject("registeractive","active");
		}
	}
	/**
	 * when deavtivate action is performed it redirects the user to deactivate page
	 * 
	 * @return ModelAndView object with deactivate page
	 */
	@RequestMapping("/deactivate")
	public ModelAndView deactivate(){
		return new ModelAndView("deactivate");
	}
	/**
	 * when question action is performed the redirects the user to question page
	 * @param username
	 * @return ModelAndView with question page
	 */
	@RequestMapping("/question")
	public ModelAndView deactivate1(@RequestParam("username") String username){
		return new ModelAndView("question");
		}
	/**
	 * when finaldeactivate action is performed calls the service's deactivate service method which returns true or false
	 * if true then the session is invalidated and the user enabled is set to false
	 * and returns to index page
	 * else returns to deactivate page with an error message
	 * @param request
	 * @return ModelAndView object with corresponding page according to the condition
	 */
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
	
	/**
	 * when aboutus action is performed the it redirects user to aboutus1 page
	 * @return ModelAndView object with about us page and making aboutus active
	 */
	@RequestMapping("/aboutus")
	public ModelAndView Aboutuscall() {

		return new ModelAndView("aboutus1").addObject("aboutusactive","active");

	}

	/**
	 * when contact action is performed then it returns the user to contact page
	 * @return ModelAndView object with contact page and setting contact active
	 */
	@RequestMapping("/contact")
	public ModelAndView Contactuscall() {

	
		return new ModelAndView("contact").addObject("contactactive","active");

	}

	/**
	 * when contact1 action is performed then it calls the service's mailService method and returns the user to the success page
	 * @param request
	 * @return ModelAndView object with success page
	 */
	@RequestMapping("/contact1")
	public ModelAndView send(HttpServletRequest request) {

		serviceDao.mailService(request);

		return new ModelAndView("success");

	}
	
	/**
	 * when forgot action is performed then it redirects the user to forgetpassword page
	 * @return ModelAndView object with forget password page
	 */
	@RequestMapping("/forgot")
	public ModelAndView fotgot(){
		return new ModelAndView("forgetpassword");
	}
	
	/**
	 * when forgetpassword action is performed it calls the service's questionService method  that returns the question that is stored in the database of particular user
	 * redirects user to forgetpassword1 page
	 * @param username
	 * @return ModelAndView object with forgetpassword1 page and the question
	 */
	@RequestMapping("/forgetpassword")
	public ModelAndView Forgetpasswordcall(@RequestParam("username") String username )
    {
		System.out.println("Username: "+username);
        String question = serviceDao.questionService(username);
		return new ModelAndView("forgetpassword1").addObject("securityque",question);

	}
	/**
	 * when forgetvalid action is performed then it calls the service's answerService method and that returns true 
	 * then it calls service's passwordService method and if that also returns true
	 * then the user is redirected to the login page along with the password message
	 * @param securityans
	 * @param username
	 * @param password
	 * @return ModelAndView with login page and a password reset message
	 */
	@RequestMapping("/forgetvalid")
	public ModelAndView Forgetvalidcall(@RequestParam("securityans") String securityans,@RequestParam("username") String username,@RequestParam("password") String password )
    {
		
		System.out.println("username"+ username +"Ans "+securityans);
		
        if(serviceDao.answerService(securityans, username))
        {
        	if(serviceDao.passwordService(username, password))
        	{
        	  
              return	new ModelAndView("login").addObject("passwordreset", "your password is reset now login");
        	}
        }
        
        	return new ModelAndView("forgetpassword1").addObject("msg", "Please Enter Correct Answer!");
        

	}

}
