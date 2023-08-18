package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentB;
import com.util.StudentUtil;

public class StudentDao {

	public static void insertStudent(StudentB s)
	{
		try {
			Connection conn = StudentUtil.createConnection();
			String sql = "insert into student(fname,lname,email,password,mobile,gender) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getPassword());
			pst.setString(5, s.getMobile());
			pst.setString(6, s.getGender());
			pst.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void insertDeletedStudent(StudentB s)
	{
		try {
			Connection conn = StudentUtil.createConnection();
			String sql = "insert into deleted(fname,lname,email,password,mobile,gender,id) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getPassword());
			pst.setString(5, s.getMobile());
			pst.setString(6, s.getGender());
			pst.setInt(7, s.getId());
			pst.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<StudentB> getAllStudent() 
	{
		List<StudentB> list = new ArrayList<StudentB>();
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="select * from student";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				StudentB s=new StudentB();
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				s.setMobile(rs.getString("mobile"));
				s.setGender(rs.getString("gender"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static StudentB getStudent(int id)
	{
		StudentB s=null;
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="select * from student where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				s=new StudentB();
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				s.setMobile(rs.getString("mobile"));
				s.setGender(rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static void updateStudent(StudentB s)
	{
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="update student set fname=?,lname=?,email=?,password=?,mobile=?,gender=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getPassword());
			pst.setString(5, s.getMobile());
			pst.setString(6, s.getGender());
			pst.setInt(7, s.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteStudent(int id)
	{
		try {
			Connection conn=StudentUtil.createConnection();
			StudentB s=StudentDao.getStudent(id);
			StudentDao.insertDeletedStudent(s);
			String sql="delete from student where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
