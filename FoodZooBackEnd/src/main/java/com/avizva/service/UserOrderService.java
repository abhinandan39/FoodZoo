package com.avizva.service;

import java.util.List;

import com.avizva.model.UserOrder;

public interface UserOrderService {
	
	public boolean saveOrderService(UserOrder order);
	
	public UserOrder viewOrderByOrderNameService(String orderName);
	
	public List<UserOrder> viewOrdersByUsernameService(String username);

}
