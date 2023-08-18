package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.DeptB;
import com.bean.EmpB;
import com.util.DeptUtil;


public class DeptDao {

	public static void insertDept(DeptB dept)
	{
		Session session = DeptUtil.createSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(dept);
		tr.commit();
		session.close();
	}
	
	public static void insertEmp(EmpB emp)
	{
		Session session = DeptUtil.createSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(emp);
		tr.commit();
		session.close();
	}
	
	public static DeptB getDept(int did)
	{
		Session session=DeptUtil.createSession();
		DeptB dept =session.get(DeptB.class, did);
		session.close();
		return dept;
	}
	
	public static List<DeptB> getAllDept()
	{
		Session session=DeptUtil.createSession();
		List<DeptB> list=session.createQuery("from DeptB").list();
		session.close();
		return list;
	}
}
