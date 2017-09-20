package com.avizva.service;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.avizva.dao.ShippingAddressDAOImpl;
import com.avizva.model.ShippingAddress;

@Service
public class ShippingAddressServiceImpl {
	Logger logger = Logger.getLogger(ServiceDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * getSession method is used to open/create a session from the auto-wired
	 * object of sessionFactory.
	 * 
	 * @return Session
	 */
	public Session getSession() {
		return sessionFactory.openSession();
	}

	@Autowired
	ShippingAddressDAOImpl shippingAddressDAOImpl;

	public boolean saveShippingAddressService(ShippingAddress address) {
		String username = address.getUsername();
		logger.info("----inside service:saveserive method------");
		if (shippingAddressDAOImpl.saveShippingAddress(address)) {
			logger.info("---user info is saved in db-----");
			String from = "FoodZoo";
			String to = address.getEmail();
			String subject = "Welcome To FoodZoo";
			String msg = "Dear, " + address.getUsername() + "\n Thankyou for registering with FoodZoo \n"
					+ "We hope you have a nice experience with us. \n Enjoy our food and fast service. \n "
					+ "Thanks & Regards, \n FoodZoo";
			ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
			SendEmail mail = (SendEmail) context.getBean("sendEmail");
			mail.sendMail(from, to, subject, msg);
			logger.info("mail is sent to registerd user: " + address.getUsername() + "from " + from + "to " + to);
			return true;
		} else {
			logger.info("---user info is not saved in db-----");
			return false;
		}

	}

	public boolean existShippingAddressService(String username) {
		if (shippingAddressDAOImpl.existShippingAddress(username)) {
			logger.info("---user info is saved in db-----");
		
			return true;
		} else {
			logger.info("---user info is not saved in db-----");
			return false;
		}

	}

	public ShippingAddress viewUser(String username) {
		Session session = null;
		Transaction transaction = null;
		session = getSession();
		transaction = session.beginTransaction();
		ShippingAddress address = session.get(ShippingAddress.class, username);
		session.close();
		return address;

	}

}
