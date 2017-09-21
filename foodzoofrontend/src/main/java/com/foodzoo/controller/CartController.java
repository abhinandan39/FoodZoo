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
import com.avizva.service.CategoryService;
import com.avizva.service.ProductService;
import com.avizva.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	UserService serviceDao;
	@Autowired
	ProductService productServiceDao;
	@Autowired
	CategoryService categoryServiceDao;
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
		
		
		
		
		if(username != null){				
			CartItem item = cartItemService.viewCartItemByProductIdAndUser(id,username);
			if(item!=null){
				cartItem.setUser_name(username);
				cartItem.setCart_item_id(item.getCart_item_id());
				cartItem.setCartitem_quantity(item.getCartitem_quantity()+1);
				boolean checkUpdate = cartItemService.updateCartItemService(cartItem,username);
				if(checkUpdate){
					
					
				}
				else{
					String category_name = product.getCategory_name();
					List<Products> productList = productServiceDao.viewProductsService();
					Gson gSon = new GsonBuilder().create();
					logger.info(productList);
					String products = gSon.toJson(productList);
					return new ModelAndView("redirect:/viewCart?checkUpdate=false");
				}

				
			}
			else{
				cartItem.setUser_name(username);
				cartItem.setCartitem_quantity(quantity);
				cartItemService.saveCartItemService(cartItem);
			}
			
			return new ModelAndView("redirect:/viewCart?checkUpdate=true");
		}
		else{
			
			session.setAttribute("product_id", id);
			session.setAttribute("loginCheck", "false");
			session.setAttribute("cartItem", cartItem);
			session.setAttribute("quantity", 1);
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
		
		
		if(username != null){				
			CartItem item = cartItemService.viewCartItemByProductIdAndUser(product_id,username);
			if(item!=null){
				cartItem.setUser_name(username);
				cartItem.setCart_item_id(item.getCart_item_id());
				cartItem.setCartitem_quantity(item.getCartitem_quantity()+quantity);
				boolean checkUpdate = cartItemService.updateCartItemService(cartItem,username);
				if(checkUpdate){
				}
				else{
					String category_name = product.getCategory_name();
					List<Products> productList = productServiceDao.productByCategoryService(category_name);
					Gson gSon = new GsonBuilder().create();
					logger.info(productList);
					String products = gSon.toJson(productList);
					return new ModelAndView("redirect:/viewCart?checkUpdate=false");
				}
			}
			else{
				cartItem.setUser_name(username);
				cartItem.setCartitem_quantity(quantity);
				cartItemService.saveCartItemService(cartItem);
			}
			
			return new ModelAndView("redirect:/viewCart?checkUpdate=true");
		}
		else{
			
			session.setAttribute("product_id", product_id);
			session.setAttribute("loginCheck", "false");
			session.setAttribute("cartItem", cartItem);
			session.setAttribute("quantity", quantity);
			return new ModelAndView("login");
			
		}
		
		
	}
	
	@RequestMapping("/viewCart")
	public ModelAndView viewCart(@RequestParam(value="checkUpdate",required=false) String checkUpdate , HttpServletRequest request){
			
			HttpSession session = request.getSession();
			String user_name = (String)session.getAttribute("sessionusername");
			CartItem cartItem = null;
			List<Products> productList = cartItemService.getAllProductsInCart(user_name);
			List<Integer> productQuantity = new ArrayList<Integer>();
			for(Products p : productList){
				productQuantity.add(cartItemService.viewCartItemByProductIdAndUser((p.getProduct_id()),user_name).getCartitem_quantity());
			}
			
			Float total = cartItemService.totalPriceService(user_name);
			System.out.println("TOTAL IS: "+total);
			Gson gSon = new Gson();
			String productItems = gSon.toJson(productList);
			String quantity = gSon.toJson(productQuantity);
			String totalAmount = gSon.toJson(total);
			return new ModelAndView("cartPage").addObject("quantity",quantity)
					.addObject("productList", productItems).addObject("total",totalAmount)
					.addObject("checkUpdate",checkUpdate);
	}
	
	@RequestMapping("/deleteItem")
	public ModelAndView delete(@RequestParam("id") String id, HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("sessionusername");
		CartItem cartItem = cartItemService.viewCartItemByProductIdAndUser(id,username);
		cartItemService.deleteCartItemService(cartItem);
		return new ModelAndView("redirect:/viewCart");
	}
	
	@RequestMapping("/updateItem")
	public ModelAndView updateCart(@RequestParam("id") String id
			, @RequestParam("updatedValue") String updated, HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("sessionusername");
		CartItem cartItem = cartItemService.viewCartItemByProductIdAndUser(id,username);
		System.out.println(cartItem);
		int updatedValue = Integer.parseInt(updated);
		System.out.println(cartItem.getCartitem_quantity());
		System.out.println(updatedValue);
		cartItem.setCartitem_quantity(updatedValue);
		System.out.println(cartItem.getCartitem_quantity());
		boolean checkUpdate = cartItemService.updateCartItemService(cartItem, username);
		if(checkUpdate){
			return new ModelAndView("redirect:/viewCart?checkUpdate=true");
		}
		else{
			session.setAttribute("checkUpdate", "false");
			return new ModelAndView("redirect:/viewCart?checkUpdate=false");
		}
		
	}
	
	

}
