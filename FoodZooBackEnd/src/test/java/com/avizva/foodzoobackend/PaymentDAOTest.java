package com.avizva.foodzoobackend;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.config.TestContextConfig;
import com.avizva.dao.CartItemDAOImpl;
import com.avizva.dao.PaymentDAOImpl;
import com.avizva.model.CartItem;
import com.avizva.model.Payment;

public class PaymentDAOTest {
	/**
	 * bean is used that is made through annotation
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestContextConfig.class);
	
	
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testSavePayment() is made to test whether the savePayment function is working properly and the data is saved to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
	@Test
	public void testSavePayment()
	{
		Payment payment=new Payment();
		payment.setCardnumber("1234567891234567");
		payment.setCvv("123");
		payment.setMode("card");
		payment.setNameoncard("Parul Sharma");
		payment.setPaymentid(1);
		PaymentDAOImpl paymentDAOImpl=(PaymentDAOImpl) context.getBean("paymentDAOImpl");
		boolean result=paymentDAOImpl.savePayment(payment);
		assertTrue(result);
	}
	

}
