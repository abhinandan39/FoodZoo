package com.avizva.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.model.Categories;
import com.avizva.model.Products;
import com.avizva.service.CategoryServiceDaoImpl;
/**
 * @repository makes the bean of impl class
 * ProductsDAOImpl class that implemnets ProductsDAO and execute all its method
 * @author Parul.Sharma
 *
 */
@Repository
public class ProductsDAOImpl implements ProductsDAO {

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
	 * saveProduct method for saving the product into the database
	 * takes the product's object and all its information
	 * and saves the data to the database
	 * return true or false
	 */
	public boolean saveProduct(Products product) {

		logger.info("------inside dao:saveProduct method------");
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.save(product);
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
 * updateProduct that takes the products's object and update the existing product
 * returns true or false
 */
	public boolean updateProduct(Products product) {
			
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();

			session.update(product);
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
 * deleteProduct that takes the product's object as the parameter
 * takes all the data of that object
 * and perform deletion operation
 * returns true or false
 */
	public boolean deleteProduct(Products product) {

		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
		transaction = session.beginTransaction();
		session.delete(product);
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
 * viewProductById method takes the unique product_id as the parameter
 * it will show all the products related to that product id
 * returns product
 */
	public Products viewProductById(String product_id) {

		Session session = getSession();
		Products product = null;
		try{
				product = session.get(Products.class, product_id);
				
		}
		catch (Exception e) {
			logger.error("Error in fetching Product by Id");
		}
		finally{
			session.close();
		}
		return product;
	}
/**
 * viewProducts method will show all the products present in the database
 * takes the products class and will extract complete list of the product present in the database
 * returns the list of the products
 */
	public List<Products> viewProducts() {

		List<Products> products = null;
		Session session=null;
		try{
			session= getSession();
			Criteria criteria = session.createCriteria(Products.class);
			products = criteria.list();
			
		}
		catch(Exception e){
			
		}
		finally{
			session.close();
		}
			
			return products;
	}
	/**
	 * productByCategory method will showthe product relatedto the particular category
	 * return the products
	 */
	public List<Products> productByCategory(String category){
		List<Products> products = null;
		Session session = getSession();
		try{
			session= getSession();
			Query query = session.createQuery("from Products where category_name =:category_name");
			query.setParameter("category_name", category);
			products = query.list();
			
		}
		catch(Exception e){
			
		}
		finally{
			session.close();
		}
			
			return products;
	}
	
	
	
}
