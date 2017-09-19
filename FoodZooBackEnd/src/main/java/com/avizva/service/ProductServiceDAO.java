package com.avizva.service;

import java.util.List;

import com.avizva.model.Products;

public interface ProductServiceDAO {

	public boolean saveProductService(Products product);
	
	public boolean updateProductService(Products product);
	
	public boolean deleteProductService(Products product);
	
	public Products viewProductByIdService(String product_id);
	
	public List<Products> viewProductsService();
	
	public List<Products> productByCategoryService(String category);
}
