package com.avizva.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.PaymentDAOImpl;
import com.avizva.model.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	Logger logger=Logger.getLogger(PaymentServiceImpl.class);

	@Autowired
	PaymentDAOImpl paymentDaoImpl;
	
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
