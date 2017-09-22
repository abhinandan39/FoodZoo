package com.avizva.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.model.UserOrder;


/**
 * 
 * @author Abhinandan.Gupta
 * UserOrderDAOImmpl is the implementation of UserOrderDAO
 * It defines what the given methods will perform
 * @Repository is used to create a bean of this class.
 *
 */
@Repository
public class UserOrderDAOImpl implements UserOrderDAO {
	Logger logger=Logger.getLogger(UserOrderDAOImpl.class);
	
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
	 * saveOrder method Saves the Order in UserOrder table.
	 * @param UserOrder. Takes UserOrder object as input and saves it to the database
	 * @return true if Order is saved, else false
	 */
	public boolean saveOrder(UserOrder userOrder) {
		logger.info("------inside UserOrderDAOImpl : saveOrder method------");
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.save(userOrder);
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
	 * viewOrderByOrderName method shows the current Order placed for the user
	 */
	public UserOrder viewOrderByOrderName(String orderNumber) {
		logger.info("------inside UserOrderDAOImpl : viewOrder method------");
		boolean flag = false;
		Session session = null;
			session = getSession();
			Query query = session.createQuery("from UserOrder where orderNumber=:orderNumber");
			query.setParameter("orderNumber", orderNumber);
			List<UserOrder> orderList = query.list();
			UserOrder userOrder = orderList.get(0);
			return userOrder;		
			


	}

	/**
	 * viewOrderByUsername fetches all the orders corresponding to that username
	 * returns orderlist
	 */
	public List<UserOrder> viewOrdersByUsername(String username) {
		logger.info("------inside UserOrderDAOImpl : viewOrderByUsername  method------");
		boolean flag = false;
		Session session = null;
		session = getSession();
		Query query = session.createQuery("from UserOrder where username=:username");
		query.setParameter("username", username);
		List<UserOrder> orderList = query.list();
		return orderList;
	}

}
