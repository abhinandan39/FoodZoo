package com.avizva.foodzoobackend;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.config.ApplicationContextConfig;
import com.avizva.dao.UserDAOImpl;
import com.avizva.model.Users;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
    	UserDAOImpl s = (UserDAOImpl) ctx.getBean("us");
    	System.out.println(s);
    	Users u1 = new Users();
    	
    	u1.setFname("Abhinandan");
    	u1.setLname("Gupta");
    	u1.setUsername("abhi39");
    	u1.setContact("9899221435");
    	u1.setDob(new Date());
    	u1.setPassword("abhi");
    	u1.setEmail("abhi@gmail.com");
    	u1.setRole("USER");
    	u1.setPassword("abhi");
    	u1.setEnabled(true);
   
    	System.out.println(s.saveUser(u1));
    	
    }
}
