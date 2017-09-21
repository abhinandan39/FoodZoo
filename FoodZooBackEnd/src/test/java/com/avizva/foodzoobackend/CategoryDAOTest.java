package com.avizva.foodzoobackend;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.config.TestContextConfig;
import com.avizva.dao.CategoryDAOImpl;
import com.avizva.model.Categories;

public class CategoryDAOTest {
	/**
	 * bean is used that is made through annotation
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestContextConfig.class);
	
	
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testSaveCategory() is made to test whether the saveCategory function is working properly and the data is saved to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
	@Test
	public void testSaveCategory()
	{
		Categories category=new Categories();
		category.setCategory_id("italian");
		category.setCategory_name("Italian");
		category.setCategory_description("Italianooooo");
		CategoryDAOImpl categoryDAOImpl =(CategoryDAOImpl) context.getBean("categoryDAOImpl");
		boolean result=categoryDAOImpl.saveCategory(category);
		assertTrue(result);
		Categories category2=new Categories();
		category2.setCategory_id("italian");
		category2.setCategory_name("Italian");
		category2.setCategory_description("Italianooooo");
		CategoryDAOImpl categoryDAOImpl2 =(CategoryDAOImpl) context.getBean("categoryDAOImpl");
		boolean result2=categoryDAOImpl2.saveCategory(category2);
		assertFalse(result2);

		
	}
	/**
	 * @Test annotation :  test case have been performed for the function above which it is applied
	 * testUpdateCategory() is made to test whether the updateCategoryfunction is working properly and the data is updated to database
	 *if result is true then Junit returns the success 
	 * else it shows the related errors
	 * 
	 */
//	@Test
//	public void testUpdateProduct()
//	{
//		Categories category2=new Categories();
//		category2.setCategory_id("italian");
//		category2.setCategory_name("Italian");
//		category2.setCategory_description("Hey Italian Lover");
//		CategoryDAOImpl categoryDAOImpl2 =(CategoryDAOImpl) context.getBean("categoryDAOImpl");
//		boolean result2=categoryDAOImpl2.updateCategory(category2);
//		assertTrue(result2);
//		
//	}
	
	/**
	 * testDeleteCategory() method to test whether the deleteCategory function is working well
	 * if it returns true then JUnit returns success
	 * else it shows the related errors
	 */
	
//	@Test
//	public void testDeleteProduct()
//	{
//		Categories category2=new Categories();
//		category2.setCategory_id("italian");
//		category2.setCategory_name("Italian");
//		category2.setCategory_description("Hey Italian Lover");
//		CategoryDAOImpl categoryDAOImpl2 =(CategoryDAOImpl) context.getBean("categoryDAOImpl");
//		boolean result2=categoryDAOImpl2.deleteCategory(category2);
//		assertTrue(result2);
//	}
	
	/**
	 * testViewCategoryById() method to test whether viewCategoryById function is working well
	 */
	@Test
	public void testViewCategoryById()
	{
		CategoryDAOImpl categoryDAOImpl2 =(CategoryDAOImpl) context.getBean("categoryDAOImpl");
		Categories result2=categoryDAOImpl2.viewCategoryById("italian");
		
		
	}
	/**
	 * testViewCategory() method to test whether viewCategory function is working well
	 */
	@Test
	public void testViewCategory()
	{	Categories category=null;
		CategoryDAOImpl categoryDAOImpl2 =(CategoryDAOImpl) context.getBean("categoryDAOImpl");
		List<Categories> result2=categoryDAOImpl2.viewCategory(category);
			
		
	}
	

}
