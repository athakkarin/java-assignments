package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.bean.Cart;
import com.bean.Item;
import com.util.CartUtil;


public class CartDao {

	public static void insertCart(Cart c)
	{
		Session session=CartUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.save(c);
		tr.commit();
		session.close();
	}
	
	public static void insertItem(Item i)
	{
		Session session=CartUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.save(i);
		tr.commit();
		session.close();
	}
	
	public static Item getCart(int itemId)
	{
		Session session=CartUtil.createSession();
		Item i=session.get(Item.class, itemId);
		session.close();
		return i;
	}
	
	public static List<Cart> getAllCart()
	{
		Session session=CartUtil.createSession();
		List<Cart> list=session.createQuery("from Cart").list();
		session.close();
		return list;
	}
	
	public static List<Item> getAllItem()
	{
		Session session=CartUtil.createSession();
		List<Item> list=session.createQuery("from Item").list();
		session.close();
		return list;
	}
	
	public static void updateItem(Item i)
	{
		Session session=CartUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.update(i);
		tr.commit();
		session.close();
	}
	
	public static void deleteCart(int cartId)
	{
		Session session=CartUtil.createSession();
		Transaction tr=session.beginTransaction();
		Cart c=session.get(Cart.class,cartId);
		session.delete(c);
		tr.commit();
		session.close();
	}
}
