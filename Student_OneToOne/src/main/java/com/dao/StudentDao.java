package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Address;
import com.bean.Student;
import com.util.StudentUtil;

public class StudentDao {

	public static void insertStudentInfo(Student s)
	{
		Session session=StudentUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(s);
		tr.commit();
		session.close();
	}
	
	public static void insertAddress(Address a)
	{
		Session session=StudentUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(a);
		tr.commit();
		session.close();
	}
	
	public static List<Address> getAllStudent()
	{
		Session session=StudentUtil.createSession();
		List<Address> list=session.createQuery("from Address").list();
		session.close();
		return list;
	}
	
	public static Address getStudent(int addressId)
	{
		Session session=StudentUtil.createSession();
		Address a=session.get(Address.class,addressId);
		session.close();
		return a;
	}
	
	public static void updateAddress(Address a)
	{
		Session session=StudentUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.update(a);
		tr.commit();
		session.close();
	}
	
	public static void deleteEmployee(int addressId)
	{
		Session session=StudentUtil.createSession();
		Transaction tr=session.beginTransaction();
		Address a=session.get(Address.class,addressId);
		session.delete(a);
		tr.commit();
		session.close();
	}
	
}
