package com.avizva.service;

import java.util.List;

import com.avizva.model.Suppliers;


public interface SupplierService {
	
	/**
	 * saveSupplierService method called for saving the supplier data
	 * @param supplier
	 * @return true or false
	 */
	public boolean saveSupplierService(Suppliers supplier);
	/**
	 * updateSupplierService method called to update the data of already existing supplier
	 * @param supplier
	 * @return true or false
	 */
	public boolean updateSupplierService(Suppliers supplier);
	
	/**
	 * deleteSupplierService method called to delete the data of already existing supplier
	 * @param supplier
	 * @return true or false
	 */
	public boolean deleteSupplierService(Suppliers supplier);
	/**
	 * viewSupplierByIdService method called to view the data of already existing supplier by supplier_id
	 * @param supplier_id
	 * @return supplier object with the data of supplier related to that id
	 */
	public Suppliers viewSupplierByIdService(String supplier_id);
	/**
	 * viewSupplierService method called to view all the data of already existing supplier
	 * @param supplier
	 * @return list of supplier
	 */
	public List<Suppliers> viewSupplierService(Suppliers category);


}
