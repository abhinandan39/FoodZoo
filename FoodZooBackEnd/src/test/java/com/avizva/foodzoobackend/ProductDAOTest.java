package com.avizva.foodzoobackend;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.AssertFalse;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.config.TestContextConfig;
import com.avizva.dao.ProductsDAOImpl;
import com.avizva.dao.UserDAOImpl;
import com.avizva.model.Products;
import com.avizva.model.Users;

public class ProductDAOTest {
	/**
	 * bean is used that is made through annotation
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestContextConfig.class);
	
	
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testSaveProduct() is made to test whether the saveProduct function is working properly and the data is saved to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
	@Test
	public void testSaveProduct()
	{
		Products product=new Products();
		product.setProduct_id("p01");
		product.setProduct_name("Pizza");
		product.setCategory_name("Italian");
		product.setDescription("super cheesy pizza");
		product.setPrice((float) 299.5);
		product.setQuantity(100);
		product.setSupplier_name("Mr Raju Tikadar");
		ProductsDAOImpl productDAOImpl=(ProductsDAOImpl) context.getBean("productsDAOImpl");
		boolean result=productDAOImpl.saveProduct(product);
		assertTrue(result);
		Products product2=new Products();
		product2.setProduct_id("p01");
		product2.setProduct_name("Pizza");
		product2.setCategory_name("Italian");
		product2.setDescription("super cheesy pizza");
		product2.setPrice((float) 299.5);
		product2.setQuantity(5);
		product2.setSupplier_name("Mr Raju Tikadar");
		ProductsDAOImpl productDAOImpl2=(ProductsDAOImpl) context.getBean("productsDAOImpl");
		boolean result2=productDAOImpl2.saveProduct(product2);
		assertFalse(result2);
		
		
	}
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testUpdateProduct() is made to test whether the updateProduct function is working properly and the data is updated to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
	@Test
	public void testUpdateProduct()
	{
		Products product=new Products();
		product.setProduct_id("p01");
		product.setProduct_name("Pizza");
		product.setCategory_name("Italian");
		product.setDescription("super cheesy pizza");
		product.setPrice((float) 299.5);
		product.setQuantity(5);
		product.setSupplier_name("Mr Shivam Mehta");
		ProductsDAOImpl productDAOImpl=(ProductsDAOImpl) context.getBean("productsDAOImpl");
		boolean result=productDAOImpl.updateProduct(product);
		assertTrue(result);

		
	}
	
	/**
	 * testDeleteProduct() method to test whether the deleteProduct function is working well
	 * if it returns true then JUnit returns success
	 * else it shows the related errors
	 */
	
	@Test
	public void testDeleteProduct()
	{
		Products product=new Products();
		product.setProduct_id("p01");
		product.setProduct_name("Pizza");
		product.setCategory_name("Italian");
		product.setDescription("super cheesy pizza");
		product.setPrice((float) 299.5);
		product.setQuantity(5);
		product.setSupplier_name("Mr Shivam Mehta");
		ProductsDAOImpl productDAOImpl=(ProductsDAOImpl) context.getBean("productsDAOImpl");
			boolean result=productDAOImpl.deleteProduct(product);
			assertTrue(result);
		
	}
	
	/**
	 * testViewProductById() method to test whether viewProductById function is working well
	 */
	@Test
	public void testViewProductById()
	{
		
		ProductsDAOImpl productDAOImpl=(ProductsDAOImpl) context.getBean("productsDAOImpl");
			Products result=productDAOImpl.viewProductById("p01");
			
		
	}
	/**
	 * testViewProduct() method to test whether viewProduct function is working well
	 */
	@Test
	public void testViewProduct()
	{
		
		ProductsDAOImpl productDAOImpl=(ProductsDAOImpl) context.getBean("productsDAOImpl");
			List<Products> result= productDAOImpl.viewProducts();
			
		
	}
	/**
	 * testViewProductByCategory() method to test whether viewProductByCategory function is working well
	 */
	@Test
	public void testViewProductByCategory()
	{
		
		ProductsDAOImpl productDAOImpl=(ProductsDAOImpl) context.getBean("productsDAOImpl");
			List<Products> result= productDAOImpl.productByCategory("Italian");
			
		
	}
	
}
