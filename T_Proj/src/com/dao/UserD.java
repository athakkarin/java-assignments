package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserB;
import com.util.ProjectUtil;

public class UserD {

public static void signupUser(UserB u) {
		
		try {
			Connection conn = ProjectUtil.createConnection();
		
			PreparedStatement pstmt = conn.prepareStatement("insert into user(fname, lname, email, mobile, address, password) values (?,?,?,?,?,?)");
			
			pstmt.setString(1, u.getFname());
			pstmt.setString(2, u.getLname());
			pstmt.setString(3, u.getEmail());
			pstmt.setLong(4, u.getMobile());
			pstmt.setString(5, u.getAdress());
			pstmt.setString(6, u.getPassword());
	
			pstmt.executeUpdate();
			System.out.println("User added...");
		}catch(Exception e) {
			System.out.println("Exception in UserDao::insertUser()");
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email){
		System.out.println("Email : "+email);
		boolean flag = false;
		try {
			Connection conn = ProjectUtil.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user where email=?");
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static UserB loginUser(String email){
		
		UserB u = null;
		try {
			Connection conn = ProjectUtil.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user where email=?");
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				u = new UserB();
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getLong("mobile"));
				u.setAdress(rs.getString("adress"));
				u.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
