package com.foodzoo.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Payment;
import com.avizva.service.CategoryServiceImpl;
import com.avizva.service.PaymentService;
/**
 * 
 * @author Parul.Sharma
 * controller annotation for making class as controller class
 *
 */
@Controller
public class PaymentController {
	/**
	 * for keeping track of all transactions happened or happening
	 */
	Logger logger=Logger.getLogger(PaymentController.class);
	/**
	 * auotwired annotation for makig use of already existing bean instead of creating new object
	 */
	@Autowired
	PaymentService paymentService;
	/**
	 * paymentmode action to redirect the user to paymentmethod page
	 * @return ModelAndView object with  jsp page
	 */
	@RequestMapping("/paymentMode")
	public ModelAndView callPaymentMethod()
	{
		logger.info("----calling paymentmethod-----");
		return new ModelAndView("paymentmethod");
		
	}
	/**
	 * paynow action that calls callpaynow method 
	 * save the payment mode selected by the user and its related information
	 * @param newpayment
	 * @param result
	 * @return
	 */
	
	@RequestMapping("/paynow")
	public ModelAndView callpaynow(@Valid @ModelAttribute Payment newpayment, BindingResult result)
	{
		
		logger.info("----calling paynowmethod-----");
		if(result.hasErrors())
		{
			logger.info("--binding has errors---");
		}
		if(paymentService.savePaymentService(newpayment))
			
		{
			
			return new ModelAndView("paymentmethod").addObject("msg","payment done");

		}
		else
			return new ModelAndView("paymentmethod").addObject("msg","payment not done");

			
	}
	
}
