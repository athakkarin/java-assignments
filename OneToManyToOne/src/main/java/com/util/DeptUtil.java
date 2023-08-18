package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.DeptB;
import com.bean.EmpB;

public class DeptUtil {

	public static Session createSession() 
	{
		SessionFactory sf = new Configuration()
				.addAnnotatedClass(DeptB.class)
				.addAnnotatedClass(EmpB.class)
				.configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
}
