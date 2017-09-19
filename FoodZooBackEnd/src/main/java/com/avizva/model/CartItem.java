package com.avizva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;


@Component
@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cart_item_id;
	
	@NotEmpty
	private String product_id;
	
	@NotEmpty
	private String user_name;
	
	@NotEmpty
	private float price;
	
	@NotEmpty
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
