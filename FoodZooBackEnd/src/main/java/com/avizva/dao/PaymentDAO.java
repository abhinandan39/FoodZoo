package com.avizva.dao;

import com.avizva.model.Payment;
/**
 * @author Parul.Sharma
 * paymentDAO interface that takes one method ie savePayment
 *
 */
public interface PaymentDAO {
	/**
	 * savePayment method that will save the payment mode ofthe user
	 * @param newpayment
	 * @return
	 */
	public boolean savePayment(Payment newpayment);

	public Payment viewPayment(String id);
}
