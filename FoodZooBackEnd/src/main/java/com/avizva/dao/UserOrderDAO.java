package com.avizva.dao;

import com.avizva.model.UserOrder;

public interface UserOrderDAO {
	
	public boolean saveOrder(UserOrder userOrder);
	
	public UserOrder viewOrderByOrderName(String orderName);

}
