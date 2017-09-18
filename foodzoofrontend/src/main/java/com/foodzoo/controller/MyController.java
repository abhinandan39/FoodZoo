package com.foodzoo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Categories;
import com.avizva.model.Suppliers;
import com.avizva.model.Users;
import com.avizva.service.CategoryServiceDAO;
import com.avizva.service.ServiceDAO;
import com.avizva.service.SupplierServiceDAO;

@Controller
public class MyController {

	/**
	 * for creating object of ServiceDAO using annotation 
	 */

	
	Logger logger=Logger.getLogger(MyController.class);

	@Autowired
	ServiceDAO serviceDao;
	@Autowired
	CategoryServiceDAO categoryServiceDao;
	@Autowired
	SupplierServiceDAO supplierServiceDao;


	/**
	 * requestmapping annotation maps the user request to particular action 
	 *"/" redirects the user to the index page
	 *returns the object of ModelAndView that passes the jsp page as parameter and redirects to that page
	 *with addObject passes the data in key value pair in a way that active value is passed to the key homeactive
	 * @return ModelAndView object with index page and key value pair data through addObject
	 */
	@RequestMapping("/")
	public ModelAndView indexcall() {
		
        logger.info("----calling index-----");

     
       
	return new ModelAndView("index").addObject("homeactive","active");
              
		
        
	}

	/**
	 * when the home action is done it redirects user to index page with data in key value pair
	 * 
	 * @return ModelAndView object with jsp page and data in key value pair that will make the home active
	 */
	@RequestMapping("/home")
	public ModelAndView getHome(){
		
		logger.info("-----calling index------");
		return new ModelAndView("index").addObject("homeactive","active");
	}
	/**
	 * when signup action is performed then it redirects to register page
	 * @return ModelAndView object with register page and making the register active
	 */
	@RequestMapping("/signup")
	public ModelAndView getRgistration(){
		logger.info("---------redirecting to signup page----");
		return new ModelAndView("register").addObject("registeractive","active");
	}
	
	/**
	 * when loginhere action is performed then it redirects to the login page and makes the login button active
	 * @return ModelAndView object with login page and making login button active
	 */

	

	@RequestMapping("/loginhere")
	public ModelAndView login(){
		logger.info("-------redirecting to login page-------");
		return new ModelAndView("login").addObject("loginactive","active");
	}
	
	/**
	 * when login action is performed then it calls the service's loginService method with the request paramter
	 * if it returns true then user is logged in successfully and its session is maintained
	 * else
	 * it redirects to login page with an error message
	 * The role is binded in the session so that different navbar items can be shown according to the role
	 * @param request
	 * @return ModelAndView object with data according to the condition whether true or false
	 */
	@RequestMapping("/login")
	public ModelAndView logedin(HttpServletRequest request){
		
		
		logger.info("---entered into controller logedin method-------");
		
		
		
	
		
		logger.info("----calling loginService method to check validity-----");
		
		boolean check = serviceDao.loginService(request);
		if(check){
			
			logger.info("----Checking the Role of the User----");
			
			String username = request.getParameter("username");
			Users user = serviceDao.viewUserService(username);
			String role = user.getRole();
			
			logger.info("---login Successful---");
			
			logger.info("--- Storing username and role in session---");
			HttpSession session = request.getSession(false); 
			session.setAttribute("sessionusername",username);
			session.setAttribute("sessionrole", role);
			
			return new ModelAndView("index","msg","Log In Successful")
					.addObject("homeactive","active");
		}
		else{
			logger.info("----login unsucessful----");
			return new ModelAndView("login")
					.addObject("errormsg", "Invalid Credentials")
					.addObject("loginactive","active");
		}
		
	}
	
	/**
	 * This is the login page for Admin. It will redirect admin to the admin panel
	 * 
	 * @return
	 */
	@RequestMapping("/adminPanel")
	public ModelAndView adminPanel(HttpSession session){
		String adminRole = (String)session.getAttribute("sessionrole");
		logger.info("-----calling adminPanel------");
		return new ModelAndView("index").addObject("homeactive","active").addObject("adminRole",adminRole);
	}
	
	/**
	 * This method is to validate the Admin only.
	 * 
	 * @return
	 */
	@RequestMapping("/loginadmin")
	public ModelAndView loginAdmin(){
		
		return new ModelAndView("loginadmin");
	}
	
	@RequestMapping("/loginerror")
	public ModelAndView loginError(){
		
		return new ModelAndView("loginadmin","msg","Invalid Credentials");
	}
	
	
	/**
	 * when logout action is performed then it redirects to index page
	 * and session is invalidated
	 * @param request
	 * @return ModelAndView object with index page
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		logger.info("----inside controller logout method-----");
		HttpSession session = request.getSession();
		session.invalidate();
		logger.info("-----session invalidated-------");
		return new ModelAndView("index","msg","Logout Successful").addObject("homeactive","active");
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
		logger.info("----inside controller:saveuser method-------");
		
		user.setEnabled(true);
		String username = user.getUsername();
		logger.info("----inside controller, username is "+username);
		if(result.hasErrors()){
			logger.info("---form data is not binded properly-----");
			return new ModelAndView("register").addObject("registeractive","active");
		}
		if(serviceDao.existUserService(username))
		{	logger.info("---user already exists-----");
			return new ModelAndView("register")
					.addObject("existmsg","username already taken. Please use a different one")
					.addObject("registeractive","active");
		}
		if(serviceDao.saveService(user))
		{
			logger.info("---calling service:saveservice method---");
			
			HttpSession session = request.getSession(false);
			session.setAttribute("sessionusername",user.getUsername());
			session.setAttribute("sessionrole", user.getRole());
			logger.info("---registration success-------");
			return new ModelAndView("index","msg","Your registration was Successfull").addObject("homeactive", "active");
		}
		else {
			logger.info("-----registration failed------");
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
		    public ModelAndView updateUser(@Valid @ModelAttribute Users user, BindingResult result){
		 
		 	logger.info("--Inside Controller : Update user");
		 	
		 	logger.info("---Checking Hibernate Validity---");
		 	
		 	if(result.hasErrors()){
		 		
		 		logger.info("---Error in Updating Database ---");
		 		return new ModelAndView("updatepage","command",user);
		 	}
		 	
			boolean check = serviceDao.updateService(user);
			if(check)
				{
				logger.info("--- User Updated Successfully ---");
					return new ModelAndView("index","msg","Your details have been updated").addObject("registeractive","active");
				}
			else{
				return new ModelAndView("profilepage","error","Some error occured");
			}
			
			
		}
		
	
	
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
	public ModelAndView deactivate1(@RequestParam("username") String username, @RequestParam("password") String password){
		boolean check = serviceDao.validity(username,password);
		if(check){
			return new ModelAndView("question");
		}
		else{
			return new ModelAndView("deactivate","msg","Invalid Credentials");
		}
		
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
		logger.info("------user deactivation success-----");
		session.invalidate();

		return new ModelAndView("index","msg","Your deactivation request was successfull");
	}
	else{
		logger.info("------ user deactivation failed-----");
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
		logger.info("---calling forgetpassword page----");
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
		
		logger.info("Username is: "+username);
		if(serviceDao.existUserService(username))
		{	logger.info("---user exists true-----");
			String question = serviceDao.questionService(username);
	        logger.info("----security question is fetched------:"+ question);
	        return new ModelAndView("forgetpassword1").addObject("securityque",question);
			
		}
		else{
		return new ModelAndView("forgetpassword")
				.addObject("msg","Username does not exist. Please enter correct username ");
		}

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
	public ModelAndView Forgetvalidcall(@RequestParam("securityans") String securityans,@RequestParam("username") String username
										,@RequestParam("password") String password)
    {
		
		
		
		logger.info("---username---"+ username +"-Ans- "+securityans);
		
        if(serviceDao.answerService(securityans, username))
        {
        	logger.info("---security answer is validated-----");
        	
        	     	
        	if(serviceDao.passwordService(username, password))
        	{
        		logger.info("---password is reset-----");
        		return	new ModelAndView("login").addObject("msg", "Password reset successful");

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

   @RequestMapping("/manageCategory")
   public ModelAndView callcategory(@ModelAttribute Categories category)
   {
	   List<Categories> list=new ArrayList<Categories>();

	     list= categoryServiceDao.viewCategoryService(category);
	     if(!list.isEmpty())
	     return new ModelAndView("managecategory","command",new Categories()).addObject("list",list);
	     else
	    	 return new ModelAndView("managecategory","command",new Categories());
	

		  
   }
	@RequestMapping("/savecategory")
	public ModelAndView saveCategory(@ModelAttribute Categories newcategory)
	{
		     if(categoryServiceDao.saveCategoryService(newcategory))
		     return new ModelAndView("redirect:/manageCategory").addObject("msg","data is saved");
		     else
			     return new ModelAndView("redirect:/manageCategory").addObject("msg","data is not saved");
 
    }

	@RequestMapping("/categorydelete/{id}")
	public ModelAndView delete(@PathVariable String id) {
		Categories category=categoryServiceDao.viewCategoryByIdService(id);
		if (categoryServiceDao.deleteCategoryService(category)) {
			return new ModelAndView("redirect:/manageCategory");
		} else {

			return new ModelAndView("managecategory", "msg", "data not deleted");
		}

	}

	@RequestMapping("/categoryupdate")
	public ModelAndView categoryupdate(@ModelAttribute Categories updatedcategory)
	{
		categoryServiceDao.updateCategoryService(updatedcategory);
		return new ModelAndView("redirect:/manageCategory");
		
	}
	
	 @RequestMapping("/manageSupplier")
	   public ModelAndView callsupplier(@ModelAttribute Suppliers suppliers)
	   {
		   List<Suppliers> list=new ArrayList<Suppliers>();

		     list= supplierServiceDao.viewSupplierService(suppliers);
		     if(!list.isEmpty())
		     return new ModelAndView("managesuppliers","command",new Suppliers()).addObject("list",list);
		     else
		    	 return new ModelAndView("managesuppliers","command",new Suppliers());
	   }
	 @RequestMapping("/savesupplier")
		public ModelAndView saveSupplier(@ModelAttribute Suppliers suppliers)
		{
			     if(supplierServiceDao.saveSupplierService(suppliers))
			     return new ModelAndView("redirect:/manageSupplier").addObject("msg","data is saved");
			     else
				     return new ModelAndView("redirect:/manageSupplier").addObject("msg","data is not saved");
	 
	    }

		@RequestMapping("/supplierdelete/{id}")
		public ModelAndView deletesup(@PathVariable String id) {
		     Suppliers suppliers=supplierServiceDao.viewSupplierByIdService(id);
			if (supplierServiceDao.deleteSupplierService(suppliers)) {
				return new ModelAndView("redirect:/manageSupplier");
			} else {

				return new ModelAndView("manageSupplier", "msg", "data not deleted");
			}

		}

		
		
		@RequestMapping("/supplierupdate")
		public ModelAndView supplierupdate(@ModelAttribute Suppliers suppliers)
		{
			supplierServiceDao.updateSupplierService(suppliers);
			return new ModelAndView("redirect:/manageSupplier");
			
		}
		
		
}
