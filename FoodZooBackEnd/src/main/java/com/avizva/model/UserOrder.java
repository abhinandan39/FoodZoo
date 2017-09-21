package com.avizva.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Parul.Sharma
 * model class UserOrder that will take confirm the user order with its corresponding details
 *
 */
@Component
@Entity
public class UserOrder {
/**
 * order id is the unique id for the order placed by the user
 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	/**
	 * cartList takes the cart item beloging to the particular customer
	 */
	@OneToMany
	private List<CartItem> cartList;
	/**
	 * ShippingAddress object for taking the address of the corresponding customer
	 */
	@OneToOne
	private ShippingAddress address;
	/**
	 * payment method that customer opted for
	 */
	@OneToOne
	private Payment payment;
	/**
	 * and the user name the primary key which is already saved in the session
	 */
	private String username;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public List<CartItem> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartItem> cartList) {
		this.cartList = cartList;
	}

	public ShippingAddress getAddress() {
		return address;
	}

	public void setAddress(ShippingAddress address) {
		this.address = address;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
