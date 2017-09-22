package com.avizva.dao;

import java.util.List;

import com.avizva.model.CartItem;
import com.avizva.model.Products;
import com.avizva.model.Users;


public interface CartItemDAO {
	
	
	/**
	 * saveCartItem method called for saving the cartitem data .This method
	 * will get the control from the service method not from the controller directly.
	 * @param cartitem:object of class CartItem contains data of Cartitems.
	 * @return true or false
	 */
	public boolean saveCartItem(CartItem cartitem);
	/**
	 * updateCartItem method called to update the data of already existing cartitem.This method
	 * will get the control from the service method not from the controller directly.
	 * @param cartitem  :object of class CartItem contains data of Cartitems
	 * @return true or false
	 */
	public boolean updateCartItem(CartItem cartitem);
	/**
	 * deleteCartItem method called to delete the data of cartitem.This method 
	 * will get the control from service method not from the controller directly
	 * @param cartitem
	 * @return true or false
	 */
	public boolean deleteCartItem(CartItem cartitem);
	/**
	 * viewCartItemById method called to view a particular cartitem by its id.
	 * This method will get the control from service method not from the controller directly
	 * @param cart_item_id;
	 * @return return cartItem object with the cartitem info
	 */
	public CartItem viewCartItemById(int cart_item_id);
	/**
	 * viewCartItem method called to view all the cartitems present in the database.
	 * this method will get the control from service method not from controller directly
	 * @param cartitem
	 * @return list of CartItem
	 */
	public List<CartItem> viewCartItems();
	
	/**
	 * viewCartItemsByUser method for viewing the cart item corresponding to the username
	 * @param user_name
	 * @return list of cart item
	 */
	public List<CartItem> viewCartItemsByUser(String user_name);
	/**
	 * getTotalPrice method for getting the total price 
	 * @param cartitems
	 * @param user_name
	 * @return total price
	 */
	public float getTotalPrice(List<CartItem> cartitems,String user_name);
	
/**
 * viewCartItemByProductIdAndUser method for showing the cartitem corresponding to the product id and username
 * @param product_id
 * @param username
 * @return list of cartitem
 */
	public List<CartItem> viewCartItemByProductIdAndUser(String product_id, String username);
	

}
