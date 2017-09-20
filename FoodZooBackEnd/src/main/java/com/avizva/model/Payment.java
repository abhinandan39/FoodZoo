package com.avizva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Payment {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentid;
	
	
	private String mode;
	
	
	@Size(min=0,max=16)
	private String cardnumber;
	

	private String nameoncard;
	
	
	@Size(min=0,max=3)
	private String cvv;

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", mode=" + mode + ", cardnumber=" + cardnumber + ", nameoncard="
				+ nameoncard + ", cvv=" + cvv + "]";
	}
	
	
	

}
