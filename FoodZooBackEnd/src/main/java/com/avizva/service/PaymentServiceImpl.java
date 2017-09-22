package com.avizva.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.PaymentDAOImpl;
import com.avizva.model.Payment;
/**
 * 
 * @author Parul.Sharma
 * service annotation that makes this class as a service class
 * implements paymentservice interface and its all methods
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {
/**
 * keeps log of the activities/transactions
 */
	Logger logger=Logger.getLogger(PaymentServiceImpl.class);
/**
 * autowired annotation will make the use of old bean of PaymentDAOImpl class instead
 * of creating new object of it
 */
	@Autowired
	PaymentDAOImpl paymentDaoImpl;
	/**
	 * savePaymentService method takes payment object as parameter and calls paymentDaoImpl's savePayment method
	 * passing the save parameter and if that returns true then this method returns true
	 * else returns false
	 */
	public boolean savePaymentService(Payment newpayment) {
		logger.info("----inside service:saveCategorySerice method------");
		if(paymentDaoImpl.savePayment(newpayment)){
			logger.info("---Payment info is saved in db-----");
			return true;
		}
		else{
			logger.info("---Payment info is not saved in db-----");
			return false;
		}
		
	}

	public Payment viewPaymentService(String id) {

		Payment payment = paymentDaoImpl.viewPayment(id);
		return payment;
	}

}
