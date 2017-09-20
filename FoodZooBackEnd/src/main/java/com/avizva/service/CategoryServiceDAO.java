package com.avizva.service;

import java.util.List;

import com.avizva.model.Categories;

public interface CategoryServiceDAO {

	/**
	 * saveCategoryService method called for saving the category data
	 * @param category 
	 * @return true or false
	 */
	public boolean saveCategoryService(Categories category);
	/**
	 * updateCategoryService method called to update the data of already existing category
	 * @param category
	 * @return true or false
	 */
	public boolean updateCategoryService(Categories category);
	
	/**
	 * deleteCategoryService method called to delete the data of already existing category
	 * @param user
	 * @return true or false
	 */
	public boolean deleteCategoryService(Categories category);
	/**
	 * viewCategoryByIdService method called to view the data of already existing category by category_id
	 * @param category_id
	 * @return category object with the data of category related to that id
	 */
	public Categories viewCategoryByIdService(String category_id);
	
	/**
	 * viewCategoryByNameService method called to view the data of already existing category by category_name
	 * @param category_name
	 * @return
	 */
//	public Categories viewCategoryByNameService(String category_name);

	
	/**
	 * viewCategoryService method called to view all the data of already existing category
	 * @param category
	 * @return list of category
	 */
	public List<Categories> viewCategoryService(Categories category);

}
