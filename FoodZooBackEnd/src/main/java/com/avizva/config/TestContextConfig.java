package com.avizva.config;




import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;





@ComponentScan("com")
@Configuration
@EnableTransactionManagement
@Import({ApplicationContextConfig.class})
public class TestContextConfig {
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	   DriverManagerDataSource dataSource=new DriverManagerDataSource();
	   
	   // For MySQL
	   dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/test");
	    dataSource.setUsername("root"); 
	    dataSource.setPassword("root");

	    return dataSource;
	}
	
//	public Properties getHibernateProperties()
//	{
//		Properties properties=new Properties();
//		properties.put("hibernate.show_sql", "true");
//		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//		properties.put("hibernate.hbm2ddl.auto", "update");
//		return properties;
//		
//	}
//
//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) {
//
//	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//	    sessionBuilder.addProperties(getHibernateProperties());
//	   // sessionBuilder.addAnnotatedClasses(Users.class);
//	  
//	   sessionBuilder.scanPackages("com"); // This is used to scan a package for Annotated Classes
//	    
//	    return sessionBuilder.buildSessionFactory();
//	}

//	public Properties getHibernateProperties()
//	{
//		Properties properties=new Properties();
//		properties.put("hibernate.show_sql", "true");
//		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//		properties.put("hibernate.hbm2ddl.auto", "update");
//		return properties;
//		
//	}
//
//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) {
//
//	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//	    sessionBuilder.addProperties(getHibernateProperties());
//	   // sessionBuilder.addAnnotatedClasses(Users.class);
//	  
//	   sessionBuilder.scanPackages("com"); // This is used to scan a package for Annotated Classes
//	    
//	    return sessionBuilder.buildSessionFactory();
//	}
//
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new   HibernateTransactionManager(sessionFactory);
//	    return transactionManager;
//	}
//	  
	

}
