package com.foodzoo.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.CartItem;
import com.avizva.model.Payment;
import com.avizva.model.ShippingAddress;
import com.avizva.model.UserOrder;
import com.avizva.service.CartItemService;

import com.avizva.service.CategoryServiceImpl;
import com.avizva.service.PaymentService;
import com.avizva.service.ShippingAddressService;
import com.avizva.service.UserOrderService;

@Controller
public class PaymentController {
	
	Logger logger=Logger.getLogger(PaymentController.class);
	
	@Autowired
	PaymentService paymentService;
	@Autowired
	UserOrderService userOrderService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	ShippingAddressService addressService;
	
	@RequestMapping("/paymentMode")
	public ModelAndView callPaymentMethod()
	{
		logger.info("----calling paymentmethod-----");
		return new ModelAndView("paymentmethod");
		
	}

	
	@RequestMapping("/paynow")
	public ModelAndView callpaynow(@Valid @ModelAttribute Payment newpayment
			, BindingResult result, HttpServletRequest request)
	{
		logger.info("----calling paynowmethod-----");
		
		if(result.hasErrors())
		{
			logger.info("--binding has errors---");
		}
		if(paymentService.savePaymentService(newpayment))
			
		{
			logger.info("----Getting Username from session-----");
			HttpSession session = request.getSession();
			String username = (String)session.getAttribute("sessionusername");
			String orderName = username;
			
			
			logger.info("----Generating A random orderName-----");
			
			Random randomGenerator = new Random();
			for(int i=0;i <10;i++){
				orderName +=  randomGenerator.nextInt(10);
			}
			logger.info("----Generated A random orderName-----"+orderName);
			logger.info("----Getting Address-----"+orderName);
			
			ShippingAddress address = addressService.viewAddress(username);
			UserOrder userOrder = new UserOrder();
			
			logger.info("----Getting List Of CartItems for that user-----");
			List<CartItem> cartList = cartItemService.viewCartItemsByUserService(username);
			
			
			logger.info("----Setting Data to UserOrder-----");
			userOrder.setOrderNumber(orderName);
			userOrder.setUsername(username);
			userOrder.setAddress(address);
			userOrder.setPaymentMode(newpayment.getMode());
			userOrder.setCartList(cartList);
			logger.info("----Saving User Order-----");
			userOrderService.saveOrderService(userOrder);
			logger.info("----Saved User Order-----");
			logger.info("----Deleting Items From user's cart-----");
			for(CartItem c : cartList){
				c.setStatus("false");
				cartItemService.updateCartItemService(c, username);
			}
			
			
			return new ModelAndView("redirect:/orderView?ordername="+orderName);

		}
		else
			return new ModelAndView("paymentmethod").addObject("msg","payment not done");

			
	}
	
}
