//package com.avizva.model;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//import org.springframework.stereotype.Component;
//
//
//@Component
//@Entity
//public class UserOrder {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int order_id;
//	
//	@OneToMany
//	private List<CartItem> cartList;
//	
//	@OneToOne
//	private Address address;
//	
//	@OneToOne
//	private Payment payment;
//	
//	private String username;
//
//	public int getOrder_id() {
//		return order_id;
//	}
//
//	public void setOrder_id(int order_id) {
//		this.order_id = order_id;
//	}
//
//	public List<CartItem> getCartList() {
//		return cartList;
//	}
//
//	public void setCartList(List<CartItem> cartList) {
//		this.cartList = cartList;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	public Payment getPayment() {
//		return payment;
//	}
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	
//	
//}
