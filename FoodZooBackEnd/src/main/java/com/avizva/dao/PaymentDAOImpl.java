package com.avizva.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.model.Payment;
import com.avizva.service.CategoryServiceDaoImpl;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	Logger logger=Logger.getLogger(PaymentDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
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

}
