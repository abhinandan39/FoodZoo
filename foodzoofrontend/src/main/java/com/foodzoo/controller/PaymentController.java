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
import com.avizva.service.CategoryServiceDaoImpl;
import com.avizva.service.PaymentService;

@Controller
public class PaymentController {
	
	Logger logger=Logger.getLogger(PaymentController.class);
	
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("/paymentMode")
	public ModelAndView callPaymentMethod()
	{
		logger.info("----calling paymentmethod-----");
		return new ModelAndView("paymentmethod");
		
	}

	
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
			
			return new ModelAndView("orderView").addObject("msg","payment done");

		}
		else
			return new ModelAndView("paymentmethod").addObject("msg","payment not done");

		
		
		
		
		
		
		
	}
	
}
