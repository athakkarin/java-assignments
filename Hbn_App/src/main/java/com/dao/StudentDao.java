package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.StudentB;
import com.util.StudentUtil;

public class StudentDao {
	
	public static void insertStudent(StudentB s)
	{
		Session session = StudentUtil.createSession();
		Transaction tr = session.beginTransaction();
		session.save(s);
		tr.commit();
		session.close();
	}
	
	public static void updateStudent(StudentB s)
	{
		Session session = StudentUtil.createSession();
		Transaction tr = session.beginTransaction();
		session.update(s);
		tr.commit();
		session.close();
	}
	
	public static List<StudentB> getAllStudent()
	{
		Session session = StudentUtil.createSession();
		List<StudentB> list = session.createQuery("from StudentB").list();
		session.close();
		return list;
	}
	
	public static StudentB getStudent(int id)
	{
		Session session = StudentUtil.createSession();
		StudentB s = session.get(StudentB.class, id);
		session.close();
		return s;		
	}
	
	public static void deleteStudent(int id)
	{
		Session session = StudentUtil.createSession();
		Transaction tr = session.beginTransaction();
		StudentB s = session.get(StudentB.class, id);
		session.delete(s);
		tr.commit();
		session.close();
	}
	
	

}
