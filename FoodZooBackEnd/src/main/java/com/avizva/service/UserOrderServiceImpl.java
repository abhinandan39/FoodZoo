package com.avizva.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avizva.dao.UserOrderDAOImpl;
import com.avizva.model.UserOrder;
/**
 * service annotation for making class as a service class
 * @author Parul.Sharma
 *
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {
	/**
	 * for keeping all the logs
	 */
	Logger logger=Logger.getLogger(UserOrderServiceImpl.class);
	
	@Autowired UserOrderDAOImpl userOrderDaoImpl;
	/**
	 * saveOrderService method for saving all the order of the user
	 * returns true or false
	 */
	public boolean saveOrderService(UserOrder order) {
		logger.info("----inside saveOrderservice:s-----");
		if(userOrderDaoImpl.saveOrder(order)){
			logger.info("----Order Saved-----");
			return true;
		}
		else{
			logger.info("----Order Not Saved-----");
			return false;
			
		}
		
	
	}
/**
 * viewOrderByOrderNameService method for viewing all the orders by order name
 * returns order
 */
	public UserOrder viewOrderByOrderNameService(String orderName) {
		
		logger.info("----inside viewOrderService-----");
		
		UserOrder userOrder = userOrderDaoImpl.viewOrderByOrderName(orderName);
		
		return userOrder;
	}
/**
 * viewOrderByUsernameService method for viewing all the orders of the user by usernme
 * returns list of user orders
 */
	public List<UserOrder> viewOrdersByUsernameService(String username) {
		logger.info("----inside viewOrdersByUsername Service-----");
		List<UserOrder> userOrders = userOrderDaoImpl.viewOrdersByUsername(username);
		return userOrders;
	}

}
