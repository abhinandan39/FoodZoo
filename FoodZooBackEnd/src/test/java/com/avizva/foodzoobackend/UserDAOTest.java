package com.avizva.foodzoobackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.DAO.UserDAOImpl;
import com.avizva.Model.Users;
import com.avizva.config.ApplicationContextConfig;

public class UserDAOTest {
	/**
	 * bean is used that is made through annotation
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
	
	
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testSaveUser() is made to test whether the saveUser function is working properly and the data is saved to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
	@Test
	public void testSaveUser()
	{
		Users user2=new Users();
		user2.setFname("Abhinandan");
		user2.setLname("Gupta");
		user2.setUsername("nandan261995");
		user2.setPassword("nandu26");
		user2.setContact("9988998899");
		user2.setDob(new Date("1995/12/26"));
		user2.setEmail("abhinandan.gupta@avizva.com");
		user2.setEnabled(true);
		user2.setSecurityque("what's your pet name");
		user2.setSecurityans("buzo");
		user2.setRole("ROLE_USER");
		UserDAOImpl user3=(UserDAOImpl)context.getBean("userDAOImpl");
		boolean result2=user3.saveUser(user2);
		assertTrue(result2);
		Users user1=new Users();
		user1.setFname("Parul");
		user1.setLname("Sharma");
		user1.setUsername("ps123456");
		user1.setPassword("p");
		user1.setContact("9988998899");
		user1.setDob(new Date("1995/12/26"));
		user1.setEmail("parul.sahrma@avizva.com");
		user1.setEnabled(true);
		user1.setSecurityque("what's your pet name");
		user1.setSecurityans("buzo");
		user1.setRole("ROLE_USER");
		UserDAOImpl user=(UserDAOImpl)context.getBean("userDAOImpl");
		boolean result=user.saveUser(user1);
		assertFalse(result);
		
		
	}

	
	/**
	 * testDeactivateUser() method to test whether the deactivateUser function is working well
	 * if it returns true then JUnit returns success
	 * else it shows the related errors
	 */
	
	@Test
	public void testDeactivateUser()
	{
	
		UserDAOImpl user=(UserDAOImpl) context.getBean("userDAOImpl");
		boolean result=user.deactivateUser("Abhinandan26");
		assertTrue(result);
		
		
		
	}
	
	/**
	 * testValidUser() method to check login functionality
	 * takes the username and password and confirms the valid credentials
	 * if returns true then JUnit returns success
	 * else shows the related errors
	 * 
	 */
	@Test
	public void testValidUser()
	{
		UserDAOImpl user=(UserDAOImpl) context.getBean("userDAOImpl");
		boolean result=user.valid("Abhinandan26", "nandu26");
		assertTrue(result);
	}
	
	/**
	 * testSecurityQuestion() method to check securityque method functionality
	 * it will check the question related to particular username
	 * if it works then JUnit returns success
	 * else shows the related error
	 * 
//	 */
	@Test
	public void testSecurityQuestion()
	{
		UserDAOImpl user=(UserDAOImpl) context.getBean("userDAOImpl");
		String result=user.securityque("Abhinandan26");
		assertEquals("what's your pet name", result);
		
		
	}
	
	
	/**
	 * testSecurityAnswer() method checks whether the answers matches to the one saved in database
	 * if it returns true then JUnit returns success 
	 * else shows the related error
	 * 
	 */
	@Test
	public void testSecurityAnswer()
	{
		UserDAOImpl user=(UserDAOImpl) context.getBean("userDAOImpl");
		boolean result=user.securityans("buzo", "Abhinandan26");
		assertTrue(result);
		
		
	}
	
	/**
	 * testUpdatePassword() method to check whether the updatepassword method working properly
	 * if updated then returns true
	 * else
	 * shows the related error
	 * 
	 * 
	 */
	
	
	@Test
	public void testUpdatePassord()
	{
		UserDAOImpl user=(UserDAOImpl) context.getBean("userDAOImpl");
	   boolean result=user.updatepassword("nandan26", "Abhinandan26");
	   assertTrue(result);
		
		
	}
	

}
