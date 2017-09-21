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
import com.avizva.service.ServiceDAOImpl;

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
	
	public boolean saveOrder(UserOrder userOrder) {
		logger.info("------inside OrderDAOImpl:saveuser method------");
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

	public UserOrder viewOrderByOrderName(String orderNumber) {
		logger.info("------inside OrderDAOImpl:viewOrder method------");
		boolean flag = false;
		Session session = null;
			session = getSession();
			Query query = session.createQuery("from UserOrder where orderNumber=:orderNumber");
			query.setParameter("orderNumber", orderNumber);
			List<UserOrder> orderList = query.list();
			UserOrder userOrder = orderList.get(0);
			return userOrder;		
			


	}

}
