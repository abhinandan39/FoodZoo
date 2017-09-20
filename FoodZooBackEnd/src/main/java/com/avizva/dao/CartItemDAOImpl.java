package com.avizva.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.model.CartItem;
import com.avizva.model.Products;

@Repository
public class CartItemDAOImpl implements CartItemDAO {

	/**
	 * for keeping the log of this class
	 */
	
	Logger logger=Logger.getLogger(CartItemDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;
	
	
	/**
	 * getSession method is used to open/create a session from the auto-wired object of sessionFactory.
	 * @return Session
	 */
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	
	public boolean saveCartItem(CartItem cartitem)
	{
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.save(cartitem);
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
	public boolean updateCartItem(CartItem cartitem)
	{
		
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();

			session.update(cartitem);
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
	
	
	public boolean deleteCartItem(CartItem cartitem) {
		boolean flag=false;
		Session session=null;
		Transaction transaction =null;
		try{
		session = getSession();
	transaction = session.beginTransaction();
		session.delete(cartitem);
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
	
	public CartItem viewCartItemById(int cart_item_id) {
		Session session = getSession();
		CartItem cartitem= session.get(CartItem.class, cart_item_id);
		session.close();
		return cartitem;
	}
	
	public List<CartItem> viewCartItems(CartItem cartitem) {
		List<CartItem> list = null;
		Session session = getSession();
		Criteria criteria = session.createCriteria(CartItem.class);
		list= criteria.list();
		session.close();
		return list;
	}
	
	
	
	
	public List<CartItem> viewCartItemsByUser(String user_name)
	{
		List<CartItem> list=new ArrayList<CartItem>();
		Session session = getSession();
		Query query=session.createQuery("from CartItem where user_name=:user_name");
		query.setParameter("user_name", user_name);
		list=query.list();
	    logger.info("list:"+list);
		return list;
		
	}
	
	public float getTotalPrice(List<CartItem> cartitems,String user_name)
	{
		CartItemDAOImpl cartitemdaoimpl=null;
		float totalprice=0l;
		Session session = getSession();
		for(CartItem item : cartitems)
		{
			totalprice=totalprice+ (item.getPrice())*(item.getCartitem_quantity());
		}
	
		return totalprice;
		
	}


	public List<CartItem> viewCartItemByProductId(String product_id) {

		List<CartItem> list=new ArrayList<CartItem>();
		Session session = getSession();
		Query query=session.createQuery("from CartItem where product_id=:product_id");
		query.setParameter("product_id", product_id);
		list=query.list();
	    logger.info("list:"+list);
		return list;
	}


	
}
