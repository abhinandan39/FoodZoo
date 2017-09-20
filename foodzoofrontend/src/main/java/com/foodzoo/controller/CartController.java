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
import com.avizva.service.CartItemService;
import com.avizva.service.CartItemServiceImpl;
import com.avizva.service.CategoryServiceDAO;
import com.avizva.service.ProductServiceDAO;
import com.avizva.service.ServiceDAO;
import com.google.gson.Gson;

/**
 * 
 * @author Abhinandan.Gupta
 * @Controller it indicates that the class that is annotated is a controller.
 * CartController class is a controller which is used for managing the actions
 * regarding cart.jsp. It is used to call the service methods of ProductServiceDAO
 * which will be further connected to ProductDAO.
 *
 */
@Controller
public class CartController {
	
	/**
	 * @Autowired for auto wiring the beans.
	 * 1.serviceDao is an instance of class ServiceDAO to call the methods of this class
	 * 
	 * 2.productServiceDao is an instance of class ProductServiceDAO to call the methods of this class
	 * 
	 * 
	 */
	
	@Autowired
	ServiceDAO serviceDao;
	@Autowired
	ProductServiceDAO productServiceDao;
	@Autowired
	CategoryServiceDAO categoryServiceDao;
	@Autowired
	CartItemService cartItemService;

	/**
	 * logger is used to print the logs on console. It is an instance of class Logger.
	 * 
	 */
	
	Logger logger=Logger.getLogger(CartController.class);
	
	@RequestMapping("/cartClick")
	public ModelAndView clickCart(@RequestParam(value= "id", required = false) String id, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		//Getting Username
		String username = (String)session.getAttribute("sessionusername");
		// Getting All Product Data  
		Products product = productServiceDao.viewProductByIdService(id);
		Float price = product.getPrice();
		int quantity =1;
		
		CartItem cartItem = new CartItem();
		
		cartItem.setProduct_id(id);
		cartItem.setPrice(price);	
		cartItem.setUser_name(username);
		
		
		
		if(username != null){				
			CartItem item = cartItemService.viewCartItemByProductId(id);
			if(item!=null){
				cartItem.setCart_item_id(item.getCart_item_id());
				cartItem.setCartitem_quantity(item.getCartitem_quantity()+1);
				session.setAttribute("databaseMethod", "update");
				boolean check = cartItemService.updateCartItemService(cartItem);
				if(check){
					
				}
				
			}
			else{
				cartItem.setCartitem_quantity(quantity);
				session.setAttribute("databaseMethod", "save");
				cartItemService.saveCartItemService(cartItem);
			}
			
			return new ModelAndView("redirect:/viewCart");
		}
		else{
			CartItem item = cartItemService.viewCartItemByProductId(id);
			if(item!=null){
				cartItem.setCart_item_id(item.getCart_item_id());
				cartItem.setCartitem_quantity(item.getCartitem_quantity()+1);
				session.setAttribute("databaseMethod", "update");
				
			}
			else{
				cartItem.setCartitem_quantity(quantity);
				session.setAttribute("databaseMethod", "save");
				
			}
			session.setAttribute("product_id", id);
			session.setAttribute("loginCheck", "false");
			session.setAttribute("cartItem", cartItem);
			return new ModelAndView("login");
			
		}
		
		
	}
	
	@RequestMapping("/singleCartClick")
	public ModelAndView singleProductClick(HttpServletRequest request){
		String product_id = request.getParameter("id");
		String product_quantity = request.getParameter("quantity");
		HttpSession session = request.getSession();
		//Getting Username
		String username = (String)session.getAttribute("sessionusername");
		// Getting All Product Data  
		Products product = productServiceDao.viewProductByIdService(product_id);
		Float price = product.getPrice();
		int quantity = Integer.parseInt(product_quantity);
		
		CartItem cartItem = new CartItem();
		
		cartItem.setProduct_id(product_id);
		cartItem.setPrice(price);	
		cartItem.setUser_name(username);
		
		
		
		if(username != null){				
			CartItem item = cartItemService.viewCartItemByProductId(product_id);
			if(item!=null){
				cartItem.setCart_item_id(item.getCart_item_id());
				cartItem.setCartitem_quantity(item.getCartitem_quantity()+quantity);
				session.setAttribute("databaseMethod", "update");
				cartItemService.updateCartItemService(cartItem);
			}
			else{
				cartItem.setCartitem_quantity(quantity);
				session.setAttribute("databaseMethod", "save");
				cartItemService.saveCartItemService(cartItem);
			}
			
			return new ModelAndView("redirect:/viewCart");
		}
		else{
			session.setAttribute("product_id", product_id);
			session.setAttribute("loginCheck", "false");
			session.setAttribute("cartItem", cartItem);
			return new ModelAndView("login");
			
		}
		
		
	}
	
	@RequestMapping("/viewCart")
	public ModelAndView viewCart(HttpServletRequest request){
			
			HttpSession session = request.getSession();
			String user_name = (String)session.getAttribute("sessionusername");
			CartItem cartItem = null;
			List<Products> productList = cartItemService.getAllProductsInCart(user_name);
			List<Integer> productQuantity = new ArrayList<Integer>();
			for(Products p : productList){
				productQuantity.add(cartItemService.viewCartItemByProductId((p.getProduct_id())).getCartitem_quantity());
			}
			
			
			System.out.println(user_name);
			Float total = cartItemService.totalPriceService(user_name);
			System.out.println("TOTAL IS: "+total);
			Gson gSon = new Gson();
			String productItems = gSon.toJson(productList);
			String quantity = gSon.toJson(productQuantity);
			String totalAmount = gSon.toJson(total);
			return new ModelAndView("cartPage").addObject("quantity",quantity)
					.addObject("productList", productItems).addObject("total",totalAmount);
	}
	
	@RequestMapping("/deleteItem")
	public ModelAndView delete(@RequestParam("id") String id){
		CartItem cartItem = cartItemService.viewCartItemByProductId(id);
		cartItemService.deleteCartItemService(cartItem);
		return new ModelAndView("redirect:/viewCart");
	}
	
	@RequestMapping("/updateItem")
	public ModelAndView updateCart(@RequestParam("id") String id, @RequestParam("updatedValue") String updated){
		CartItem cartItem = cartItemService.viewCartItemByProductId(id);
		System.out.println(cartItem);
		int updatedValue = Integer.parseInt(updated);
		System.out.println(cartItem.getCartitem_quantity());
		System.out.println(updatedValue);
		cartItem.setCartitem_quantity(updatedValue);
		System.out.println(cartItem.getCartitem_quantity());
		cartItemService.updateCartItemService(cartItem);
		return new ModelAndView("redirect:/viewCart");
	}
	
	

}
