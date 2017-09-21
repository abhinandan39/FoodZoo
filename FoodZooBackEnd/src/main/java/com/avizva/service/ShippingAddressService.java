package com.avizva.service;

import com.avizva.model.ShippingAddress;

/**
 * 
 * @author Parul.Sharma
 * ShippingAddressService interface implemented in ShippingAddressServiceImpl class
 *
 */
public interface ShippingAddressService {
	/**
	 * saveShippingAddressService method for saving the shipping address of the user
	 * @param address
	 * @return true or false
	 */
	public boolean saveShippingAddressService(ShippingAddress address);
/**
 * existShippingAddressService method to check if the address already exist 
 * @param username
 * @return true or false
 */
	public boolean existShippingAddressService(String username);

}
