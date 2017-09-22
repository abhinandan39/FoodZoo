package com.avizva.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avizva.dao.UserOrderDAOImpl;
import com.avizva.model.UserOrder;

@Service
public class UserOrderServiceImpl implements UserOrderService {
	Logger logger=Logger.getLogger(UserOrderServiceImpl.class);
	
	@Autowired UserOrderDAOImpl userOrderDaoImpl;
	
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

	public UserOrder viewOrderByOrderNameService(String orderName) {
		
		logger.info("----inside viewOrderService-----");
		
		UserOrder userOrder = userOrderDaoImpl.viewOrderByOrderName(orderName);
		
		return userOrder;
	}

	public List<UserOrder> viewOrdersByUsernameService(String username) {
		logger.info("----inside viewOrdersByUsername Service-----");
		List<UserOrder> userOrders = userOrderDaoImpl.viewOrdersByUsername(username);
		return userOrders;
	}

}
