package com.avizva.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.Model.Users;

@Repository("us")
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.openSession();
	}
	
	public boolean saveUser(Users user) {
		
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		flag = true;
		}
		catch(Exception e){
			transaction.rollback();
			System.out.println(e);
		}
		finally{
			session.close();	
		}
		
		return flag;
	
	}

	public boolean updateUser(Users user) {
		
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
		transaction = session.beginTransaction();
		session.update(user);
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

}
