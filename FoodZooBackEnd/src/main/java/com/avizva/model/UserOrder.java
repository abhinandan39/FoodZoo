package com.avizva.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

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
	
	@Column(unique=true)
	private String orderNumber;
	
	
	private String paymentMode;
	
	/**
	 * cartList takes the cart item beloging to the particular customer
	 */
	@OneToMany(cascade = CascadeType.ALL)
	private List<CartItem> cartList;
	/**
	 * ShippingAddress object for taking the address of the corresponding customer
	 */
	@OneToOne(cascade = CascadeType.ALL)	
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


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
	
	
}
