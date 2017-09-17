package com.avizva.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.SupplierDAOImpl;
import com.avizva.model.Suppliers;


@Service
public class SupplierServiceDAOImpl implements SupplierServiceDAO{
	
	Logger logger=Logger.getLogger(SupplierServiceDAOImpl.class);
	@Autowired
	SupplierDAOImpl supplierDAOImpl;

	/**
	 * saveSupplierService method takes the supplier object as parameter and passes it to supplierDAOImpl's saveSupplier method 
	 * if true then data is saved else shows the error
	 * @param supplier object
	 * @return true or false
	 * 
	 */
	public boolean saveSupplierService(Suppliers supplier) {
		
			logger.info("----inside service:saveCategorySerice method------");
			if(supplierDAOImpl.saveSupplier(supplier)){
				logger.info("---Category info is saved in db-----");
				return true;
			}
			else{
				logger.info("---category info is not saved in db-----");
				return false;
			}
			
	}
	
	/**
	 * updateSupplierService method takes the supplier object as parameter and passes it to supplierDAOImpl's updateSupplier method 
	 * if true then data is updated else shows the error
	 * @param supplier object
	 * @return true or false
	 * 
	 */
	public boolean updateSupplierService(Suppliers supplier) {
		    logger.info("----inside service:upadteCategorySerice method------");
			if(supplierDAOImpl.updateSupplier(supplier))
			{
				logger.info("---Category info is updated in db-----");
				return true;
			}
			else{
				
				logger.info("---Category info is not updates in db---");
				return false;
			}
			
		}

	/**
	 * deleteSupplierService method takes the supplier object as parameter and passes it to supplierDAOImpl's deleteSupplier method 
	 * if true then data is deleted else shows the error
	 * @param supplier object
	 * @return true or false
	 * 
	 */
	public boolean deleteSupplierService(Suppliers supplier) {
		logger.info("---inside service:deleteCategoryService method---");
		if(supplierDAOImpl.deleteSupplier(supplier))
		{
			logger.info("----Category info deleted in db---");
			return true;
		}
		else{
			
			logger.info("---Category info not deleted----");
			return false;
		}
		
	}

	/**
	 * viewSupplierByIdService method takes the supplier id as parameter and passes it to supplierDAOImpl's viewSupplierById method 
	 * if true then shows the data else shows the error
	 * @param supplier_id
	 * @return true or false
	 * 
	 */
	public Suppliers viewSupplierByIdService(String supplier_id) {
		logger.info("----inside service:viewCategoryByIdService method---");
	Suppliers supplier=	supplierDAOImpl.viewSupplierById(supplier_id);
	logger.info("----show information related to particular category_id---");
		return supplier;
		
	}

	/**
	 * viewSupplierService method takes the supplier object as parameter and passes it to supplierDAOImpl's viewSupplier method 
	 * if true then shows all the existing data else shows the error
	 * @param Suppliers object
	 * @return true or false
	 * 
	 */
	public List<Suppliers> viewSupplierService(Suppliers supplier) {
		logger.info("----inside service:viewCategoryService method----");
		List<Suppliers> list=null;
		list=supplierDAOImpl.viewSupplier(supplier);
		logger.info("---showing all the categories---");
		return list;
	}

	


}
