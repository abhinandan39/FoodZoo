package com.avizva.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.ProductsDAOImpl;
import com.avizva.model.Products;
/**
 * 
 * @author Parul.Sharma
 * service annotation for making this class as a service class
 *
 */
@Service
public class ProductServiceDAOImpl implements ProductServiceDAO {
	/**
	 * keep the log of all the transactions
	 */
	Logger logger=Logger.getLogger(ProductServiceDAOImpl.class);
	/**
	 * auotiwred annotation for making use of existing bean of this class instead of creating seperate object
	 */
	@Autowired
	ProductsDAOImpl productDaoImpl;
/**
 * saveProductService method that takes product as parameter and it calls productDaoImpl's saveProduct method
 * if that method returns true then this method returns true
 * else false
 */
	public boolean saveProductService(Products product) {

		logger.info("----inside service:saveProductSerice Method------");
		if(productDaoImpl.saveProduct(product)){
			logger.info("---Product info is saved in db-----");
			return true;
		}
		else{
			logger.info("---Product info is not saved in db-----");
			return false;
		}
		
	}
/**
 * updateProductService method for upating the existing product details
 * calls productDaoImpl's updateProduct method if that returns true then this method returns true
 * else false
 */
	public boolean updateProductService(Products product) {

		logger.info("----inside service:updateProductSerice method------");
		if(productDaoImpl.updateProduct(product)){
			logger.info("---Product info is updated in db-----");
			return true;
		}
		else{
			logger.info("---Product info is not updated in db-----");
			return false;
		}
	}
/**
 * deleteProductService method for deleting the existing product in the database
 * calss productDaoImpl's deleteProduct method and if this returns true then deleteProductService returns true
 * else returns false 
 */
	public boolean deleteProductService(Products product) {

		logger.info("---inside service:deleteProductService method---");
		if(productDaoImpl.deleteProduct(product))
		{
			logger.info("----Product info deleted in db---");
			return true;
		}
		else{
			
			logger.info("---Product info not deleted----");
			return false;
		}
	}
/**
 * viewProductByIdService method for showing the product corresponding to the product id
 * calls productDaoImpl's viewProductById method and returns the product
 */
	public Products viewProductByIdService(String product_id) {

		logger.info("----inside service:viewProductByIdService method---");
		Products product =	productDaoImpl.viewProductById(product_id);
		logger.info("----show information related to particular product_id---");
			return product;
	}
/**
 * viewProductsService method for showing all the products in the cart
 * calls productDaoImpl's viewProducts method that returns the list of products present in the database
 * returns list
 */
	public List<Products> viewProductsService() {
		
		logger.info("----inside service:viewProductsService method----");
		List<Products> list=null;
		list= productDaoImpl.viewProducts();
		logger.info("---showing all the Products---");
		return list;
	
	}
/**
 * productByCategoryService method for showing all the products corresponding to the category
 * calls productDaoImpl's productByCategory method that returns the list of product corresponding to the category
 */
	public List<Products> productByCategoryService(String category) {
		
		logger.info("----inside service:productByCategoryService method----");
		List<Products> list=null;
		list = productDaoImpl.productByCategory(category);
		logger.info("---showing all the Products In this Category---");
		return list;
	}

	
}
