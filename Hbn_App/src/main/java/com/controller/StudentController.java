package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.StudentB;
import com.dao.StudentDao;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert")) {
			StudentB s = new StudentB();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(request.getParameter("mobile"));
			StudentDao.insertStudent(s);
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("edit"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			StudentB s = StudentDao.getStudent(id);
			request.setAttribute("s",s);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("update"))
		{
			StudentB s = new StudentB();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(request.getParameter("mobile"));
			StudentDao.updateStudent(s);
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			StudentDao.deleteStudent(id);
			response.sendRedirect("show.jsp");
		}
	}

}
