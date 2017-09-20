package com.foodzoo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.ShippingAddress;
import com.avizva.service.ServiceDAO;

import com.avizva.service.ShippingAddressServiceImpl;

@Controller
public class ShippingAddressController {
	Logger logger = Logger.getLogger(MyController.class);

	@Autowired
	ServiceDAO serviceDao;
	@Autowired 
	ShippingAddressServiceImpl shippingAddressService;
	
	@RequestMapping("/checkout")
	public ModelAndView saveShippingAddress(@Valid @ModelAttribute ShippingAddress address, BindingResult result, HttpServletRequest request) {
		logger.info("----inside controller:saveuser method-------");

		HttpSession session=request.getSession();
		String username= (String) session.getAttribute("username");
		logger.info("----inside controller, username is " + username);
	
//		if (result.hasErrors()) {
//			logger.info("---form data is not binded properly-----");
//			return new ModelAndView("ShippingAddress").addObject("shippingaddress", "active");
//		}
		if (shippingAddressService.existShippingAddressService(username)) {
			
			ShippingAddress shippingAddress=shippingAddressService.viewUser(username);
			logger.info("---user already exists-----");
			return new ModelAndView("ShippingAddress")
					.addObject("command", shippingAddress);
					
		}
		if (shippingAddressService.saveShippingAddressService(address)) {
			logger.info("---calling service:saveservice method---");

			HttpSession session1 = request.getSession(false);
			session1.setAttribute("sessionusername", address.getUsername());
		
			logger.info("---registration success-------");
			return new ModelAndView("ShippingAddress", "msg", "Your shipping address saved  Successfully");
		} else {
			logger.info("-----registration failed------");
			return new ModelAndView("CartPage").addObject("msg", "some error occured ");
					
		}
	}
	@RequestMapping("/paymentMode")
	public ModelAndView pay(@Valid @ModelAttribute ShippingAddress address, BindingResult result, HttpServletRequest request)
	{
		if (shippingAddressService.saveShippingAddressService(address)) {
			logger.info("---calling service:saveservice method---");

			
		
			logger.info("---registration success-------");
			return new ModelAndView("pay", "msg", "Your shipping address saved  Successfully");
		} else {
			logger.info("-----registration failed------");
			return new ModelAndView("register").addObject("msg", "some error occured ");
					
		}
		
	}

	

}
