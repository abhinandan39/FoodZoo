package com.avizva.foodzoobackend;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.type.CharacterArrayClobType;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.config.TestContextConfig;
import com.avizva.dao.CartItemDAOImpl;
import com.avizva.dao.SupplierDAOImpl;
import com.avizva.model.CartItem;
import com.avizva.model.Suppliers;

public class CartItemDAOTest {
	/**
	 * bean is used that is made through annotation
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestContextConfig.class);
	
	
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testSaveCartItem() is made to test whether the saveCartItemfunction is working properly and the data is saved to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
	@Test
	public void testSaveCartItem()
	{
		CartItem item=new CartItem();
		item.setCart_item_id(1);
		item.setCartitem_quantity(2);
		item.setPrice(222);
		item.setProduct_id("p01");
		item.setUser_name("parulsharma07");
		CartItemDAOImpl cartItemDAOImpl=(CartItemDAOImpl) context.getBean("cartItemDAOImpl");
		boolean result=cartItemDAOImpl.saveCartItem(item);
		assertTrue(result);
//		CartItem item2=new CartItem();
//		item2.setCart_item_id(1);
//		item2.setCartitem_quantity(2);
//		item2.setPrice(222);
//		item2.setProduct_id("p01");
//		item2.setUser_name("Parul Sharma");
//		CartItemDAOImpl cartItemDAOImpl2=(CartItemDAOImpl) context.getBean("cartItemDAOImpl");
//		boolean result2=cartItemDAOImpl2.saveCartItem(item2);
//		assertFalse(result2);
//
//		
	}
	/**
	 * 
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testUpdateCart() is made to test whether the updateCart is working properly and the data is updated to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
//	@Test
//	public void testUpdateCart()
//	{
//		CartItem item=new CartItem();
//		item.setCart_item_id(1);
//		item.setCartitem_quantity(2);
//		item.setPrice(222);
//		item.setProduct_id("p01");
//		item.setUser_name("Abhinandan Gupta");
//		CartItemDAOImpl cartItemDAOImpl=(CartItemDAOImpl) context.getBean("cartItemDAOImpl");
//		boolean result=cartItemDAOImpl.saveCartItem(item);
//		assertTrue(result);
//
//		
//	}
	
	/**
	 * testDeleteCartItem() method to test whether the deleteCartItem function is working well
	 * if it returns true then JUnit returns success
	 * else it shows the related errors
	 */

//	@Test
//	public void testDeleteCartItem()
//	{
//		
//		CartItem item=new CartItem();
//		item.setCart_item_id(1);
//		item.setCartitem_quantity(2);
//		item.setPrice(222);
//		item.setProduct_id("p01");
//		item.setUser_name("Abhinandan Gupta");
//		CartItemDAOImpl cartItemDAOImpl=(CartItemDAOImpl) context.getBean("cartItemDAOImpl");
//		boolean result=cartItemDAOImpl.deleteCartItem(item);
//		assertTrue(result);
//
//		
//	}
//	
	/**
	 * testViewCartItemById() method to test whether viewCartItemById function is working well
	 */
	@Test
	public void testViewCartItemById()
	{
	
		CartItemDAOImpl cartItemDAOImpl=(CartItemDAOImpl) context.getBean("cartItemDAOImpl");
		CartItem result=cartItemDAOImpl.viewCartItemById(1);
		
		
	}
	
	/**
	 * testViewCartItemByUsername() method to test whether viewCartItemByName function is working well
	 */
	@Test
	public void testViewCartItemByUserName()
	{
	
		CartItemDAOImpl cartItemDAOImpl=(CartItemDAOImpl) context.getBean("cartItemDAOImpl");
		List<CartItem> result=cartItemDAOImpl.viewCartItemsByUser("parulsharma07");
		
		
	}
	
	/**
	 * testViewCartItemByUsername() method to test whether viewCartItemByName function is working well
	 */
	@Test
	public void testViewCartItemByUserNameAndProductID()
	{
	
		CartItemDAOImpl cartItemDAOImpl=(CartItemDAOImpl) context.getBean("cartItemDAOImpl");
		List<CartItem> result=cartItemDAOImpl.viewCartItemByProductIdAndUser("p01","Abhinandan Gupta");
		
		
	}


}
