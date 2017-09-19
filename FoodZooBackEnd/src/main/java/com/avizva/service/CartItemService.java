package com.avizva.service;

import java.util.List;

import com.avizva.model.CartItem;
public interface CartItemService {
	
	
	
	public boolean saveCartItemService(CartItem cartitem);
	
	public boolean updateCartItemService(CartItem cartitem);
	
	public boolean deleteCartItemService(CartItem cartitem);
	
	public CartItem viewCartItemByIdService(int cart_item_id);
	
	public List<CartItem> viewCartItemsService(CartItem cartitem);

}
