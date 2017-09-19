package com.avizva.dao;

import java.util.List;

import com.avizva.model.Categories;

public interface CategoryDAO {
	
	/**
	 * saveCategory method called for saving the category data .This method
	 * will get the control from the service method not from the controller directly.
	 * @param category:object of class Categories contains data of categories
	 * @return true or false
	 */
	public boolean saveCategory(Categories category);
	/**
	 * updateCategory method called to update the data of already existing category.This method
	 * will get the control from the service method not from the controller directly.
	 * @param category  :object of class Categories contains data of Categories
	 * @return true or false
	 */
	public boolean updateCategory(Categories category);
	/**
	 * deleteCategory method called to delete the data of category.This method 
	 * will get the control from service method not from the controller directly
	 * @param category
	 * @return true or false
	 */
	public boolean deleteCategory(Categories category );
	/**
	 * viewCategryById method called to view a particular category by its id.
	 * This method will get the control from service method not from the controller directly
	 * @param category_id
	 * @return return category object with the category info
	 */
	public Categories viewCategoryById(String category_id);
	
//	public Categories viewCategoryByName(String category_name);
	/**
	 * viewCategory method called to view all the categories present in the database.
	 * this method will get the control from service method not from controller directly
	 * @param category
	 * @return list of categories
	 */
	public List<Categories> viewCategory(Categories category);
	

}
