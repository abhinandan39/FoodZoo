package com.avizva.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.CategoryDAOImpl;
import com.avizva.model.Categories;

@Service
public class CategoryServiceDaoImpl implements CategoryServiceDAO {
	Logger logger=Logger.getLogger(CategoryServiceDaoImpl.class);

	
	
	@Autowired
	CategoryDAOImpl categoryDAOImpl;

	/**
	 * saveCategoryService method takes the category object as parameter and passes it to categoryDAOImpl's saveCategory method 
	 * if true then data is saved else shows the error
	 * @param category object
	 * @return true or false
	 * 
	 */
	public boolean saveCategoryService(Categories category) {
		
			logger.info("----inside service:saveCategorySerice method------");
			if(categoryDAOImpl.saveCategory(category)){
				logger.info("---Category info is saved in db-----");
				return true;
			}
			else{
				logger.info("---category info is not saved in db-----");
				return false;
			}
			
	}
	
	/**
	 * updateCategoryService method takes the category object as parameter and passes it to categoryDAOImpl's updateCategory method 
	 * if true then data is updated else shows the error
	 * @param category object
	 * @return true or false
	 * 
	 */
	public boolean updateCategoryService(Categories category) {
		    logger.info("----inside service:upadteCategorySerice method------");
			if(categoryDAOImpl.updateCategory(category))
			{
				logger.info("---Category info is updated in db-----");
				return true;
			}
			else{
				
				logger.info("---Category info is not updates in db---");
				return false;
			}
			
		}

	/**
	 * deleteCategoryService method takes the category object as parameter and passes it to categoryDAOImpl's deleteCategory method 
	 * if true then data is deleted else shows the error
	 * @param category object
	 * @return true or false
	 * 
	 */
	public boolean deleteCategoryService(Categories category) {
		logger.info("---inside service:deleteCategoryService method---");
		if(categoryDAOImpl.deleteCategory(category))
		{
			logger.info("----Category info deleted in db---");
			return true;
		}
		else{
			
			logger.info("---Category info not deleted----");
			return false;
		}
		
	}

	/**
	 * viewCategoryByIdService method takes the category id as parameter and passes it to categoryDAOImpl's viewCategoryById method 
	 * if true then shows the data else shows the error
	 * @param category_id
	 * @return true or false
	 * 
	 */
	public Categories viewCategoryByIdService(String category_id) {
		logger.info("----inside service:viewCategoryByIdService method---");
	Categories category=	categoryDAOImpl.viewCategoryById(category_id);
	logger.info("----show information related to particular category_id---");
		return category;
		
	}

	/**
	 * viewCategoryService method takes the category object as parameter and passes it to categoryDAOImpl's viewCategory method 
	 * if true then shows all the existing data else shows the error
	 * @param category object
	 * @return true or false
	 * 
	 */
	public List<Categories> viewCategoryService(Categories category) {
		logger.info("----inside service:viewCategoryService method----");
		List<Categories> list=null;
		list=categoryDAOImpl.viewCategory(category);
		logger.info("---showing all the categories---");
		return list;
	}


}
