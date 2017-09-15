package com.avizva.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.avizva.DAO.UserDAOImpl;
import com.avizva.Model.Users;


@Service
public class ServiceDAOImpl implements ServiceDAO{
	
	Logger logger=Logger.getLogger(ServiceDAOImpl.class);
	@Autowired
	UserDAOImpl userDAOImpl;
	

/**
 * saveService method takes the user object as parameter and passes it to userDAOImpl's saveUser method 
 * if that returns true then a confirmation mail is sent to the user and return true
 * else it returns false
 * @param user
 * @return true or false
 * 
 */
	public boolean saveService(Users user) {
		logger.info("----inside service:saveserive method------");
		if(userDAOImpl.saveUser(user)){
			logger.info("---user info is saved in db-----");
			String from = "FoodZoo";
			String to = user.getEmail();
			String subject = "Welcome To FoodZoo";
			String msg = "Dear, "+user.getUsername()+"\n Thankyou for registering with FoodZoo \n"+
			"We hope you have a nice experience with us. \n Enjoy our food and fast service. \n "+
					"Thanks & Regards, \n FoodZoo";
			ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
			SendEmail mail = (SendEmail) context.getBean("sendEmail");
			mail.sendMail(from, to, subject, msg);
			logger.info("mail is sent to registerd user: "+ user.getUsername()+"from "+from+"to "+to);
			return true;
		}
		else{
			logger.info("---user info is not saved in db-----");
			return false;
		}
		
	}

/**
 * updateService method calls the userDAOImpl's update service method that update the existing details with the new one
 * if that returns true updation mail is sent to the user with update details
 * else shows the error
 * 
 * @param user
 * @return true or false
 */
	public boolean updateService(Users user) {
		if(userDAOImpl.updateUser(user))
		{
			return true;
		}
		else{
			return false;
		}
		
	}

	
	/**
	 * mailService method called for providing mail service to the user
	 * when user clicks on the submit button of contact us page then a mail will be sent to the email id "To"
	 * with the message and subject written by the user
	 * @param request
	 * @return true 
	 * 
	 */
	public boolean mailService(HttpServletRequest request) {
		
		String from = request.getParameter("from");
		String to = "abhinandangupta39@gmail.com";
		String subject = request.getParameter("subject");
		String msg = request.getParameter("message");
		System.out.println("inside controller");
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		SendEmail mail = (SendEmail) context.getBean("sendEmail");
		mail.sendMail(from, to, subject, msg);
		logger.info("----mail is sent from mail service---"+"from "+from+"to "+to);
		return true;
	}
	
/**
 * loginService takes the user information and further passes it to the validity method of serviceDAO
 * And if that returns true then user is logged in successfully
 * else not
 * @param request
 * @return true or false
 */
	public boolean loginService(HttpServletRequest request) {
		logger.info("-----enterd into service:loginService method-----");
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		logger.info("username is: "+user +"password is: "+pass);
		logger.info("-----calling validity method-------");
		boolean check = validity(user,pass);
		
		if(check){
			logger.info("---validation is successful loginsuccess------");
			return true;
		}
		else{
			logger.info("---validation is unsuccessful login failed------");
			return false;
		}
		
	}

/**
 * validity service method takes the name and password and passes it further to userDAOImpl's valid method
 * @param username,password
 * @return true or false
 * 
 */
	public boolean validity(String username, String password) {
		logger.info("-----entered into service:validity method-----");

		boolean check = userDAOImpl.valid(username, password);
		if(check){
			logger.info("-----service:validity method success-----");
			
			return true;
		}
		else{
			logger.info("-----service:validity method failed-----");

			return false;
		}
	}

/**
 * deactivateService method calls the userDAOImpl's deactivate method
 * if that returns true then takes the user information from viewUserService method and sends a deactivation mail to the user and further returns true
 * else return false
 * @param username
 * @return true or false
 */
	public boolean deactivateService(String username) {
			boolean check = userDAOImpl.deactivateUser(username);
			if(check){
				Users user=viewUserService(username);
				String from="FoodZoo";
				String to=user.getEmail();
				String subject="Account Deactivated";
				String msg="Dear,"
						+username
						+ "\n"
						+ "Your account deactivation request have been proccessed."
						+ "\n"
						+ "Hope to look you back soon"
						+ "\n"
						+ "Thanks&Regards \n"
						+ "FoodZoo";	
				ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
				SendEmail mail = (SendEmail) context.getBean("sendEmail");
				mail.sendMail(from, to, subject, msg);
				return true;
			}
			else{
				logger.info("----deactivation service method failed-----");
				return false;
			}
	}

	/**
	 * viewUserService calls the userDAOImpl's viewUser method that returns the user object 
	 * and this method is further used by deactivate service method for sending the deactivation mail
	 * @param username
	 * @return user
	 */
	public Users viewUserService(String username) {
		Users user=userDAOImpl.viewUser(username);
		logger.info("----view user service success----");
		return user;
	}

	/**
	 * questionService calls userDAOImpl's security question method that returns the question related to the particular user
	 * @param username
	 * @return question
	 */
	public String questionService(String username) {
		logger.info("----inside service:questionservice method-----");
		String question=userDAOImpl.securityque(username);
        System.out.println("-----inside security que----");
        System.out.println(question);
		return question;
	}

	/**
	 * answerService method calls the userDAOImpl's securityans method that matches the answer enter by user with stored answer
	 * if it matches then it returns true
	 * else
	 * false
	 * @param securityans, username
	 * @return true or false
	 */
	public boolean answerService(String securityans, String username) {
		if(userDAOImpl.securityans(securityans,username))
        {
			logger.info("----security answer service method success:-----");

        	return true;
        }
		else{
		logger.info("----security answer service method failed :-----");
		return false;
		}
	}

	/**
	 * passwordService method calls the userDAOImpl's updatepassword method that updates the predefined password of the user corresponding to the particular user
	 * if updated then returns true
	 * else false
	 * @param username,password
	 * @return true or false
	 */
	public boolean passwordService(String username, String password) {

		if(userDAOImpl.updatepassword(password,username))
    	{
    	  
          return true;
    	}
		else{
			logger.info("----password updation service method failed----");
			return false;
		}
	}
	

}
