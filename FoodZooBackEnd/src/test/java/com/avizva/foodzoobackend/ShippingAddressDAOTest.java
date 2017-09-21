package com.avizva.foodzoobackend;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.config.TestContextConfig;
import com.avizva.dao.ShippingAddressDAOImpl;
import com.avizva.dao.SupplierDAOImpl;
import com.avizva.model.ShippingAddress;
import com.avizva.model.Suppliers;

public class ShippingAddressDAOTest {
	/**
	 * bean is used that is made through annotation
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestContextConfig.class);
	
	
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testSaveShippingAddress() is made to test whether the saveShippingAddress function is working properly and the data is saved to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
	@Test
	public void testSaveShippingAddress()
	{
		ShippingAddress address=new ShippingAddress();
		address.setFullname("Parul Sharma");
		address.setCountry("India");
		address.setContact("9971486726");
		address.setEmail("sharmaparul597@gmail.com");
		address.setAddress1("gurgaon");
		address.setAddress2("gurgaon");
		address.setCity("gurugram");
		address.setZipcode("122001");
		address.setUsername("Parul Sharma");
		ShippingAddressDAOImpl shippingAddressDAOImpl=(ShippingAddressDAOImpl) context.getBean("shippingAddressDAOImpl");
		boolean result=shippingAddressDAOImpl.saveShippingAddress(address);
		assertTrue(result);
		
	}
	/**
	 * testExistShippingAddress() method to check whether the address corresponding to the username exists or not
	 * using ShippingAddressDAOImpl's existShippingAddress method
	 * 
	 */
	@Test
	public void testExistShippingAddress()
	{
		ShippingAddressDAOImpl shippingAddressDAOImpl=(ShippingAddressDAOImpl) context.getBean("shippingAddressDAOImpl");
		boolean result=shippingAddressDAOImpl.existShippingAddress("Parul Sharma");
		assertTrue(result);
		
	}

}
