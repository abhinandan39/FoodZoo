package com.avizva.dao;

import java.util.List;

import com.avizva.model.Suppliers;

public interface SupplierDAO {
	/**
	 * saveSupplier method called for saving the supplier data .This method
	 * will get the control from the service method not from the controller directly.
	 * @param category:object of class Suppliers contains data of suppliers
	 * @return true or false
	 */
	public boolean saveSupplier(Suppliers supplier);
	/**
	 * updateSuppliers method called to update the data of already existing supplier.This method
	 * will get the control from the service method not from the controller directly.
	 * @param category  :object of class Suppliers contains data of Suppliers
	 * @return true or false
	 */
	public boolean updateSupplier(Suppliers supplier);
	/**
	 * deleteSupplier method called to delete the data of supplier.This method 
	 * will get the control from service method not from the controller directly
	 * @param supplier's object
	 * @return true or false
	 */
	public boolean deleteSupplier(Suppliers supplier);
	/**
	 * viewSupplierById method called to view a particular supplier by its id.
	 * This method will get the control from service method not from the controller directly
	 * @param supplier_id
	 * @return return supplier object with the supplier info
	 */
	public Suppliers viewSupplierById(String supplier_id);
	/**
	 * viewSupplier method called to view all the suppliers present in the database.
	 * this method will get the control from service method not from controller directly
	 * @param suppliers's object
	 * @return list of suppliers
	 */
	public List<Suppliers> viewSupplier(Suppliers supplier);

}
