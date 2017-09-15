package com.avizva.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.avizva.Model.Suppliers;
import com.avizva.service.CategoryServiceDaoImpl;

public class SupplierDAOImpl implements SupplierDAO {
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
	 * saveSupplier method gets the supplier object as parameter from SupplierServiceDAOImpl's saveSupplierService method
	 * and will begin a transaction with the help of current session.During this transaction transaction data will be saved
	 * using session's save method followed by commitment of transaction and closing of session.
	 * on saving supplier data successfully it will return true to the SupplierServiceDAOImpl's saveSupplierService method.
	 * or else it returns false
	 * @param supplier : Object of suppliers class that contains data of a supplier for a particular session.
	 * @return true or false
	 * 
	 */
	public boolean saveSupplier(Suppliers supplier) {
	       logger.info("------inside dao:saveuser method------");
			boolean flag = false;
			Session session = null;
			Transaction transaction = null;
			try {
				session = getSession();
				transaction = session.beginTransaction();
				session.save(supplier);
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
	 * updateSupplier method get the supplier object from SupplierServiceDAOImpl's updateSupplierService method
	 * and will begin transaction with the help of current session.During this transaction data will be updated
	 * using session's update method followed by commitment of transaction and closing of session
	 * on updating category successfully it will return true to SupplierServiceDAOImpl's updateSupplierService method
	 * or else it returns false
	 * @param supplier:object of Suppliers class that contains data of supplier for a particular session
	 * @return true or false
	 * 
	 */
	public boolean updateSupplier(Suppliers supplier) {
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();

			session.update(supplier);
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
	 * deleteSupplier method get the supplier object from SupplierServiceDAOImpl's deleteSupplierService method
	 * and will begin transaction with the help of current session.During this transaction data will be deleted
	 * using session's delete method followed by commitment of transaction and closing of session
	 * on deleting category successfully it will return true to SupplierServiceDAOImpl's deleteSupplierService method
	 * or else it returns false
	 * @param supplier:object of Suppliers class that contains data of supplier for a particular session
	 * @return true or false
	 * 
	 */
	public boolean deleteSupplier(Suppliers supplier) {
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
	transaction = session.beginTransaction();
		session.delete(supplier);
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
	 * viewSupplierById method get the supplier_id  from SupplierServiceDAOImpl's viewSupplierByIdService method
	 * and will begin transaction with the help of current session.During this transaction, it will show the data related to that
	 * supplier id
	 * using session's get with parameters passed supplier class and supplier id
	 * that will actually function for showing data from class with that id
	 *  method followed by commitment of transaction and closing of session
	 * on showing supplier successfully it will return true to SupplierServiceDAOImpl's viewSupplierByIdService method
	 * or else it returns false
	 * @param supplier_id:parameter supplier_id of Suppliers class that contains data of supplier for a particular session
	 * @return true or false
	 * 
	 */
	public Suppliers viewSupplierById(String supplier_id) {
		Session session = getSession();
		Suppliers supplier= session.get(Suppliers.class, supplier_id);
		session.close();
		return supplier;
	}

	/**
	 * viewSupplier method get the list of supplier present in the Suppliers class from SuppliersServiceDAOImpl's vieSupplierService method
	 * and will begin the transaction with the help of session.During this transaction it will show all the data present in the database of categories
	 * Criteria helps in getting all the data of class with further functionalities
	 * @param supplier:object of Suppliers class that contains  the data for particular session
	 * @return list
	 */
	public List<Suppliers> viewSupplier(Suppliers supplier) {
		List<Suppliers> list = null;
		Session session = getSession();
		Criteria criteria = session.createCriteria(Suppliers.class);
		list= criteria.list();
		session.close();
		return list;
	}


	


}
