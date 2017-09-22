package com.avizva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import org.springframework.stereotype.Component;

/**
 * 
 * @author Parul.Sharma
 * entity class for checking the payment method
 * entity will make the table to the corresponding class
 *
 */
@Entity
@Component
public class Payment {
	/**
	 * payment id is auto generated and unique
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentid;
	/**
	 * mode variable is for the mode of payment whether card pr cash
	 */
	private String mode;
	/**
	 * card number is the payment is done by card then this will be used
	 * it will have the card number of the user
	 */
	private String cardnumber;

	
/**
 * name on card specifies the name of the owner of the card which is present on the card
 */
	private String nameoncard;
	
	/**
	 * cvv number mentioned on the back of the card
	 * customer will write cvv in case of card payment
	 */
	
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
