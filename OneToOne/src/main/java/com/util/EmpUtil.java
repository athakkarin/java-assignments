package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.EmployeeB;
import com.bean.EmployeePersonalInfo;

public class EmpUtil {

	public static Session createSession()
	{
		SessionFactory sf = new Configuration()
				.addAnnotatedClass(EmployeePersonalInfo.class)
				.addAnnotatedClass(EmployeeB.class)
				.configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
}
