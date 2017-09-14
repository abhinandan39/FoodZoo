package com.avizva.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.avizva.DAO.UserDAOImpl;
import com.avizva.Model.Users;

@Service
public class ServiceDAOImpl implements ServiceDAO{
	
	@Autowired
	UserDAOImpl userDAOImpl;
	


	public boolean saveService(Users user) {
		if(userDAOImpl.saveUser(user)){
			
			String from = "FoodZoo";
			String to = user.getEmail();
			String subject = "Welcome To FoodZoo";
			String msg = "Dear, "+user.getUsername()+"\n Thankyou for registering with FoodZoo \n"+
			"We hope you have a nice experience with us. \n Enjoy our food and fast service. \n "+
					"Thanks & Regards, \n FoodZoo";
			ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
			SendEmail mail = (SendEmail) context.getBean("sendEmail");
			mail.sendMail(from, to, subject, msg);
			return true;
		}
		else{
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
		return true;
	}

	public boolean loginService(HttpServletRequest request) {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		boolean check = validity(user,pass);
		if(check){
			return true;
		}
		else{
			return false;
		}
		
	}


	public boolean validity(String username, String password) {
		boolean check = userDAOImpl.valid(username, password);
		if(check){
			return true;
		}
		else{
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
				return false;
			}
	}


	public Users viewUserService(String username) {
		Users user=userDAOImpl.viewUser(username);
		
		return user;
	}

	public String questionService(String username) {
		String question=userDAOImpl.securityque(username);
        System.out.println("inside security que");
        System.out.println(question);
		return question;
	}

	public boolean answerService(String securityans, String username) {
		if(userDAOImpl.securityans(securityans,username))
        {
        	return true;
        }
		else{
		return false;
		}
	}

	public boolean passwordService(String username, String password) {

		if(userDAOImpl.updatepassword(password,username))
    	{
    	  
          return true;
    	}
		else{
			return false;
		}
	}
	

}
