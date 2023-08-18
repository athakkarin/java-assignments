package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.StudentB;
import com.dao.StudentDao;

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		ApplicationContext a = new ClassPathXmlApplicationContext("Beans.xml");
		StudentDao studentDao=a.getBean("studentDao",StudentDao.class);
		
		if(action.equalsIgnoreCase("insert"))
		{
			StudentB s=new StudentB();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(request.getParameter("mobile"));
			studentDao.insertStudent(s);
			response.sendRedirect("insert.jsp");
		}
	}

}
