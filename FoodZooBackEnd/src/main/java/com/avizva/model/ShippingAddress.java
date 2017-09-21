package com.avizva.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Parul.Sharma
 * model class for shipping address
 * entity makes the table forthe same class
 * component will make the bean of model class
 * 
 *
 */

@Entity
@Component
public class ShippingAddress {
	
	/**
	 * username is the unique name which is already present in the session if the user is logged in
	 */
	@Id
	private String username;
	/**
	 * address1 is the address that user entered in line 1
	 */
	private String address1;
	/**
	 * fullname is the name that user entered while placing the order
	 */
	private String fullname;
	/**
	 * email of the user
	 */
	private String email;
	/**
	 * address2  is the address on line2
	 */
	private String address2;
	/**
	 * city of the user
	 */
	private String city;
	/**
	 * zipcode of the user address
	 */
	private String zipcode;
	/**
	 * country where user resides in
	 */
	private String country;
	/**
	 * contact of the user
	 */
	private String contact;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	

}
