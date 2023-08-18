package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.Address;
import com.bean.Student;
import com.dao.StudentDao;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("insert stud"))
		{
			Student student=new Student();
			student.setStudentName(request.getParameter("studentName"));
			
			StudentDao.insertStudentInfo(student);
			
			Address a=new Address();
			a.setStreet(request.getParameter("street"));
			a.setCity(request.getParameter("city"));
			a.setState(request.getParameter("state"));
			a.setZipcode(request.getParameter("zipcode"));
			a.setStudent(student);
			
			StudentDao.insertAddress(a);
			
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("edit"))
		{
			int addressId=Integer.parseInt(request.getParameter("addressId"));
			Address a=StudentDao.getStudent(addressId);
			request.setAttribute("a", a);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("update stud"))
		{
			Student student=new Student();
			student.setStudentName(request.getParameter("studentName"));
			
			Address a=new Address();
			
			a.setStreet(request.getParameter("street"));
			a.setCity(request.getParameter("city"));
			a.setState(request.getParameter("state"));
			a.setZipcode(request.getParameter("zipcode"));
			a.setStudent(student);
			
			StudentDao.updateAddress(a);
			
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			int addressId=Integer.parseInt(request.getParameter("addressId"));
			StudentDao.deleteEmployee(addressId);
			response.sendRedirect("show.jsp");
		}
	}

}
