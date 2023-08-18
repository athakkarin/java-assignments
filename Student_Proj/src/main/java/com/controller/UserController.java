package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Random;

import com.bean.UserB;
import com.dao.UserDao;
import com.services.Services;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("sign up"))
		{
			boolean flag=UserDao.checkEmail(request.getParameter("email"));
			if(flag==false)
			{
				if(request.getParameter("password").equals(request.getParameter("cpassword")))
				{
					UserB u=new UserB();
					u.setFname(request.getParameter("fname"));
					u.setLname(request.getParameter("lname"));
					u.setEmail(request.getParameter("email"));
					u.setMobile(request.getParameter("mobile"));
					UserDao.signupUser(u);
					request.setAttribute("msg", "User Sign Up Successfully");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			}
			else
			{
				request.setAttribute("msg", "Email Already Registered");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login"))
		{
			if(request.getParameter("email")!=null || request.getParameter("password")!=null)
			{
				UserB u=UserDao.loginUser(request.getParameter("email"));
				if(u!=null)
				{
						
						HttpSession session=request.getSession();
						session.setAttribute("u", u);
						request.getRequestDispatcher("seller-index.jsp").forward(request, response);
						
				}
				
			}
			else
			{
				request.setAttribute("msg", "Email Not Registered");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("send otp"))
		{
			String email=request.getParameter("email");
			boolean flag=UserDao.checkEmail(email);
			if(flag==true)
			{
				Random t = new Random();
		    	int minRange = 1000, maxRange= 9999;
	        	int otp = t.nextInt(maxRange - minRange) + minRange;
	        	Services.sendMail(email, otp);
	        	System.out.println("OTP : "+otp);
	        	request.setAttribute("otp1", otp);
	        	request.setAttribute("email", email);
	        	
	        	request.getRequestDispatcher("otp.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Email Not Registered");
				request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("verify otp"))
		{
			String email=request.getParameter("email");
			int otp=Integer.parseInt(request.getParameter("otp"));
			int uotp=Integer.parseInt(request.getParameter("uotp"));
			
			if(otp==uotp)
			{
				request.setAttribute("email", email);
				request.getRequestDispatcher("newPassword.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("email", email);
	        	request.setAttribute("otp", otp);
				request.setAttribute("msg", "Invalid OTP");
				request.getRequestDispatcher("otp.jsp").forward(request, response);
			}
		}
			
	}

}
