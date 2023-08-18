package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Reader;
import com.bean.Subscription;

public class SubscriptionUtil {

	public static Session createSession()
	{
		SessionFactory sf=new Configuration()
				.addAnnotatedClass(Subscription.class)
				.addAnnotatedClass(Reader.class)
				.configure()
				.buildSessionFactory();
		Session session=sf.openSession();
		return session;
	}
}
