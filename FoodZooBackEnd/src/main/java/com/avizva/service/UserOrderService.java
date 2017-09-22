package com.avizva.service;

import java.util.List;

import com.avizva.model.UserOrder;
/**
 * 
 * @author Parul.Sharma
 * UserOrderService interface for implementing/managing  orders
 *
 */
public interface UserOrderService {
	/**
	 * saveOrderService method for saving the orders of the user
	 * @param order
	 * @return true or false
	 */
	public boolean saveOrderService(UserOrder order);
	/**
	 * viewOrderByOrderNameService method for viewing all the orders of the user
	 * @param orderName
	 * @return userorder
	 */
	public UserOrder viewOrderByOrderNameService(String orderName);
	/**
	 * viewOrdersByUsernameService method for viewing all orders of the user
	 * @param username
	 * @return list of order
	 */
	public List<UserOrder> viewOrdersByUsernameService(String username);

}
