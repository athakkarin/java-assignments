package com.bean;


public class Student {

	
	private int id;
	String fname, lname, email, mobile;
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String toString() {
        return "Student: "+ id +" , " + fname +" , " + lname +" , " + email +" , " + mobile + "\n\t";
    }
	
	   
}
