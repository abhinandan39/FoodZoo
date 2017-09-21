package com.avizva.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.ProductsDAOImpl;
import com.avizva.model.Products;

@Service
public class ProductServiceImpl implements ProductService {
	
	Logger logger=Logger.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductsDAOImpl productDaoImpl;

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

	public Products viewProductByIdService(String product_id) {

		logger.info("----inside service:viewProductByIdService method---");
		Products product =	productDaoImpl.viewProductById(product_id);
		logger.info("----show information related to particular product_id---");
			return product;
	}

	public List<Products> viewProductsService() {
		
		logger.info("----inside service:viewProductsService method----");
		List<Products> list=null;
		list= productDaoImpl.viewProducts();
		logger.info("---showing all the Products---");
		return list;
	
	}

	public List<Products> productByCategoryService(String category) {
		
		logger.info("----inside service:productByCategoryService method----");
		List<Products> list=null;
		list = productDaoImpl.productByCategory(category);
		logger.info("---showing all the Products In this Category---");
		return list;
	}

	
}
