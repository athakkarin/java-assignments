package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.DeptB;
import com.bean.EmpB;
import com.dao.DeptDao;


public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert dept"))
		{
			DeptB dept = new DeptB();
			dept.setDname(request.getParameter("dname"));
			dept.setLoc(request.getParameter("loc"));
			
			DeptDao.insertDept(dept);
			response.sendRedirect("dept.jsp");
		}
		
		if(action.equalsIgnoreCase("insert emp"))
		{
			EmpB emp = new EmpB();
			emp.setFname(request.getParameter("fname"));
			emp.setLname(request.getParameter("lname"));
			int did = Integer.parseInt(request.getParameter("dept"));
			DeptB dept = DeptDao.getDept(did);
			emp.setDept(dept);
			DeptDao.insertEmp(emp);
			response.sendRedirect("emp.jsp");
		}
	}

}
