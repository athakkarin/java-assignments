package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Cart;
import com.bean.Item;

public class CartUtil {

	public static Session createSession()
	{
		SessionFactory sf=new Configuration()
				.addAnnotatedClass(Cart.class)
				.addAnnotatedClass(Item.class)
				.configure()
				.buildSessionFactory();
		Session session=sf.openSession();
		return session;
	}
}
