package com.avizva.foodzoobackend;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.config.TestContextConfig;
import com.avizva.dao.SupplierDAOImpl;
import com.avizva.model.Suppliers;

public class SupplierDAOTest {
	/**
	 * bean is used that is made through annotation
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestContextConfig.class);
	
	
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testSaveSupplier() is made to test whether the saveSupplier function is working properly and the data is saved to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
	@Test
	public void testSaveSupplier()
	{
		Suppliers supplier= new Suppliers();
		supplier.setSupplier_id("s01");
		supplier.setSupplier_name("Saurabh");
		supplier.setSupplier_description("supplies south indian food");
		SupplierDAOImpl supplierDAOImpl=(SupplierDAOImpl) context.getBean("supplierDAOImpl");
		boolean result=supplierDAOImpl.saveSupplier(supplier);
		assertTrue(result);

		Suppliers supplier2= new Suppliers();
		supplier2.setSupplier_id("s01");
		supplier2.setSupplier_name("Saurabh");
		supplier2.setSupplier_description("supplies south indian food");
		SupplierDAOImpl supplierDAOImpl2=(SupplierDAOImpl) context.getBean("supplierDAOImpl");
		boolean result2=supplierDAOImpl2.saveSupplier(supplier);
		assert(result2);

		
	}
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testUpdateSupplier() is made to test whether the updateSupplierfunction is working properly and the data is updated to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
//	@Test
//	public void testUpdateProduct()
//	{
//		Suppliers supplier= new Suppliers();
//		supplier.setSupplier_id("s01");
//		supplier.setSupplier_name("Prateek");
//		supplier.setSupplier_description("supplies south indian food");
//		SupplierDAOImpl supplierDAOImpl=(SupplierDAOImpl) context.getBean("supplierDAOImpl");
//		boolean result=supplierDAOImpl.updateSupplier(supplier);
//		
//		
//	}
	
	/**
	 * testDeleteSupplier() method to test whether the deleteSupplier function is working well
	 * if it returns true then JUnit returns success
	 * else it shows the related errors
	 */

	@Test
	public void testDeleteSupplier()
	{Suppliers supplier= new Suppliers();
	supplier.setSupplier_id("s01");
	supplier.setSupplier_name("Prateek");
	supplier.setSupplier_description("supplies south indian food");
	SupplierDAOImpl supplierDAOImpl=(SupplierDAOImpl) context.getBean("supplierDAOImpl");
	boolean result=supplierDAOImpl.deleteSupplier(supplier);
	
		
	}
	
	/**
	 * testViewSupplierById() method to test whether viewCategoryById function is working well
	 */
	@Test
	public void testViewSupplierById()
	{
	
		SupplierDAOImpl supplierDAOImpl=(SupplierDAOImpl) context.getBean("supplierDAOImpl");
		Suppliers result=supplierDAOImpl.viewSupplierById("s01");
		
		
	}
	/**
	 * testViewSupplier() method to test whether viewSupplier function is working well
	 */
	@Test
	public void testViewSupplier()
	{
Suppliers supplier=null;
		SupplierDAOImpl supplierDAOImpl=(SupplierDAOImpl) context.getBean("supplierDAOImpl");
		List<Suppliers> result=supplierDAOImpl.viewSupplier(supplier);
		
		
	}

}
