package com.avizva.service;

import com.avizva.model.UserOrder;

public interface UserOrderService {
	
	public boolean saveOrderService(UserOrder order);
	
	public UserOrder viewOrderByOrderNameService(String orderName);

}
