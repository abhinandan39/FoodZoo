package com.avizva.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.avizva.model.ShippingAddress;
import com.avizva.model.Users;
import com.avizva.service.ServiceDAOImpl;
/**
 * 
 * @author Parul.Sharma
 * reposiory annotation makes bean of impl class
 *
 */
@Repository
public class ShippingAddressDAOImpl {
	/**
	 * keeps the log of all the transactions or things executed
	 */
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
	 * saveShippingAddress mthod for saving the shipping address method bythe user
	 * takes the object of ShippingAddress as paramter
	 * @param address
	 * @return true or false
	 */
	public boolean saveShippingAddress(ShippingAddress address) {
		logger.info("------inside dao:saveuser method------");
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.save(address);
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
 * existShippingAddress method will check if the user still exists
 * @param username
 * @return
 */
	public boolean existShippingAddress(String username) {
			logger.info("------entered into userdao:valid method-----");
		
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try
		{
		session = getSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from ShippingAddress where username =:username ");
		query.setParameter("username", username);
		
		List<Users> list = query.list();
		if (list.isEmpty()) {

			logger.info("----query result empty----");
			flag = false;
		}
		else{
			
			flag=true;
			}
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
	 * updateAddress method that takes the shippingAddress object as parameter and perform the updation of 
	 * already existing address
	 * @param address
	 * @return true or false
	 */
	
	public boolean updateAddress(ShippingAddress address) {
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
//			Users user = session.get(Users.class, username);
			session.update(address);
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

}
