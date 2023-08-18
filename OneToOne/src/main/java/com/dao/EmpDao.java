package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.EmployeeB;
import com.bean.EmployeePersonalInfo;
import com.util.EmpUtil;

public class EmpDao {
	
	public static void insertEmployeePersonalInfo(EmployeePersonalInfo e) 
	{
		Session session = EmpUtil.createSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(e);
		tr.commit();
		session.close();
	}
	
	public static void insertEmployee(EmployeeB e) 
	{
		Session session = EmpUtil.createSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(e);
		tr.commit();
		session.close();
	}
	
	public static List<EmployeeB> getAllEmployee()
	{
		Session session=EmpUtil.createSession();
		List<EmployeeB> list=session.createQuery("from EmployeeB").list();
		session.close();
		return list;
	}
	
	public static EmployeeB getEmployee(int eid)
	{
		Session session=EmpUtil.createSession();
		EmployeeB e=session.get(EmployeeB.class, eid);
		session.close();
		return e;
	}
	
	public static void deleteEmployee(int eid)
	{
		Session session=EmpUtil.createSession();
		Transaction tr=session.beginTransaction();
		EmployeeB e=session.get(EmployeeB.class,eid);
		session.delete(e);
		tr.commit();
		session.close();
	}

}
