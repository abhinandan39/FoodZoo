package com.foodzoo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.CartItem;
import com.avizva.model.Products;
import com.avizva.model.ShippingAddress;
import com.avizva.model.UserOrder;
import com.avizva.service.CartItemService;
import com.avizva.service.ProductService;
import com.avizva.service.ShippingAddressService;
import com.avizva.service.UserOrderService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class OrderController {
	
	@Autowired
	ShippingAddressService shippingAddressService;
	@Autowired
	UserOrderService userOrderService;
	@Autowired
	ProductService productService;
	@Autowired
	CartItemService cartItemService;
	Logger logger=Logger.getLogger(OrderController.class);
	
	@RequestMapping("/orderView")
	public ModelAndView viewOrder(@RequestParam("ordername") String orderName,
			@RequestParam("total") Float total
			,@RequestParam("msg") String message){
		
		UserOrder order = userOrderService.viewOrderByOrderNameService(orderName);
		ShippingAddress address = shippingAddressService.viewAddress(order.getUsername());
		
		List<CartItem> cartList = order.getCartList();
		List<Products> productList = new ArrayList<Products>();
		for(CartItem c : cartList){
			productList.add(productService.viewProductByIdService(c.getProduct_id()));
		}
		
		
		
		return new ModelAndView("orderView").addObject("userOrder",order)
				.addObject("cartList",cartList)
				.addObject("productList",productList)
				.addObject("address",address)
				.addObject("total",total)
				.addObject("message",message);
		
	}
	
	@RequestMapping("/myOrders")
	public ModelAndView viewMyOrders(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("sessionusername");
		ShippingAddress address = shippingAddressService.viewAddress(username);
		List<UserOrder> userOrders = userOrderService.viewOrdersByUsernameService(username);
		List<List<CartItem>> listofCart = new ArrayList<List<CartItem>>();
		
		for(UserOrder order : userOrders){
			listofCart.add(order.getCartList());
		}
		List<List<Products>> listOfProducts = new ArrayList<List<Products>>();
		for(List<CartItem> lst : listofCart){
			List<Products> products = new ArrayList<Products>();
			for(CartItem c : lst){
				products.add(productService.viewProductByIdService(c.getProduct_id()));
			}
			listOfProducts.add(products);
		}
		Gson gSon = new GsonBuilder().create();
		String orders = gSon.toJson(userOrders);
		String userAddress = gSon.toJson(address);
		String cartList = gSon.toJson(listofCart);
		String productList = gSon.toJson(listOfProducts);
		return new ModelAndView("myOrders")
				.addObject("userOrders",orders)
				.addObject("address",userAddress)
				.addObject("listOfCarts",cartList)
				.addObject("listOfProducts",productList);
	}
}
