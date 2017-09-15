package com.avizva.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.avizva.model.Categories;
import com.avizva.service.CategoryServiceDaoImpl;
@Controller
public class CategoryDAOImpl implements CategoryDAO{
	/**
	 * for keeping the log of this class
	 */
	
	Logger logger=Logger.getLogger(CategoryServiceDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * getSession method is used to open/create a session from the auto-wired object of sessionFactory.
	 * @return Session
	 */
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	
	/**
	 * savecategory method gets the category object as parameter from CategoryServiceDAOImpl's saveCategoryService method
	 * and will begin a transaction with the help of current session.During this transaction category data will be saved
	 * using session's save method followed by commitment of transaction and closing of session.
	 * on saving category data successfully it will return true to the CategoryServiceDAOImpl's saveCategoryService method.
	 * or else it returns false
	 * @param user : Object of categories class that contains data of a category for a particular session.
	 * @return true or false
	 * 
	 */
	public boolean saveCategory(Categories category) {
	       logger.info("------inside dao:saveuser method------");
			boolean flag = false;
			Session session = null;
			Transaction transaction = null;
			try {
				session = getSession();
				transaction = session.beginTransaction();
				session.save(category);
				transaction.commit();
				flag = true;		
			} catch (Exception e) {
				logger.error("exception occured:"+ e);
				transaction.rollback();
				
			} finally {
				session.close();
			}

			return flag;

		}

	/**
	 * updateCategory method get the category object from CategoryServiceDAOImpl's updateCategoryService method
	 * and will begin transaction with the help of current session.During this transaction data will be updated
	 * using session's update method followed by commitment of transaction and closing of session
	 * on updating category successfully it will return true to CategoryServiceDAOImpl's updateCategoryService method
	 * or else it returns false
	 * @param category:object of Categories class that contains data of category for a particular session
	 * @return true or false
	 * 
	 */
	public boolean updateCategory(Categories category) {
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();

			session.update(category);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			logger.error("exception occured:"+ e);
			transaction.rollback();
		} finally {
			session.close();

		}
		return flag;
	}

	/**
	 * deleteCategory method get the category object from CategoryServiceDAOImpl's deleteCategoryService method
	 * and will begin transaction with the help of current session.During this transaction data will be deleted
	 * using session's delete method followed by commitment of transaction and closing of session
	 * on deleting category successfully it will return true to CategoryServiceDAOImpl's deleteCategoryService method
	 * or else it returns false
	 * @param category:object of Categories class that contains data of category for a particular session
	 * @return true or false
	 * 
	 */
	public boolean deleteCategory(Categories category) {
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
	transaction = session.beginTransaction();
		session.delete(category);
	transaction.commit();
		flag = true;
	}
		catch(Exception e){
		transaction.rollback();
		}
		finally{
			session.close();
			
		}
		return flag;
	}

	/**
	 * viewCategoryById method get the category_id  from CategoryServiceDAOImpl's viewCategryByIdService method
	 * and will begin transaction with the help of current session.During this transaction, it will show the data related to that
	 * category id
	 * using session's get with parameters passed category class and category id
	 * that will actually function for showing data from class with that id
	 *  method followed by commitment of transaction and closing of session
	 * on showing category successfully it will return true to CategoryServiceDAOImpl's viewCategoryByIdService method
	 * or else it returns false
	 * @param category_id:parameter category_id of Categories class that contains data of category for a particular session
	 * @return true or false
	 * 
	 */
	public Categories viewCategoryById(String category_id) {
		Session session = getSession();
		Categories category= session.get(Categories.class, category_id);
		session.close();
		return category;
	}

	/**
	 * viewCategory method get the list of category present in the Categories class from CategoryServiceDAOImpl's vieCategoryService method
	 * and will begin the transction with the help of session.During this transaction it will show all the data present in the database of categories
	 * Criteria helps in getting all the data of class with further funcationalities
	 * @param category:object of Categories class that contains  the data for particular session
	 * @return list
	 */
	public List<Categories> viewCategory(Categories category) {
		List<Categories> list = null;
		Session session = getSession();
		Criteria criteria = session.createCriteria(Categories.class);
		list= criteria.list();
		session.close();
		return list;
	}

	

	
	
	
}
