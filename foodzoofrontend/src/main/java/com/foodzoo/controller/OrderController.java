package com.foodzoo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.CartItem;
import com.avizva.model.Products;
import com.avizva.model.UserOrder;
import com.avizva.service.ProductService;
import com.avizva.service.ShippingAddressService;
import com.avizva.service.UserOrderService;

@Controller
public class OrderController {
	
	@Autowired
	ShippingAddressService shippingAddressService;
	@Autowired
	UserOrderService userOrderService;
	@Autowired
	ProductService productService;
	Logger logger=Logger.getLogger(OrderController.class);
	
	@RequestMapping("/orderView")
	public ModelAndView viewOrder(@RequestParam("ordername") String orderName){
		
		UserOrder order = userOrderService.viewOrderByOrderNameService(orderName);
		List<CartItem> cartList = order.getCartList();
		List<Products> productList = new ArrayList<Products>();
		for(CartItem c : cartList){
			productList.add(productService.viewProductByIdService(c.getProduct_id()));
		}
		
		return new ModelAndView("orderView").addObject("userOrder",order)
				.addObject("cartList",cartList)
				.addObject("productList",productList);
		
	}
}
