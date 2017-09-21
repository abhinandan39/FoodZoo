package com.avizva.service;

import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.CartItemDAOImpl;
import com.avizva.dao.ProductsDAOImpl;
import com.avizva.model.CartItem;
import com.avizva.model.Products;

/**
 * 
 * @author Parul.Sharma
 * service annotation fro creating the class as a service class
 * implements cartitemservice interface and all its methods
 *
 */
@Service
public class CartItemServiceImpl implements CartItemService {
/**
 * keeps the log of all transaction
 */
	Logger logger=Logger.getLogger(CartItemServiceImpl.class);
	/**
	 * autowired annotation will make the use of existing bean instead of creating new object
	 */
	@Autowired
	CartItemDAOImpl cartItemDAOImpl;
	
	@Autowired
	ProductsDAOImpl productsDAOImpl;
	/**
	 * saveCartItemService method for saving the items to the cart
	 * calls the saveCartItem method of cartItemDAOImpl class if that returns true
	 * then this method returns true
	 * else
	 * returns false
	 */
	public boolean saveCartItemService(CartItem cartitem) {
		
		logger.info("----inside service:saveCartItemService method------");

		
			if(cartItemDAOImpl.saveCartItem(cartitem))
			{
				//products.setQuantity(products.getQuantity()-1);
				//productsDAOImpl.updateProduct(products);
				logger.info("---cartitem info is saved in db-----");
				return true;
			}
			
			else{
				
				logger.info("---cartitem info is not saved in db-----");
				return false;
			}
		
		
		
	}
	
	/**
	 * updateCartItemService method wil call productsDAOImpl's viewProductById method first that will return the product object
	 * and the calls the viewcartItemByProductIDAndUser method of cartItemDAOimpl that returns
	 * list of cartitem
	 * if that list id not empty and cartitem quantity is less than the product quantity and product quantity is greater than 1
	 * then it calls cartitemdaoimpl's updatecartitem method takig that cartitem as parameter
	 * and if that returns true then this method returns true else returns false
	 */
	public boolean updateCartItemService(CartItem cartitem, String username) {
	    logger.info("----inside service:upadteCartItemService method------");
		Products products=productsDAOImpl.viewProductById(cartitem.getProduct_id());
		List<CartItem> list = cartItemDAOImpl.viewCartItemByProductIdAndUser(cartitem.getProduct_id(), username);
		if(!list.isEmpty()){
			CartItem item = list.get(0);
			System.out.println(cartitem.getCartitem_quantity());
			if(cartitem.getCartitem_quantity() <= products.getQuantity()  && products.getQuantity()>=1)
			{
			if(cartItemDAOImpl.updateCartItem(cartitem))
			{
				//products.setQuantity(products.getQuantity()-1);
				//productsDAOImpl.updateProduct(products);
				logger.info("---cartitem info is updated in db-----");
				return true;
			}
			
			else{
				
				logger.info("---cartitem info is not updated in db-----");
				return false;
			}
	
			
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	
	/**
	 * deleteCartItemService method that takes complete cartitem object as parameter
	 * it calls cartitemDAOImpl's deletecartitem method
	 *  if that returns true that means that item delete from cart and returns true
	 *  else
	 *  returns false
	 */
	
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

	/**
	 * viewCartItemByIdService for fetching the class items through the cart_item_id
	 * returns the cartitem's object
	 */
	public CartItem viewCartItemByIdService(int cart_item_id) {
		logger.info("----inside service:viewCartItemByIdService method---");
	CartItem cartitem=cartItemDAOImpl.viewCartItemById(cart_item_id);
	logger.info("----show information related to particular cart_item_id---");
		return cartitem;
		
	}
	/**
	 * viewCartItemService method for showing all the items present in the cart
	 * returns the list of items
	 */
	public List<CartItem> viewCartItemsService() {
		logger.info("----inside service:viewCartItemService method----");
		List<CartItem> list=null;
		list=cartItemDAOImpl.viewCartItems();
		logger.info("---showing all the cartitems---");
		return list;
	}

	/**
	 * viewCartItemByUserService method will call acrtItemDAOImpl's ciewCartItemsByUser method that takes the username as parameter
	 * returns the list of items present in the cart of that user
	 * 
	 */
	  public List<CartItem> viewCartItemsByUserService(String user_name)
	  {
		  
		  logger.info("-----------inside viewcartitemsbyuser service-------");
		  List<CartItem> list=null;
		  list=cartItemDAOImpl.viewCartItemsByUser(user_name);
		  logger.info("---showing all the items by username-------");
		  return list;
	  }
	


/**
 * getAllProductsInCart method calls the cartItemDAOImpl's viewCartItemByUser method taking username as parameter
 * returns the list of items present in the cart of user
 */
	public List<Products> getAllProductsInCart(String username) {

		CartItem cartItem = null;
		List<CartItem> listCart = cartItemDAOImpl.viewCartItemsByUser(username);
		List<Products> productList = new ArrayList<Products>();
		for(CartItem c : listCart){
			productList.add(productsDAOImpl.viewProductById((c.getProduct_id())));
		}
		return productList;
	}
/**
 * viewCartItemByProductIdAndUser method takes product_id and username as parameter
 * calls cartItemDAOImpl's viewCartItemByProductIdAndUser method that takes the product_id and usernmae as parameter
 * this method is made if user increases the quantity or the product in cart  without chaning anything
 * it will take the username and the id of that product and fetch the list of the item related to that unique combination
 * returns the firstrow / first element of that list 
 */

	public CartItem viewCartItemByProductIdAndUser(String product_id, String username) {
		
		List<CartItem> cartList = cartItemDAOImpl.viewCartItemByProductIdAndUser(product_id, username);
		logger.info("-----Inside ViewCartItemByProductId");
		if(cartList.isEmpty()){
			return null;
		}
		else{
			return cartList.get(0);
		}
		
		
	}

/**
 * totalPriceService method takes username as parameter and calls  cartItemDAOImpl's viewCartItemsByUser method
 * that returns all the cartitems and then call the getTotalPrice method taking cartitems and username and returns
 * total price
 */
	public float totalPriceService(String user_name) {
		List<CartItem> cartItems = cartItemDAOImpl.viewCartItemsByUser(user_name);
		Float total = cartItemDAOImpl.getTotalPrice(cartItems, user_name);
		return total;
	}


	

	  
	 
}
