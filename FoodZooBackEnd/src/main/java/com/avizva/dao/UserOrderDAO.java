package com.avizva.dao;

import java.util.List;

import com.avizva.model.UserOrder;


/**
 * 
 * @author Abhinandan.Guptaing 
 * This is DAO for User Order.. Operations like saving and viewing all orders are created here
 *
 */
public interface UserOrderDAO {
	
	/**
	 * 
	 * @param userOrder Saved the object of UserOrder
	 * @return Returns a boolean value. True if Order is saved, else false
	 */
	public boolean saveOrder(UserOrder userOrder);
	
	/**
	 * 
	 * @param orderName Takes the Order Name as input
	 * @return Returns the object of UserOrder that contains all necessary Details
	 */
	public UserOrder viewOrderByOrderName(String orderName);
	
	/**
	 * 
	 * @param username Takes Username as input
	 * @return Returns the List of Orders that have been placed by the User
	 */
	public List<UserOrder> viewOrdersByUsername(String username);

}
