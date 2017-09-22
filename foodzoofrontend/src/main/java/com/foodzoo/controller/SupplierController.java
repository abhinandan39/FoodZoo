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

import com.avizva.model.Suppliers;
import com.avizva.service.SupplierService;
import com.avizva.service.UserService;
/**
 * @author Priyanshi.Tiwari
 * @Controller it indicates that the class that is annotated is a controller.
 *             SupplierController class is a controller which is used for
 *             managing the actions regarding manageproduct.jsp. It is used to
 *             call the service methods of SupplierService which will be
 *             further connected to SupplierDAO.
 *
 */



@Controller
public class SupplierController {
	
	
	/**
	 * @Autowired for auto wiring the beans. 1.serviceDao is an instance of
	 *            class ServiceDAO to call the methods of this class
	 *            2.categoryServiceDao is an instance of class
	 *            CategoryServiceDAO to call the methods of this class
	 */

	
	@Autowired
	UserService serviceDao;

	@Autowired
	SupplierService supplierServiceDao;

	/**
	 * logger is used to print the logs on console. It is an instance of class
	 * Logger.
	 * 
	 */
	
	
	 Logger logger = Logger.getLogger(MyController.class);
	
	 /**
		 * callsupplier method is used to show the supplier list on
		 * managesupplier.jsp file and It will be called on the action
		 * manageSupplier.On successful completion of this method a list of existing
		 * suppliers will be shown on managesuppliers.jsp file. for viewing the
		 * supplier list it will call the respective viewSupplierService method
		 * which is linked to viewSupplierDAO method of SupplierDAO class.That
		 * method will return respective list.These lists will be added with the
		 * view object and sent to the view returned by this method.
		 * 
		 * @return ModelAndView object(JSP File-view)
		 */

	
	 @RequestMapping("/manageSupplier")
	   public ModelAndView callsupplier(@ModelAttribute Suppliers suppliers)
	   {
		   List<Suppliers> list=new ArrayList<Suppliers>();

		     list= supplierServiceDao.viewSupplierService(suppliers);
		     if(!list.isEmpty())
		     return new ModelAndView("managesuppliers","command",new Suppliers()).addObject("list",list);
		     else
		    	 return new ModelAndView("managesuppliers","command",new Suppliers());
	   }
	 
	 
	 
	 /**
		 * saveSupplier method is used to save the Supplier object obtained from
		 * managesupplier.jsp file and It will be called on the action
		 * savesupplier.On successful completion of this method Supplier data will
		 * be saved into database In this method saveSupplierService method of class
		 * SupplierServiceDAO will be called which will further call save method of
		 * SupplierDAO class.
		 * 
		 * @param newsupplier
		 *            is an object of class Supplier.This Object is binded with data
		 *            sent by the form.
		 * @param result
		 *            is an object of class BindingResult which is used to check
		 *            errors in the binding of form data to the object.
		 * @return ModelAndView Object
		 */
	 
	 	 
	 @RequestMapping("/savesupplier")
		public ModelAndView saveSupplier(@ModelAttribute Suppliers suppliers)
		{
			     if(supplierServiceDao.saveSupplierService(suppliers))
			     return new ModelAndView("redirect:/manageSupplier").addObject("msg","data is saved");
			     else
				     return new ModelAndView("redirect:/manageSupplier").addObject("msg","data is not saved");
	 
	    }
	 
	 
	 /**
		 * delete method is used to delete the Supplier by the id obtained from
		 * managesupplier.jsp file path variable and It will be called on the action
		 * /supplierdelete/{id}.On successful completion of this method Supplier data
		 * will be deleted from database In this method viewSupplierByIdService
		 * method of class SupplierServiceDAO will be called.which will further call
		 * viewSupplierById method of SupplierDAO class.It will return the
		 * particular id supplier and this supplier will be deleted by calling
		 * method deleteSupplierService of SupplierServiceDAO. which will call
		 * deleteSupplier method of SupplierDAO class.
		 * 
		 * @param id
		 *            id of the supplier to be deleted
		 * @return ModelAndView Object
		 */

	 
		@RequestMapping("/supplierdelete/{id}")
		public ModelAndView deletesup(@PathVariable String id) {
		     Suppliers suppliers=supplierServiceDao.viewSupplierByIdService(id);
			if (supplierServiceDao.deleteSupplierService(suppliers)) {
				return new ModelAndView("redirect:/manageSupplier");
			} else {

				return new ModelAndView("manageSupplier", "msg", "data not deleted");
			}

	     }


		
		
		/**
		 * supplierupdate method is used to update the supplier object obtained from
		 * managesupplier.jsp file and It will be called on the action
		 * supplierupdate.On successful completion of this method Supplier data will
		 * be updated into database In this method updateSupplierService method of
		 * class SupplierServiceDAO will be called which will further call update
		 * method of SupplierDAO class.
		 * 
		 * @param updatedsupplier
		 *            is an object of class Supplier.This Object is binded with data
		 *            sent by the form.
		 * @return ModelAndView Object
		 */	
	
		@RequestMapping("/supplierupdate")
		public ModelAndView supplierupdate(@ModelAttribute Suppliers suppliers) {
		supplierServiceDao.updateSupplierService(suppliers);
		return new ModelAndView("redirect:/manageSupplier");

	}


}
