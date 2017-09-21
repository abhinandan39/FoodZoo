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
	
	/**
	 * saveCartItem method for saving the items present in the cart 
	 * it will save the complete data send by the user through cartItem class and takes its object as parameter
	 * will save the item in the cart
	 */
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
	/**
	 * updateCartItem method that takes CartItem 's object as parameter
	 * and update the item present in the cart
	 * return true or false
	 */
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
	
	/**
	 * deleteCartItem method will take the CatItem's object and that particular data will be delete from the database
	 * returns true or false
	 */
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
	/**
	 * viwCartItemById will show the cart items related to that cart item's id
	 * returns the cartitem that is the items present that cart items's id
	 */
	public CartItem viewCartItemById(int cart_item_id) {
		Session session = getSession();
		CartItem cartitem= session.get(CartItem.class, cart_item_id);
		session.close();
		return cartitem;
	}
	
	/**
	 * viewCartItems will show all the items present in the database
	 * return list of all the items
	 * 
	 */
	public List<CartItem> viewCartItems() {
		List<CartItem> list = null;
		Session session = getSession();
		Criteria criteria = session.createCriteria(CartItem.class);
		list= criteria.list();
		session.close();
		return list;
	}
	
	/**
	 * viewCartItemByUser method that takes username as the parameter
	 * regarding that username all the cartitems will be printed
	 * returns the list of item related to particular username
	 */
	
	
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
	/**
	 * getTotalPrice will  take the cartitems and username as the paramter
	 * for all the cartitems it will run a loop
	 * in that loop it'll perform the calculation for the total price
	 * returns the total price
	 */
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

/**
 * viewCartItemByProductIdAndUser method will take product_id and username as paramter
 * related to that username and product id it will show all the items
 */
	public List<CartItem> viewCartItemByProductIdAndUser(String product_id, String user_name) {

		List<CartItem> list=new ArrayList<CartItem>();
		Session session = getSession();
		Query query=session.createQuery("from CartItem where product_id=:product_id AND user_name=:user_name");
		query.setParameter("product_id", product_id);
		query.setParameter("user_name", user_name);
		list=query.list();
	    logger.info("list:"+list);
		return list;
	}

/**
 * cartitem price method return the price of the item according to the quantity
 * @param price
 * @param quantity
 * @return item price
 */
	
	public float cartitemprice(float price,int quantity)
	{
		return price*quantity;
		
	}
	
}
