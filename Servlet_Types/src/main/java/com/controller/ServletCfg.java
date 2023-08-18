package com.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletCfg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		
		ServletConfig conf=getServletConfig();


		String s1 = conf.getInitParameter("no1");
		String s2 = conf.getInitParameter("no2");


		pw.println("no1 value is " +s1+ " and no2 is " +s2);
	}

}
