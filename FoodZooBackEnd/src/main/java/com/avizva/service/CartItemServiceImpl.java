package com.avizva.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.CartItemDAOImpl;
import com.avizva.model.CartItem;
@Service
public class CartItemServiceImpl {

	Logger logger=Logger.getLogger(CartItemServiceImpl.class);
	@Autowired
	CartItemDAOImpl cartItemDAOImpl;
	
	
	public boolean saveCartItemService(CartItem cartitem) {
		
		logger.info("----inside service:saveCartItemService method------");
		if(cartItemDAOImpl.saveCartItem(cartitem)){
			logger.info("---cartitem info is saved in db-----");
			return true;
		}
		else{
			logger.info("---cartitem info is not saved in db-----");
			return false;
		}
		
	}
	
	
	public boolean updateCartItemService(CartItem cartitem) {
	    logger.info("----inside service:upadteCartItemService method------");
		if(cartItemDAOImpl.updateCartItem(cartitem))
		{
			logger.info("---cartitem info is updated in db-----");
			return true;
		}
		else{
			
			logger.info("---cartitem info is not updates in db---");
			return false;
		}
		
	}
	
	
	
	public boolean deleteCartItemService(CartItem cartitem) {
		logger.info("---inside service:deleteCartItemService method---");
		if(cartItemDAOImpl.deleteCartItem(cartitem))
		{
			logger.info("----cartitem info deleted in db---");
			return true;
		}
		else{
			
			logger.info("---cartitem info not deleted----");
			return false;
		}
		
	}

	
	public CartItem viewCartItemByIdService(int cart_item_id) {
		logger.info("----inside service:viewCartItemByIdService method---");
	CartItem cartitem=cartItemDAOImpl.viewCartItemById(cart_item_id);
	logger.info("----show information related to particular cart_item_id---");
		return cartitem;
		
	}
	public List<CartItem> viewCartItemsService(CartItem cartitem) {
		logger.info("----inside service:viewCartItemService method----");
		List<CartItem> list=null;
		list=cartItemDAOImpl.viewCartItems(cartitem);
		logger.info("---showing all the cartitems---");
		return list;
	}

	
	
	
	
	
}
