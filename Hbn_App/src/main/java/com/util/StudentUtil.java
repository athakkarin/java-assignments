package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.StudentB;

public class StudentUtil {

	public static Session createSession()
	{
		SessionFactory sf = new Configuration().addAnnotatedClass(StudentB.class).configure().buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
}
