package com.avizva.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.model.Categories;
import com.avizva.model.Products;
import com.avizva.service.CategoryServiceDaoImpl;

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
	
	
	
}
