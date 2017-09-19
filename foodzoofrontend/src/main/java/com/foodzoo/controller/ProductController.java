package com.foodzoo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Categories;
import com.avizva.model.Products;
import com.avizva.model.Suppliers;
import com.avizva.service.CategoryServiceDAO;
import com.avizva.service.ProductServiceDAO;
import com.avizva.service.ServiceDAO;
import com.avizva.service.SupplierServiceDAO;
/**
 * 
 * @author Priyanshi.Tiwari
 * @Controller it indicates that the class that is annotated is a controller.
 * ProductController class is a controller which is used for managing the actions
 * regarding manageproduct.jsp. It is used to call the service methods of ProductServiceDAO
 * which will be further connected to ProductDAO.
 * 
 */

@Controller
public class ProductController {

	/**
	 * @Autowired for auto wiring the beans.
	 * 1.serviceDao is an instance of class ServiceDAO to call the methods of this class
	 * 2.productServiceDao is an instance of class ProductServiceDAO to call the methods of this class
	 * 
	 * 3.categoryServiceDao is an instance of class CategoryServiceDAO to call the methods of this class
	 * 
	 * 4.supplierServiceDao is an instance of class SupplierServiceDAO to call the methods of this class
	 */
	
	
	@Autowired
	ServiceDAO serviceDao;
	@Autowired
	ProductServiceDAO productServiceDao;
	@Autowired
	CategoryServiceDAO categoryServiceDao;
	@Autowired
	SupplierServiceDAO supplierServiceDao;
	

	/**
	 * logger is used to print the logs on console. It is an instance of class Logger.
	 * 
	 */
	
	Logger logger=Logger.getLogger(MyController.class);
	
	
	
	
	/**
	 * manageproducts method is used to show the product list on manageproducts.jsp file and it 
	 * will also pass the list of categories and suppliers to the same jsp page.It will be called
	 * on the action manageProduct.On successful completion of this method a list of existing products
	 * will be shown on manageproducts.jsp file
	 * for viewing the product list and fetching the category and supplier lists it will call the respective
	 * service methods which are linked to DAO class methods.Those methods will return respective lists.
	 * These lists will be added with the view object and sent to the view returned by this method.
	 * 
	 * 
	 * @return ModelAndView object(JSP File-view)
	 */
	@RequestMapping("/manageProduct")
		public ModelAndView manageproducts()
	{
		logger.info("-------inside manage products---------");
		List<Products> productlist;
		Categories category=null;
		Suppliers supplier=null;
		List<Categories> categorieslist=categoryServiceDao.viewCategoryService(category);
		logger.info("--------category list:----------"+categorieslist);
		List<Suppliers> supplierslist=supplierServiceDao.viewSupplierService(supplier);
		logger.info("--------suppliers list:----------"+supplierslist);
		productlist=productServiceDao.viewProductsService();
		logger.info("--------products list:----------"+productlist);

		return new ModelAndView("manageproducts").addObject("productlist",productlist).addObject("categorieslist",categorieslist).addObject("supplierslist",supplierslist);
	}
	
	
	
	/**
	 * saveproducts method is used to save the product object obtained from manageproducts.jsp file and it 
	 * will also pass the list of categories and suppliers to the same jsp page.It will be called
	 * on the action manageProduct.On successful completion of this method a list of existing products
	 * will be shown on manageproducts.jsp file
	 * for viewing the product list and fetching the category and supplier lists it will call the respective
	 * service methods which are linked to DAO class methods.Those methods will return respective lists.
	 * These lists will be added with the view object and sent to the view returned by this method.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param newproduct is an object of class Products.This Object is binded with data sent by the form.
	 * @param result is an object of class BindingResult which is used to check errors in the binding of form data to the object.
	 * @return ModelAndView Object 
	 */
	
	
	
	
	
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveproducts(@Valid @ModelAttribute Products newproduct,BindingResult result)
	{
		logger.info("--------"+newproduct+"---------------");
		if(result.hasErrors())
		{
			logger.info("---------error in binding---------");
			return new ModelAndView("manageproducts");
		}
		//newproduct.getImage_file();
		logger.info("inside save product");
		if(productServiceDao.saveProductService(newproduct))
		{
			logger.info("inside save product");
			return new ModelAndView("redirect:/manageProduct");
		}
		else
			return new ModelAndView("manageproducts").addObject("msg","data is not saved");
		
	}
	
	@RequestMapping("/updateproduct")
	public ModelAndView productupdate(@ModelAttribute Products newproduct)
	{
		productServiceDao.updateProductService(newproduct);
		
		return new ModelAndView("redirect:/manageProduct");
		
	}
	
	@RequestMapping("/productdelete/{id}")
	public ModelAndView deleteprod(@PathVariable String id) {
	     Products products=productServiceDao.viewProductByIdService(id);
		if (productServiceDao.deleteProductService(products)) {
			return new ModelAndView("redirect:/manageProduct");
		} else {

			return new ModelAndView("manageProduct", "msg", "data not deleted");
		}

	}
	
}
