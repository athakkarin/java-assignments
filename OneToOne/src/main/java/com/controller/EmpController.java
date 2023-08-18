package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.EmployeeB;
import com.bean.EmployeePersonalInfo;
import com.dao.EmpDao;


public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert emp"))
		{
			EmployeePersonalInfo epinfo = new EmployeePersonalInfo();
			epinfo.setFname(request.getParameter("fname"));
			epinfo.setLname(request.getParameter("lname"));
			epinfo.setEmail(request.getParameter("email"));
			
			EmpDao.insertEmployeePersonalInfo(epinfo);
			
			EmployeeB e = new EmployeeB();
			e.setJob(request.getParameter("job"));
			e.setDept(request.getParameter("dept"));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			e.setEpinfo(epinfo);
			
			EmpDao.insertEmployee(e);
			
			response.sendRedirect("Show.jsp"); 	
		}
		
		else if(action.equalsIgnoreCase("edit"))
		{
			int eid = Integer.parseInt(request.getParameter("eid"));
			EmployeeB e = EmpDao.getEmployee(eid);
			request.setAttribute("e", e);
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("update"))
		{
			EmployeePersonalInfo epinfo = new EmployeePersonalInfo();
			epinfo.setFname(request.getParameter("fname"));
			epinfo.setLname(request.getParameter("lname"));
			epinfo.setEmail(request.getParameter("email"));
			EmployeeB e = new EmployeeB();
			e.setJob(request.getParameter("job"));
			e.setDept(request.getParameter("dept"));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			e.setEpinfo(epinfo);
			
			EmpDao.insertEmployee(e);
			
			response.sendRedirect("Show.jsp"); 
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			int eid=Integer.parseInt(request.getParameter("eid"));
			EmpDao.deleteEmployee(eid);
			response.sendRedirect("Show.jsp");
		}
	}

}
