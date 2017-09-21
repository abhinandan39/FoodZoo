package com.avizva.dao;

import com.avizva.model.Payment;

public interface PaymentDAO {
	
	public boolean savePayment(Payment newpayment);

	public Payment viewPayment(String id);
}
