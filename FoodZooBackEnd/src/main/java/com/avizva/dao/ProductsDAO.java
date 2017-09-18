package com.avizva.dao;

import java.util.List;

import com.avizva.model.Products;

public interface ProductsDAO {

	public boolean saveProduct(Products product);
	
	public boolean updateProduct(Products product);
	
	public boolean deleteProduct(Products product);
	
	public Products viewProductById(String product_id);
	
	public List<Products> viewProducts();
	
}
