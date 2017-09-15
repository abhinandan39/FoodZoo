package com.avizva.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Component

public class Users {

	
	
	@NotEmpty
	@Pattern(regexp="[^0-9]*")
	@Size(min=3, max=15)
	private String fname;
	@NotEmpty
	@Pattern(regexp="[^0-9]*")
	@Size(min=3, max=15)
	private String lname;
	@NotEmpty
	@Size(min=3, max=25)
	@Id
	private String username;
	@NotEmpty
	@Size(min=6, max=20)
	private String password;
	@NotNull
	@Pattern(regexp="[7-9]{1}[0-9]{9}")
	private String contact;
	
	
	@NotEmpty
	private String email;
	
//	@NotEmpty
//	private String state;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dob;
	
	private String role;
	@Column(name="enabled", columnDefinition="boolean default true", nullable=false)
	private boolean enabled =true;
//	private Address address;
	
	private String securityque;
	
	private String securityans;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getSecurityque() {
		return securityque;
	}
	public void setSecurityque(String securityque) {
		this.securityque = securityque;
	}
	public String getSecurityans() {
		return securityans;
	}
	public void setSecurityans(String securityans) {
		this.securityans = securityans;
	}
	@Override
	public String toString() {
		return "Users [fname=" + fname + ", lname=" + lname + ", username=" + username + ", password=" + password
				+ ", contact=" + contact + ", email=" + email + ", dob=" + dob + ", role=" + role + ", enabled="
				+ enabled + ", securityque=" + securityque + ", securityans=" + securityans + "]";
	}

	
	
	
	

}
