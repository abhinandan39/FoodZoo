package com.avizva.service;

import com.avizva.model.Payment;
/**
 * 
 * @author Parul.Sharma
 * PaymentService inteface implemeented by paymentserviceimpl class
 *
 */
public interface PaymentService {
/**
 * savePaymentService method to save the payment mode selected by user
 * @param newpayment
 * @return true or false
 */
	public boolean savePaymentService(Payment newpayment);
	
	public Payment viewPaymentService(String id);
}
