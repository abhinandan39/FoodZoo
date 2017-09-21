package com.foodzoo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.UserOrder;
import com.avizva.service.ShippingAddressService;
import com.avizva.service.UserOrderService;

@Controller
public class OrderController {
	
	@Autowired
	ShippingAddressService shippingAddressService;
	@Autowired
	UserOrderService userOrderService;
	
	Logger logger=Logger.getLogger(OrderController.class);
	
	@RequestMapping("/orderView")
	public ModelAndView viewOrder(@RequestParam("ordername") String orderName){
		
		UserOrder order = userOrderService.viewOrderByOrderNameService(orderName);
		
		return new ModelAndView("orderView").addObject("userOrder",order);
		
	}
}
