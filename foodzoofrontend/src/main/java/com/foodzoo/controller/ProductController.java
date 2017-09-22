package com.foodzoo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Categories;
import com.avizva.model.Products;
import com.avizva.model.Suppliers;
import com.avizva.service.CategoryService;
import com.avizva.service.ProductService;
import com.avizva.service.UserService;
import com.avizva.service.SupplierService;
/**
 * 
 * @author Priyanshi.Tiwari
 * @Controller it indicates that the class that is annotated is a controller.
 * ProductController class is a controller which is used for managing the actions
 * regarding manageproduct.jsp. It is used to call the service methods of ProductService
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
	UserService serviceDao;
	@Autowired
	ProductService productServiceDao;
	@Autowired
	CategoryService categoryServiceDao;
	@Autowired
	SupplierService supplierServiceDao;
	

	/**
	 * logger is used to print the logs on console. It is an instance of class Logger.
	 * 
	 */
	
	Logger logger=Logger.getLogger(MyController.class);
	private ModelAndView image;
	
	
	
	
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
	 * productupdate method is used to update the product object obtained from manageproducts.jsp file and It will be called
	 * on the action updateproduct.On successful completion of this method Product data will be updated into database
	 * In this method updateProductService method  of class ProductServiceDAO will be called which will further call update
	 * method of ProductDAO class.
	 * @param newproduct is an object of class Products.This Object is binded with data sent by the form.
	 * @param result is an object of class BindingResult which is used to check errors in the binding of form data to the object.
	 * @return ModelAndView Object 
	 */
	
		
	@RequestMapping("/updateproduct")
	public ModelAndView productupdate(@ModelAttribute Products newproduct)
	{
		logger.info("-----inside productupdate--------");
		productServiceDao.updateProductService(newproduct);
		logger.info("-------product updated successfully------");
		return new ModelAndView("redirect:/manageProduct");
		
	}
	/**
	 * saveproducts method is used to save the product object obtained from manageproducts.jsp file and It will be called
	 * on the action saveproduct.On successful completion of this method Product data will be saved into database
	 * In this method saveProductService method  of class ProductServiceDAO will be called which will further call save
	 * method of ProductDAO class.
	 * @param newproduct is an object of class Products.This Object is binded with data sent by the form.
	 * @param result is an object of class BindingResult which is used to check errors in the binding of form data to the object.
	 * @return ModelAndView Object 
	 */
	
		
	@RequestMapping(value="/saveproduct", method=RequestMethod.POST)
	 public ModelAndView saveproducts(@Valid @ModelAttribute Products newproduct,@RequestParam("file") MultipartFile image, BindingResult result)
	{
	 logger.info("--------"+newproduct+"---------------");
	 
	 logger.info("----inside saveproduct------");
	 String imgpath="/Users/Priyanshi.Tiwari/Desktop/FoodzooUp/ImageUpload/";
	 String file_info=imgpath+newproduct.getProduct_id()+".jpg";
	 
	 File f=new File(file_info);
	 if(!image.isEmpty()){
	 try{
	 byte buff[]=image.getBytes();
	 BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
	 bs.write(buff);
	 bs.close();
	 }
	 catch(Exception e){
	 logger.info("Exception");
	 }
	 }
	 logger.info("--------"+newproduct+"---------------");
	if(result.hasErrors())
	 {
	 logger.info("---------error in binding---------");
	 return new ModelAndView("manageproducts");
	 }
	 //newproduct.getImage_file();
	 logger.info("------------inside saveproduct method-----------");
	 if(productServiceDao.saveProductService(newproduct))
	 {
	 logger.info("--------saveproduct method call complete data is saved----------");
	 return new ModelAndView("redirect:/manageProduct");
	 }
	 else
	 {
	 logger.info("--------saveproduct method call is not completed data is not saved----------");
	 
	 return new ModelAndView("manageproducts").addObject("msg","data is not saved");
	 }
	 }
	
	/**
	 * deleteproduct method is used to delete the product by the id obtained from manageproducts.jsp file path variable and It will be called
	 * on the action /productdelete/{id}.On successful completion of this method Product data will be deleted from database
	 * In this method viewProductByIdService method  of class ProductServiceDAO will be called.which will further call viewProductById
	 * method of ProductDAO class.It will return the particular id product and this product will be deleted by calling method deleteProductService of ProductServiceDAO.
	 * which will call deleteProduct method of ProductDAO class.
	 * @param id id of the product to be deleted
	 * @return ModelAndView Object 
	 */
	
	
	@RequestMapping("/productdelete/{id}")
	public ModelAndView deleteproduct(@PathVariable String id) {
		logger.info("-----inside deleteproduct method----------");
	     Products products=productServiceDao.viewProductByIdService(id);
	     
	     logger.info("-----product is-----"+products);
		if (productServiceDao.deleteProductService(products)) 
		{
			logger.info("--------deleteproduct service is called and product is deleted-------");
			return new ModelAndView("redirect:/manageProduct");
		} else {

			logger.info("--------error: product is not deleted-------");
			return new ModelAndView("manageProduct", "msg", "data not deleted");
		}

	}
	
	
}
