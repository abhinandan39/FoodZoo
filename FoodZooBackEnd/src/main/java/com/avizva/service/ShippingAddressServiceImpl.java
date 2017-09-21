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
import com.avizva.model.Users;

@Service
public class ShippingAddressServiceImpl {
	Logger logger = Logger.getLogger(UserServiceImpl.class);
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
		
		if (shippingAddressDAOImpl.saveShippingAddress(address)) {
			logger.info("---user info is saved in db-----");
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

	public boolean updateAddressService(ShippingAddress address) {
		
			if(shippingAddressDAOImpl.updateAddress(address))
			{
				return true;
			}
			else{
				return false;
			}
			
		}
	}

