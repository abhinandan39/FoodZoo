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
import com.avizva.model.Users;
import com.avizva.service.UserService;

import com.avizva.service.ShippingAddressServiceImpl;

@Controller
public class ShippingAddressController {
	Logger logger = Logger.getLogger(MyController.class);

	@Autowired
	UserService serviceDao;
	@Autowired 
	ShippingAddressServiceImpl shippingAddressService;
	@RequestMapping("/checkout")
	public ModelAndView shippingAddress(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("sessionusername");
	
		if(shippingAddressService.existShippingAddressService(username)){
			ShippingAddress address=shippingAddressService.viewAddress(username);
			logger.info("---user already exists-----");
			return new ModelAndView("ship").addObject("shippingAddress", address);
		}
		else{
			return new ModelAndView("ShippingAddress");
		}
		
		
		
	}
	@RequestMapping("/updateAddress")
	public ModelAndView getUpdate(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("sessionusername");
		ShippingAddress address = shippingAddressService.viewAddress(username);
		System.out.println("Inside profile " + address);
		return new ModelAndView("UpdateAddress", "command", address);
	}
	
	@RequestMapping("/updateaddress")
	public ModelAndView updateUser(@Valid @ModelAttribute ShippingAddress address, BindingResult result) {

		logger.info("--Inside Controller : Update user");

		logger.info("---Checking Hibernate Validity---");

		if (result.hasErrors()) {

			logger.info("---Error in Updating Database ---");
			return new ModelAndView("updatepage", "command", address);
		}

		boolean check = shippingAddressService.updateAddressService(address);
		if (check) {
			logger.info("--- User Updated Successfully ---");
			return new ModelAndView("pay", "msg", "Your details have been updated").addObject("registeractive",
					"active");
		} else {
			return new ModelAndView("ship", "error", "Some error occured");
		}

	}
	
	@RequestMapping("/checkout1")
	public ModelAndView saveShippingAddress(@Valid @ModelAttribute ShippingAddress address, BindingResult result, HttpServletRequest request) {
		logger.info("----inside controller:saveuser method-------");

		
		if (result.hasErrors()) {
			logger.info("---form data is not binded properly-----");
			return new ModelAndView("ShippingAddress").addObject("shippingaddress", "active");
		}
		else{
			
		
				if (shippingAddressService.saveShippingAddressService(address)) {
					logger.info("---calling service:saveservice method---");
		
					HttpSession session1 = request.getSession(false);
					session1.setAttribute("sessionusername", address.getUsername());
				
					logger.info("---registration success-------");
					return new ModelAndView("ship", "msg", "Your shipping address saved  Successfully");
				} else {
					logger.info("-----registration failed------");
					return new ModelAndView("cartPage").addObject("msg", "some error occured ");
							
				}
		}
	}
	
	

}
