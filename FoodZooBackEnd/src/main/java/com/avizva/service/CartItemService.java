package com.avizva.service;

import java.util.List;

import com.avizva.model.CartItem;
import com.avizva.model.Products;
/**
 * cartItemService interface implemented in CartItemServiceImpl class having following methods
 * @author Parul.Sharma
 *
 */
public interface CartItemService {
	
	
	/**
	 * saveCartItem method for saving cart items
	 * takes cartItem model class object as parameter and returns true or false
	 * @param cartitem
	 * @return true or false
	 */
	public boolean saveCartItemService(CartItem cartitem);
	/**
	 * updateCartItem service  mthod for updating already existing cart
	 * @param cartitem
	 * @param username
	 * @return
	 */
	
	public boolean updateCartItemService(CartItem cartitem, String username);
	/**
	 * deleteCartItem Service method for deleting the items present in the cart
	 * @param cartitem
	 * @return
	 */
	public boolean deleteCartItemService(CartItem cartitem);
	/**
	 * viewCartItemByIDservice method for viewing the cart by cart item id
	 * @param cart_item_id
	 * @return
	 */
	public CartItem viewCartItemByIdService(int cart_item_id);
	/**
	 * viewCartItemByProductIdAndUser for view the cart item according to the username and the product id
	 * @param product_id
	 * @param username
	 * @return cartitem object
	 */
	public CartItem viewCartItemByProductIdAndUser(String product_id, String username);
	/**
	 * viewCartItemsService method for viewing all the items present in the cart
	 * @return list of item
	 */
	public List<CartItem> viewCartItemsService();
	
	/**
	 * viewCartItemsByUserService method for viewing the cart by username
	 * what all items are there in the cart of that particular user
	 * @param user_name
	 * @return list of item
	 */
    public List<CartItem> viewCartItemsByUserService(String user_name);
    
	/**
	 * totalPriceService method for calculating the total price
	 * @param user_name
	 * @return price
	 */
	public float totalPriceService(String user_name);
	/**
	 * getAllProductsInCart for getting all the products presnt in the cart of the user
	 * @param username
	 * @return
	 */
	public List<Products> getAllProductsInCart(String username);
	

}
