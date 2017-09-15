package com.avizva.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.model.Users;
import com.avizva.service.ServiceDAOImpl;



@Repository
public class UserDAOImpl implements UserDAO {
	Logger logger=Logger.getLogger(ServiceDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * getSession method is used to open/create a session from the auto-wired object of sessionFactory.
	 * @return Session
	 */
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	
	
	/**
	 * saveUser method gets the user object as parameter from ServiceDAOImpl's saveService method
	 * and will begin a transaction with the help of current session.During this transaction user data will be saved
	 * using session's save method followed by commitment of transaction and closing of session.
	 * on saving user data successfully it will return true to the serviceDAOImpl's saveService method.
	 * or else it returns false
	 * @param user : Object of user class that contains data of a user for a particular session.
	 * @return true or false
	 * 
	 */
	
	public boolean saveUser(Users user) {
       logger.info("------inside dao:saveuser method------");
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			session.save(user);
			transaction.commit();
			flag = true;		
		} catch (Exception e) {
			logger.error("exception occured:"+ e);
			transaction.rollback();
			
		} finally {
			session.close();
		}

		return flag;

	}
	
	
	/**
	 * updateUser method gets the user object as parameter from ServiceDAOImpl's updateService method
	 * and will begin a transaction with the help of current session.During this transaction user data will 
	 * be updated using session's update method followed by commitment of transaction and closing of session.
	 * On updating user data successfully it will return true to the serviceDAOImpl's updateService method.
	 * or else it returns false
	 * @param user : Object of user class that contains data of a user for a particular session.
	 * @return true or false
	 * 
	 */
	
	
	
	public boolean updateUser(Users user) {

		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
//			Users user = session.get(Users.class, username);
			session.update(user);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			logger.error("exception occured:"+ e);
			transaction.rollback();
		} finally {
			session.close();

		}
		return flag;
	}
	

	/**
	 * valid method gets the username and password as parameters from ServiceDAOImpl's validity method,
	 * and will begin a transaction with the help of current session.During this transaction username and password will 
	 * be validated using session's query which will return a list only if current username and password is existing in DB.
	 * followed by closing of session.
	 * On validating user data successfully it will return true to the serviceDAOImpl's validity method.
	 * or else it returns false
	 * @param username : username of a user entered by user at the time of login.
	 * @param password : password of a user entered by user at the time of login.
	 * @return true or false
	 * 
	 */
	
	
	public boolean valid(String username, String password) {
		logger.info("------entered into userdao:valid method-----");
		
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try
		{
		session = getSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from Users where username =:username AND password =:password ");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Users> list = query.list();
		if (list.isEmpty()) {

			logger.info("----query result empty----");
			flag = false;
		}
		else{
			
			flag=true;}
		}
		catch(Exception e){
			logger.error("exception occured:"+ e);
			transaction.rollback();
		}

		finally
		{
		session.close();
		}
       
		return flag;

	}
	
	

	/**
	 * deactivateUser method will get control and username for a particular session from ServiceDAOImpl's deactivateService method,
	 * and will begin a transaction with the help of current session.During this transaction username will be set in user object and
	 * for that particular object enabled status will be set as "false" followed by updating user data. After commiting transaction
	 * user will be deactivated and it will return true or else false.
	 * @param username : username for current session 
	 * @return true or false
	 */
	
	
	public boolean deactivateUser(String username) {
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		logger.info("Inside Deactivate UserDAOIMPl "+username);
		try{
		session = getSession();
		transaction = session.beginTransaction();
		Users user = session.get(Users.class, username);
		user.setEnabled(false);
		logger.info("Inside Deactivate UserDAOIMPl. Getting user "+user);
		session.update(user);
		transaction.commit();
		flag = true;
		}
		catch(Exception e){
			logger.error("exception occured:"+ e);
			transaction.rollback();
		}
		finally{
			session.close();
			
		}
		return flag;
	}

	/**
	 * viewUser method will get username as parameter from ServiceDAOImpl's viewUserService method.
	 * it will then pass it in session.get() method as primary key and will fetch the user record on
	 * the basis of that primary key will return that data.
	 * @param username: username for current session.
	 * @return object of Users class
	 */

	public Users viewUser(String username) {
		Session session = null;
		Transaction transaction = null;
		session = getSession();
		transaction = session.beginTransaction();
		Users user=session.get(Users.class, username);
		session.close();
		return user;
	
	}
	
	
	/**
	 * securityque method will get username as parameter from ServiceDAOImpl's questionService method,
	 * and will begin a transaction with the help of current session.During this transaction it will
	 * use username primary key and will fetch the securityque for that particular username using query.
	 * followed by commitment of transaction and closing of session.
	 *@param username username for a particular session
	 *@return String
	 */
		
	public String securityque(String username)
	{
		
		String flag=null;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
		transaction = session.beginTransaction();
		Query q =  session.createQuery("select securityque from Users where username=:username");
		 q.setParameter("username", username);
		List<String> securityLlist = q.list();
		
		flag=securityLlist.get(0);
		logger.info("security question is:" + flag);
		transaction.commit();
	
		}
		catch(Exception e){
			logger.error("exception occured:"+ e);
			transaction.rollback();
		}
		finally{
			session.close();
			
		}
		return flag;
		
		
	}
	
	/**
	 * securityans method will get answer and username as parameter from ServiceDAOImpl's answerService method,
	 * and will begin a transaction with the help of current session.During this transaction it will
	 * use username primary key and will fetch the security answer for that particular username using query.
	 * After this it will check whether the parameter answer and result obtained from query are same or not.if 
	 * they are it will return true or else it will return false.
	 *@param username username for a particular session
	 *@answer answer  security answer entered by the user for a particular session
	 *@return true or false
	 */
	public boolean securityans(String answer,String username)
	{
		String result=null;
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
		transaction = session.beginTransaction();
		Query q =  session.createQuery("select securityans from Users where username=:username");
		 q.setParameter("username", username);
		List<String> securityLlist = q.list();
		
		result=securityLlist.get(0);
		logger.info("security answer: " + flag);
		if(result.equalsIgnoreCase(answer))
		{
			flag=true;
		
		transaction.commit();
		}
		}
		catch(Exception e){
			logger.error("exception occured:"+ e);
			transaction.rollback();
		}
		finally{
			session.close();
			
		}
		return flag;
		
	}
	
	/***
	 *  updatepassword method will get password and username from ServiceDAOImpl's  passwordService method,
	 *  and will begin a transaction with the help of current session.During this transaction it will set the 
	 *  new password  as password parameter.this will be done by a query using username as primary key.
	 * @param password  new-password entered by the user.
	 * @param username  username for a particular session.
	 * @return true or false 
	 */
	
	public boolean updatepassword(String password,String username)
	{
		
		String result=null;
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
		transaction = session.beginTransaction();
		
		Query q =  session.createQuery("UPDATE Users set password =:password WHERE username =:username");
		 q.setParameter("username", username);
		 q.setParameter("password", password);
		int result1= q.executeUpdate();
		flag=true;
		System.out.println("password updated"+ result1);
		transaction.commit();
		}
		catch(Exception e){
			logger.error("exception occured:"+ e);
			transaction.rollback();
		}
		finally{
			session.close();
			
		}
		return flag;
		
	}
	
	/**
	 * existUser method returns true if user exists, else it returns false
	 * @param username User is fetched from database using username
	 */
	public boolean existUser(String username){
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			Users user = session.get(Users.class, username);
			logger.info("Inside existUser  " + user);
			if(user!=null){
			logger.info("Inside existUser, value is true");	
				flag = true;
			}
		} catch (Exception e) {
			logger.error("exception occured:"+ e);
			transaction.rollback();
		} finally {
			session.close();

		}
		return flag;
	}

}
