package com.avizva.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.Model.Users;

@Repository("us")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}
	public boolean saveUser(Users user) {

		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();

			System.out.println(user);
			user.setEnabled(true);
			session.save(user);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			transaction.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}

		return flag;

	}
	public boolean updateUser(String username) {

		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			Users user = session.get(Users.class, username);
			session.update(user);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();

		}
		return flag;
	}

	
	public boolean valid(String username, String password) {
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;

		session = getSession();
		transaction = session.beginTransaction();

		Query query = session.createQuery("from Users where username =:username AND password =:password ");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Users> list = query.list();
		if (list.isEmpty()) {

			flag = false;
		}
		else{
			flag=true;
		}

		session.close();

		return flag;

	}

	
	public boolean deactivateUser(String username) {
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		System.out.println("Inside Deactivate UserDAOIMPl "+username);
		try{
		session = getSession();
		transaction = session.beginTransaction();
		Users user = session.get(Users.class, username);
		user.setEnabled(false);
		System.out.println("Inside Deactivate UserDAOIMPl. Getting user "+user);
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


	public Users viewUser(String username) {
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;

		session = getSession();
		transaction = session.beginTransaction();

		Users user=session.get(Users.class, username);
		session.close();
		return user;
		


	}

}
