package com.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletCntxt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		
		ServletContext contxt = getServletContext();


		String n1 = contxt.getInitParameter("num1");
		String n2 = contxt.getInitParameter("num2");


		pw.println("num1 value is " +n1+ " and num2 is " +n2);
	}

}
