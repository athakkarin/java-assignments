package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.StudentBean;
import com.util.StudentUtil;


public class StudentDao {

	public static void registerStudent(StudentBean s) 
	{
		Session session=StudentUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.save(s);
		tr.commit();
		session.close();
	}

	public static boolean checkEmail(String email)
	{
		boolean flag=false;
		try {
			Session session = StudentUtil.createSession();
			Transaction tr=session.beginTransaction();
			StudentBean s = (StudentBean) session.createQuery("select * from StudentBean where email=?").setParameter("email", email).uniqueResult();
			session.save(s);
			tr.commit();
			session.close();
			if(s != null && s.getEmail().equals(email))
			{
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static StudentBean loginUser(String email)
	{
		StudentBean s = null;
		try {
			Session session =StudentUtil.createSession();
			Transaction tr=session.beginTransaction();
			s = (StudentBean) session.createQuery(" from StudentBean where email=?").setParameter("email", email).uniqueResult();
			session.save(s);
			tr.commit();
			session.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public StudentBean getUserById(int id) {

		StudentBean s = new StudentBean();
		try {
			Session session =StudentUtil.createSession();
			Transaction tr=session.beginTransaction();
			s = (StudentBean) session.createQuery(" select * from StudentBean where id=?");

			s.getId();
			s.getFname();
			s.getLname();
			s.getEmail();
			s.getMobile();
			s.getPassword();
			s.getGender();
			
			session.save(s);
			tr.commit();
			session.close();

		} catch (

		Exception e) {
			System.out.println("Exception in UserDao::searchUser()");
			e.printStackTrace();
		}
		return s;
	}
}