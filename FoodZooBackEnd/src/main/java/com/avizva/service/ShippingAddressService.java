package com.avizva.service;

import com.avizva.model.ShippingAddress;


public interface ShippingAddressService {
	
	public boolean saveShippingAddressService(ShippingAddress address);

	public boolean existShippingAddressService(String username);

	public ShippingAddress viewAddress(String username);
	public boolean updateAddressService(ShippingAddress address);
}
