package com.foodzoo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Categories;
import com.avizva.service.CategoryServiceDAO;
import com.avizva.service.ServiceDAO;
/**
 * @author Priyanshi.Tiwari
 * @Controller it indicates that the class that is annotated is a controller.
 * ProductController class is a controller which is used for managing the actions
 * regarding manageproduct.jsp. It is used to call the service methods of ProductServiceDAO
 * which will be further connected to ProductDAO.
 * 
 */
@Controller
public class CategoryController {
	
		/**
		 * @Autowired for auto wiring the beans.
		 * 1.serviceDao is an instance of class ServiceDAO to call the methods of this class
		 * 2.categoryServiceDao is an instance of class CategoryServiceDAO to call the methods of this class
		*/
	
	
		@Autowired
		ServiceDAO serviceDao;
	
		@Autowired
		CategoryServiceDAO categoryServiceDao;

		/**
		 * logger is used to print the logs on console. It is an instance of class Logger.
		 * 
		 */
	
	   Logger logger=Logger.getLogger(MyController.class);
	  
	   
	   
	   /**
		 * callcategory method is used to show the category list on managecategory.jsp file and It will be called
		 * on the action manageCategory.On successful completion of this method a list of existing categories
		 * will be shown on managecategory.jsp file. for viewing the category list it will call the respective
		 * viewCategoryService method which is linked to viewCategoryDAO method of CategoryDAO class.That method 
		 * will return respective list.These lists will be added with the view object and sent to the view returned by this method.
		 * @return ModelAndView object(JSP File-view)
		 */
	   
	   
	   @RequestMapping("/manageCategory")
	   public ModelAndView callcategory(@ModelAttribute Categories category)
	   {
		   logger.info("-------------inside managecategory-------");
		   List<Categories> list=new ArrayList<Categories>();

		     list= categoryServiceDao.viewCategoryService(category);
		     logger.info("------list obtained is------"+list);
		     if(!list.isEmpty())
		     {
		    	 
		     return new ModelAndView("managecategory","command",new Categories()).addObject("list",list);
		     }
		     else
		     {
		    	 logger.info("-----managecategory call failed-----");
		    	 return new ModelAndView("managecategory","command",new Categories());
		     }
		        
		  }
	   
	   
	   
	   /**
		 * saveCategory method is used to save the Category object obtained from managecategory.jsp file and It will be called
		 * on the action savecategory.On successful completion of this method Category data will be saved into database
		 * In this method saveCategoryService method  of class CategoryServiceDAO will be called which will further call save
		 * method of CategoryDAO class.
		 * @param newcategory is an object of class Category.This Object is binded with data sent by the form.
		 * @param result is an object of class BindingResult which is used to check errors in the binding of form data to the object.
		 * @return ModelAndView Object 
		 */
	   
	   
	   
	   	@RequestMapping("/savecategory")
		public ModelAndView saveCategory(@ModelAttribute Categories newcategory)
		{
			     if(categoryServiceDao.saveCategoryService(newcategory))
			     return new ModelAndView("redirect:/manageCategory").addObject("msg","data is saved");
			     else
			     {
			    	 logger.info("------save category method is failed-------");
				     return new ModelAndView("redirect:/manageCategory").addObject("msg","data is not saved");
			     }
				     
	    }
	   	
	   	/**
		 * delete method is used to delete the Category by the id obtained from managecategory.jsp file path variable and It will be called
		 * on the action /categorydelete/{id}.On successful completion of this method Product data will be deleted from database
		 * In this method viewCategoryByIdService method  of class CategoryServiceDAO will be called.which will further call viewCategoryById
		 * method of CategoryDAO class.It will return the particular id category and this category will be deleted by calling method deleteCategoryService of CategoryServiceDAO.
		 * which will call deleteCategory method of CategoryDAO class.
		 * @param id   id of the category to be deleted 
		 * @return ModelAndView Object 
		 */
		
		@RequestMapping("/categorydelete/{id}")
		public ModelAndView delete(@PathVariable String id) {
			Categories category=categoryServiceDao.viewCategoryByIdService(id);
			if (categoryServiceDao.deleteCategoryService(category)) {
				
				return new ModelAndView("redirect:/manageCategory");
			} 
			else {
				logger.info("----------category deletion failed-------");
				return new ModelAndView("managecategory", "msg", "data not deleted");
			}

		}

		
		
		/**
		 * categoryupdate method is used to update the category object obtained from managecategory.jsp file and It will be called
		 * on the action categoryupdate.On successful completion of this method Category data will be updated into database
		 * In this method updateCategoryService method  of class CategoryServiceDAO will be called which will further call update
		 * method of CategoryDAO class.
		 * @param updatedcategory is an object of class Category.This Object is binded with data sent by the form.
		 * @return ModelAndView Object 
		 */
		
		
		@RequestMapping("/categoryupdate")
		public ModelAndView categoryupdate(@ModelAttribute Categories updatedcategory)
		{
			categoryServiceDao.updateCategoryService(updatedcategory);
			logger.info("------error:category updated successfully------");
			return new ModelAndView("redirect:/manageCategory");
			
		}

}
