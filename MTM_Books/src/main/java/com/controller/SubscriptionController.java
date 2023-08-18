package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


import com.bean.Reader;
import com.bean.Subscription;
import com.dao.SubscriptionDao;


@WebServlet("/SubscriptionController")
public class SubscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert subcp"))
		{
			Subscription s = new Subscription();
			s.setSubscriptionName(request.getParameter("subscriptionName"));
			SubscriptionDao.insertSubscription(s);
			response.sendRedirect("subscription.jsp");
		}
		
		else if(action.equalsIgnoreCase("insert reader"))
		{
			Reader r = new Reader();
			r.setEmail(request.getParameter("email"));
			r.setFirstName(request.getParameter("firstName"));
			r.setLastName(request.getParameter("lastName"));
			int subscriptionId = Integer.parseInt(request.getParameter("subscriptionId"));
			Set<Subscription> s = (Set<Subscription>) SubscriptionDao.getSubscription(subscriptionId);
			r.setSubscription(s);
			SubscriptionDao.insertReader(r);
			response.sendRedirect("reader.jsp");
			
		}
		
		else if(action.equalsIgnoreCase("edit"))
		{
			int readerId=Integer.parseInt(request.getParameter("readerId"));
			Reader r=SubscriptionDao.getSubscription(readerId);
			request.setAttribute("r", r);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("update"))
		{
			Subscription s=new Subscription();
			s.setSubscriptionName(request.getParameter("subscriptionName"));
			Reader r=new Reader();
			r.setReaderId(0);
			SubscriptionDao.updateReader(r);
			
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			int subscriptionId=Integer.parseInt(request.getParameter("subscriptionId"));
			SubscriptionDao.deleteCart(subscriptionId);
			response.sendRedirect("show.jsp");
		}
	}

}
