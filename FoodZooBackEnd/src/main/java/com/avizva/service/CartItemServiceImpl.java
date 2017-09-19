package com.avizva.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.CartItemDAOImpl;
import com.avizva.dao.ProductsDAOImpl;
import com.avizva.model.CartItem;
import com.avizva.model.Products;


@Service
public class CartItemServiceImpl {

	Logger logger=Logger.getLogger(CartItemServiceImpl.class);
	@Autowired
	CartItemDAOImpl cartItemDAOImpl;
	
	@Autowired
	ProductsDAOImpl productsDAOImpl;
	
	public boolean saveCartItemService(CartItem cartitem) {
		
		logger.info("----inside service:saveCartItemService method------");
		Products products=productsDAOImpl.viewProductById(cartitem.getProduct_id());
		if(products.getQuantity()>=1)
		{
		if(cartItemDAOImpl.saveCartItem(cartitem))
		{
			//products.setQuantity(products.getQuantity()-1);
			//productsDAOImpl.updateProduct(products);
			logger.info("---cartitem info is saved in db-----");
			
		}
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
//		Products products=productsDAOImpl.viewProductById(cartitem.getProduct_id());
//			products.setQuantity(products.getQuantity()+1);
//			productsDAOImpl.updateProduct(products);
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

	
	  public List<CartItem> viewCartItemsByUserService(String user_name)
	  {
		  
		  logger.info("-----------inside viewcartitemsbyuser service-------");
		  List<CartItem> list=null;
		  list=cartItemDAOImpl.viewCartItemsByUser(user_name);
		  logger.info("---showing all the items by username-------");
		  return list;
	  }
	
	  public float getTotalPriceService(List<CartItem> cartitems,String user_name)
	  {
		  logger.info("----inside total price---------");
		  float totalprice=0l;
		  totalprice=cartItemDAOImpl.getTotalPrice(cartitems, user_name);
		  logger.info("-------total price obtained-----"+totalprice);
		  return totalprice;
		  
		  
	  }
	  
	 
}
