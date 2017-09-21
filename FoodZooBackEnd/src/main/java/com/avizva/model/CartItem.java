package com.avizva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 *  @author Abhinandan.Gupta
 *  @author Priyanshi.Tiwari
 *  @author Parul.Sharma
 *  This CartItem class is a model class for managing cart item related informations.
 */
@Component
@Entity
public class CartItem {
	
	/**
	 * cart_item_id primary key that is the id for cart item
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cart_item_id;
	/**
	 * product id for the product which is being ordered
	 */
	@NotEmpty
	private String product_id;
	/**
	 * username unique name that is already saved in the database
	 */
	@NotEmpty
	private String user_name;
	
	/**
	 * price for the price of the product
	 */
	@NotNull
	private float price;
	/**
	 * cart_item quantity for checking the quantity of the items present in the cart
	 */
	@NotNull
	private int cartitem_quantity;
	
	
		public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCartitem_quantity() {
		return cartitem_quantity;
	}

	public void setCartitem_quantity(int cartitem_quantity) {
		this.cartitem_quantity = cartitem_quantity;
	}

	public int getCart_item_id() {
		return cart_item_id;
	}

	public void setCart_item_id(int cart_item_id) {
		this.cart_item_id = cart_item_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "Cart [cart_item_id=" + cart_item_id + ", product_id=" + product_id + ", user_name=" + user_name + "]";
	}
	

}
