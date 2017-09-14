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


	public boolean updateService(Users user) {
		if(userDAOImpl.updateUser(user))
		{
			return true;
		}
		else{
			return false;
		}
		
	}

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


	public Users viewUserService(String username) {
		Users user=userDAOImpl.viewUser(username);
		logger.info("----view user service success----");
		return user;
	}

	public String questionService(String username) {
		logger.info("----inside service:questionservice method-----");
		String question=userDAOImpl.securityque(username);
        System.out.println("-----inside security que----");
        System.out.println(question);
		return question;
	}

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
