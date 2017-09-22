package com.avizva.dao;

import com.avizva.model.ShippingAddress;

public interface ShippingAddressDAO {
	

	public boolean saveShippingAddress(ShippingAddress address);
	public boolean existShippingAddress(String username);
	public boolean updateAddress(ShippingAddress address);
	public ShippingAddress viewAddress(String username);
}
