package com.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


import com.bean.StudentB;
import com.dao.StudentDao;



@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String gender = request.getParameter("gender");
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
			StudentB s=new StudentB();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			s.setMobile(request.getParameter("mobile"));
			s.setGender(request.getParameter("gender"));
			
			
		boolean isError = false;
		
		if(fname == null || fname.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("fnameError", "Please enter FirstName");
		}
		
		else if(fname.trim().length() <= 2)
		{
			isError = true;
			request.setAttribute("fnameError", "Please enter proper FirstName");
		}
		
		else if(fname.matches("[a-zA-Z]+")==false)
		{
			isError = true;
			request.setAttribute("fnameError", "Please enter valid FirstName");
			request.setAttribute("fnameValue", fname);
		}
		else
		{
			request.setAttribute("fnameValue", fname);
		}
		
		if(lname == null || lname.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("lnameError", "Please enter LastName");
		}
		
		else if(lname.trim().length() <= 2)
		{
			isError = true;
			request.setAttribute("lnameError", "Please enter proper LastName");
		}
		
		else if(lname.matches("[a-zA-Z]+")==false)
		{
			isError = true;
			request.setAttribute("lnameError", "Please enter valid LastName");
			request.setAttribute("lnameValue", lname);
		}
		else
		{
			request.setAttribute("lnameValue", lname);
		}
		
		if(email == null || email.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("emailError", "Please enter email");
		}

		else if(email.matches("^([A-za-z0-9])+@([A-Za-z])+\\.([a-zA-Z]){2,3}$")==false)
		{
			isError = true;
			request.setAttribute("emailError", "Please enter valid email");
			request.setAttribute("emailValue", email);
		}
		
		else
		{
			request.setAttribute("emailValue", email);
		}
		
		if(password == null || password.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("passwordError", "Please enter the Password");
		}
		else if(password.trim().length() <= 7)
		{
			isError = true;
			request.setAttribute("passwordError", "Please enter atleast 8 characters");
		}
		else if(password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}")==false)
		{
			isError = true;
			request.setAttribute("passwordError", "Please enter 1 Upper, Lower, Digit and special character");
		}
		else
		{
			request.setAttribute("passwordValue", password);
		}
		
		if(mobile == null || mobile.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("mobileError", "Please enter mobile");
		}
		
		else if(mobile.matches("^[0-9]{10}$")==false)
		{
			isError = true;
			request.setAttribute("mobileError", "Please enter 10 digit number");
			request.setAttribute("mobileValue", mobile);
		}
		else
		{
			request.setAttribute("mobileValue", mobile);
		}
		
		if(gender == null)
		{
			isError = true;
			request.setAttribute("genderError", "Please select gender");
		}
		else
		{
			request.setAttribute("genderValue", gender);
		}
		
		if(isError == true)
		{
			request.getRequestDispatcher("insert.jsp").forward(request, response);
		}
		else
		{
			StudentDao sd = new StudentDao();
			StudentDao.insertStudent(s);
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}
		}
		if(action.equalsIgnoreCase("edit"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			StudentB s=StudentDao.getStudent(id);
			request.setAttribute("s", s);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("update"))
		{
			StudentB s=new StudentB();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			s.setMobile(request.getParameter("mobile"));
			s.setGender(request.getParameter("gender"));
			StudentDao.updateStudent(s);
			request.setAttribute("msg", "Data Updated Successfully");
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			StudentDao.deleteStudent(id);
			request.setAttribute("msg", "Data Deleted Successfully");
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}
	}
	
	
}
