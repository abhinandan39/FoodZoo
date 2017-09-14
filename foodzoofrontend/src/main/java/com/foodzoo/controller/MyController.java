package com.foodzoo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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
	
	Logger logger=Logger.getLogger(MyController.class);
	@Autowired
	ServiceDAO serviceDao;

	@RequestMapping("/")
	public ModelAndView indexcall() {
		
        logger.info("----calling index-----");

		return new ModelAndView("index").addObject("homeactive","active");
		
	}

	@RequestMapping("/home")
	public ModelAndView getHome(){
		
		logger.info("-----calling index------");
		return new ModelAndView("index").addObject("homeactive","active");
	}
	@RequestMapping("/signup")
	public ModelAndView getRgistration(){
		logger.info("---------redirecting to signup page----");
		return new ModelAndView("register").addObject("registeractive","active");
	}
	

	

	@RequestMapping("/loginhere")
	public ModelAndView login(){
		logger.info("-------redirecting to login page-------");
		return new ModelAndView("login").addObject("loginactive","active");
	}
	@RequestMapping("/login")
	public ModelAndView logedin(HttpServletRequest request){
		
		
		logger.info("---entered into controller logedin method-------");
		logger.info("----calling loginService method-----");
		boolean check = serviceDao.loginService(request);
		if(check){
			
			HttpSession session = request.getSession(false); 
			session.setAttribute("sessionusername", request.getParameter("username"));
			logger.info("---login Successful---");
			return new ModelAndView("redirect:/");
		}
		else{
			logger.info("----login unsucessful----");
			return new ModelAndView("login")
					.addObject("errormsg", "Invalid Credentials")
					.addObject("loginactive","active");
		}
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		logger.info("----inside controller logout method-----");
		HttpSession session = request.getSession();
		session.invalidate();
		logger.info("-----session invalidated-------");
		return new ModelAndView("redirect:/");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(format, false));

	}
	@RequestMapping("/registeruser")
	public ModelAndView saveUser(@Valid @ModelAttribute Users user, 
			BindingResult result, HttpServletRequest request){
		logger.info("----inside controller:saveuser method-------");
		
		user.setEnabled(true);

		if(result.hasErrors()){
			logger.info("---form data is not binded properly-----");
			return new ModelAndView("register").addObject("registeractive","active");
		}
		
		if(serviceDao.saveService(user))
		{
			logger.info("---calling service:saveservice method---");
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionusername",user.getUsername());
			logger.info("---registration success-------");
			return new ModelAndView("redirect:/","userregister","Your registration was Successfull");
		}
		else {
			logger.info("-----registration failed------");
			return new ModelAndView("register")
					.addObject("msg","Error While Registering")
					.addObject("registeractive","active");
		}
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
		logger.info("------user deactivation success-----");
		session.invalidate();
//		HttpSession session = request.getSession();
//		session.invalidate();
		return new ModelAndView("redirect:/","userdeactivated","Your deactivation request was successfull");
	}
	else{
		logger.info("------ user deactivation failed-----");
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
		logger.info("---calling forgetpassword page----");
		return new ModelAndView("forgetpassword");
	}
	
	@RequestMapping("/forgetpassword")
	public ModelAndView Forgetpasswordcall(@RequestParam("username") String username )
    {
		logger.info("Username is: "+username);
        String question = serviceDao.questionService(username);
        logger.info("----security question is fetched------:"+ question);
		return new ModelAndView("forgetpassword1").addObject("securityque",question);

	}
	
	@RequestMapping("/forgetvalid")
	public ModelAndView Forgetvalidcall(@RequestParam("securityans") String securityans,@RequestParam("username") String username,@RequestParam("password") String password )
    {
		
		logger.info("username"+ username +"Ans "+securityans);
		
        if(serviceDao.answerService(securityans, username))
        {
        	logger.info("---security answer is validated-----");
        	if(serviceDao.passwordService(username, password))
        	{
        		logger.info("---password is reset-----");
return	new ModelAndView("login").addObject("passwordreset", "Password reset successful");

        	}
        }
        
            logger.info("---security answer validation failed----");
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
