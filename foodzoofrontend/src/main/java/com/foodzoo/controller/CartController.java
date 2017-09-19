package com.foodzoo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Products;
import com.avizva.service.CategoryServiceDAO;
import com.avizva.service.ProductServiceDAO;
import com.avizva.service.ServiceDAO;

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

	/**
	 * logger is used to print the logs on console. It is an instance of class Logger.
	 * 
	 */
	
	Logger logger=Logger.getLogger(CartController.class);
	
	@RequestMapping("/cartClick")
	public ModelAndView viewCart(@RequestParam(value= "id", required = false) String id, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("sessionusername");
		System.out.println("Username: "+username);
		if(username != null){
			Products product = productServiceDao.viewProductByIdService(id);
//			String category = product.getCategory_name();
//			categoryServiceDao.viewCategoryByNameService(category);
			String redirect = "redirect:/singleProduct?id="+id;
			return new ModelAndView("redirect:/viewProducts");
		}
		else{
			System.out.println("Inside If");
			String url  = request.getRequestURI()+"?id="+id;
			System.out.println(url);
			session.setAttribute("product_id", id);
			session.setAttribute("loginCheck", "false");
			session.setAttribute("url", url);
			return new ModelAndView("login");
			
		}
		
		
	}
	
	

}
