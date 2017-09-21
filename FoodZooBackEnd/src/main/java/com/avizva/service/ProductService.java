package com.avizva.service;

import java.util.List;
/**
 * 
 * @author Parul.Sharma
 * ProductServiceDAO ineterface having following method implemented/executed by ProductServiceDAOImpl class
 *
 */

import com.avizva.model.Products;


public interface ProductService {
/** saveProductService method for saving the product into the database
 * @param product
 * @return true or false
 */
	public boolean saveProductService(Products product);
	/**
	 * updateProductService method for updating the existing product in the database
	 * 
	 * @param product
	 * @return true or false
	 */
	public boolean updateProductService(Products product);
	/**
	 * deleteProductService method for deleting the existing product from the database
	 * @param product
	 * @return true or false
	 */
	public boolean deleteProductService(Products product);
	/**
	 * viewProductByIdService method for showing the product corresponding to the product id
	 * @param product_id
	 * @return true or false
	 */
	public Products viewProductByIdService(String product_id);
	/**
	 * viewProductsService method for showing all the products in the database
	 * @return List of products
	 */
	public List<Products> viewProductsService();
	/**
	 * productByCategoryService method for fetching the product corresponding to the category
	 * @param category
	 * @return lis of products
	 */
	public List<Products> productByCategoryService(String category);
}
