package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.bean.Reader;
import com.bean.Subscription;
import com.util.SubscriptionUtil;
public class SubscriptionDao {

	public static void insertSubscription(Subscription s)
	{
		Session session=SubscriptionUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.save(s);
		tr.commit();
		session.close();
	}
	
	public static void insertReader(Reader i)
	{
		Session session=SubscriptionUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.save(i);
		tr.commit();
		session.close();
	}
	
	public static Reader getSubscription(int readerId)
	{
		Session session=SubscriptionUtil.createSession();
		Reader r=session.get(Reader.class, readerId);
		session.close();
		return r;
	}
	
	public static List<Reader> getAllReader()
	{
		Session session=SubscriptionUtil.createSession();
		List<Reader> list=session.createQuery("from Reader").list();
		session.close();
		return list;
	}
	
	public static void updateReader(Reader r)
	{
		Session session=SubscriptionUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.update(r);
		tr.commit();
		session.close();
	}
	
	public static void deleteCart(int subscriptionId)
	{
		Session session=SubscriptionUtil.createSession();
		Transaction tr=session.beginTransaction();
		Subscription s=session.get(Subscription.class,subscriptionId);
		session.delete(s);
		tr.commit();
		session.close();
	}
}
