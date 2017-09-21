package com.avizva.dao;

import java.util.List;

import com.avizva.model.Products;
/**
 * 
 * @author Parul.Sharma
 * ProductsDAO interfacce having functions implemented in ProductsDAOImpl
 *
 */
public interface ProductsDAO {
/**
 * for saving the product mentioned by the admin
 * @param product
 * @return true or false
 * 
 */
	public boolean saveProduct(Products product);
	/**
	 * update product for updating the already existing product
	 * @param product
	 * @return true or false
	 */
	
	public boolean updateProduct(Products product);
	/**
	 * deleteProduct for deleting the alreay existing product
	 * @param product
	 * @return true or false
	 */
	
	public boolean deleteProduct(Products product);
	/**
	 * viewProductById method for viewing the product related to that product id
	 * @param product_id
	 * @return true or false
	 */
	public Products viewProductById(String product_id);
	/**
	 * viewProducts will show all the products present in the database
	 * @return
	 */
	public List<Products> viewProducts();
	/**
	 * productByCategory method that will show the products related to that category only
	 * @param product
	 * @return
	 */
	public List<Products> productByCategory(String product);
	
}
