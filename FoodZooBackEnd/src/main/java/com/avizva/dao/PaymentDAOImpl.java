package com.avizva.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.model.Payment;

import com.avizva.service.CategoryServiceImpl;


/**
 * 
 * @author Parul.Sharma
 * repository annotation makes the bean of impl class
 *
 */

@Repository
public class PaymentDAOImpl implements PaymentDAO {
/**
 * for kepping complete log of the transactions happening
 */
	Logger logger=Logger.getLogger(PaymentDAOImpl.class);

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
	 * savePayment method that will take the payment object as parameter and save the payment mode
	 * returns true or false
	 */
	public boolean savePayment(Payment newpayment) {
			logger.info("--inside paymentdao save method-----");
			 
				boolean flag = false;
				Session session = null;
				Transaction transaction = null;
				try {
					session = getSession();
					transaction = session.beginTransaction();
					session.save(newpayment);
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

	public Payment viewPayment(String id) {
		boolean flag = false;
		Session session = null;
		session = getSession();
		Payment payment = session.get(Payment.class, id);
		return payment;
	}

}
