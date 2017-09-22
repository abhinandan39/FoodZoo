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
	/**
	 * cartclick action from the productview page along with the product id as a parameter
	 * that means if the user have directly cliked on the cart button then this action will be performed
	 * takes the username from the session and calls viewProductByIdservice method taking id as parameter
	 * that returns the product related to that id 
	 * save the price of that product
	 * intialises the quantity as one by defualt
	 * created empty object of cart item classs and set its product_id and price 
	 * checks if the username if not nulll then calls the viewCartByProductIdAndUser method taking id and username as parameter
	 * that returns the complete item corresponding to that id and usernmae and if that item is not null it set the username,cartitemid and quantity
	 * and calls the update method of cartItemService taking cartitem and usernmae as parameter if that returns false that means quantity have exceeded
	 * makes the chekupdate false and redirect it to viewCart page else if the item is not there it just saves that item into the cart and return to viewcart page with checkupdate true
	 * even if the user is not logged in then it redirects to userlogin page with login check as false
	 * login check if not null then it means it have come from view cart page and will redirect to same page after login
	 * @param id
	 * @param request
	 * @return modelandview object according to the satisfactory condition
	 */
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
//				cartItem.setUser_name(username);
//				cartItem.setCart_item_id(item.getCart_item_id());
				item.setCartitem_quantity(item.getCartitem_quantity()+1);
				boolean checkUpdate = cartItemService.updateCartItemService(item,username);
				if(checkUpdate){
					
					return new ModelAndView("redirect:/viewCart?checkUpdate=true");
					
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
				boolean checkSave = cartItemService.saveCartItemService(cartItem);
				if(checkSave){
					return new ModelAndView("redirect:/viewCart?checkUpdate=true");
				}
				else{
					String category_name = product.getCategory_name();
					List<Products> productList = productServiceDao.productByCategoryService(category_name);
					Gson gSon = new GsonBuilder().create();
					logger.info(productList);
					return new ModelAndView("redirect:/viewCart?checkUpdate=false");
				}
			}
			
			
		}
		else{
			
			session.setAttribute("product_id", id);
			session.setAttribute("loginCheck", "false");
			session.setAttribute("cartItem", cartItem);
			session.setAttribute("quantity", 1);
			return new ModelAndView("login");
			
		}
		
		
	}
	/**
	 * singeCartClick action from the productview page indicates that this method have come from the link on the product card
	 * gets the product id and quantity using request and set the sessionusername
	 * takes the price and parse quantity into int and makes the cartitem empty object and sets its product id and price
	 * checks if the usernmae is not null then call the viewProductByIDService method taking the product id as parameter
	 * that returns the product related to that id
	 * if the item is not null then it sets the username cart_item_id a	nd quantity and calls the updateCartItemService method
	 * if that returns false that means some error has occured or the quantity may exceeded
	 * @param request
	 * @return modelandview object with redirecting page according to the contition
	 */
	@RequestMapping("/singleCartClick")
	public ModelAndView singleProductClick(HttpServletRequest request){
		String product_id = request.getParameter("id");
		String product_quantity = request.getParameter("quantity");
		logger.info("Quantity is: "+product_quantity);
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
				
//				cartItem.setUser_name(username);
//				cartItem.setCart_item_id(item.getCart_item_id());
				item.setCartitem_quantity(item.getCartitem_quantity()+quantity);
				boolean checkUpdate = cartItemService.updateCartItemService(item,username);
				if(checkUpdate){
					return new ModelAndView("redirect:/viewCart?checkUpdate=true");
				}
				else{
					String category_name = product.getCategory_name();
					List<Products> productList = productServiceDao.productByCategoryService(category_name);
					Gson gSon = new GsonBuilder().create();
					logger.info(productList);
					return new ModelAndView("redirect:/viewCart?checkUpdate=false");
				}
			}
			else{
				cartItem.setUser_name(username);
				cartItem.setCartitem_quantity(quantity);
				boolean checkSave = cartItemService.saveCartItemService(cartItem);
				if(checkSave){
					return new ModelAndView("redirect:/viewCart?checkUpdate=true");
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
			
			
		}
		else{
			
			session.setAttribute("product_id", product_id);
			session.setAttribute("loginCheck", "false");
			session.setAttribute("cartItem", cartItem);
			session.setAttribute("quantity", quantity);
			return new ModelAndView("login");
			
		}
		
		
	}
	/**
	 * viewCart action for checking all the items present in the user cart with associated price and quantity
	 * @param checkUpdate
	 * @param request
	 * @return modelandview object with redirecting page according to condition
	 */
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
	/**
	 * deleteItem action from  cartPage for deleting the items from the cart
	 * takes the username from the session 
	 * calls viewCartItemByProductAndUser taking id and username as parameter that returns the item related to that id and usernmae
	 * and then calls deleteCartItemService method taking that cartitem as paramter
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteItem")
	public ModelAndView delete(@RequestParam("id") String id, HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("sessionusername");
		CartItem cartItem = cartItemService.viewCartItemByProductIdAndUser(id,username);
		cartItemService.deleteCartItemService(cartItem);
		return new ModelAndView("redirect:/viewCart");
	}
	/**
	 * updateItem action from cartPage for updating the cart item being its quantity or the price
	 * takes the username from the session calls viewCartItemByProductIdAndUser method taking id and username as parameter
	 * calls  updateCartItemService and check whether updated properlu
	 * if returns true then redirect to viewCart page with checkupdate true
	 * else redirect to viewCart page with checkupdate false
	 * @param id
	 * @param updated
	 * @param request
	 * @return
	 */
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
			return new ModelAndView("redirect:/viewCart?checkUpdate=false");
		}
		
	}
	
	

}
