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
/**
 * 
 * @author Parul.Sharma
 * service annotation for making this class as a service class
 *
 */
@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

	
	/**
	 * keeps track of all transactions
	 */
	Logger logger = Logger.getLogger(ShippingAddressServiceImpl.class);

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
/**
 * autowired annotation for making use of existing bean instead of creating a new object
 */
	@Autowired
	ShippingAddressDAOImpl shippingAddressDAOImpl;
/**
 * saveShippingAddressService method for saving the shipping address entered by user
 * calls shippingAddressDAOImpl's saveShippingAddress and if that returns true then this method returns true 
 * else returns false
 * @param address
 * @return true or false
 */
	public boolean saveShippingAddressService(ShippingAddress address) {
		
		if (shippingAddressDAOImpl.saveShippingAddress(address)) {
			logger.info("---user info is saved in db-----");
			return true;
		} else {
			logger.info("---user info is not saved in db-----");
			return false;
		}

	}
/**
 * existShippingAddressService method for checking if the shipping address already exist for a particular user
 * calls shippingAddressDAOImpl's existShippingAddress method taking username as parameter and if that returns true then
 * this method returns true else returns false
 * @param username
 * @return
 */
	public boolean existShippingAddressService(String username) {
		if (shippingAddressDAOImpl.existShippingAddress(username)) {
			logger.info("---user info is saved in db-----");
		
			return true;
		} else {
			logger.info("---user info is not saved in db-----");
			return false;
		}

	}
/**
 * viewUser for getting all the details ofthe address related to the usernmae
 * uses session to get all the data of the class through username
 * @param username
 * @return  address
 */
	public ShippingAddress viewUser(String username) {
		Session session = null;
		Transaction transaction = null;
		session = getSession();
		transaction = session.beginTransaction();
		ShippingAddress address = session.get(ShippingAddress.class, username);
		session.close();
		return address;

	}
/**
 * updateAddressService method for updating existing address of the user
 * calls shippingAddressDAOImpl's updateAddress method takes address as paramter and if that returns true
 * then  updateAddressService will return true
 * else returns false
 * @param address
 * @return true or false
 */
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

