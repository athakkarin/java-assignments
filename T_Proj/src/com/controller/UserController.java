package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserB;
import com.dao.UserD;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("sign up")) 
		{
			boolean flag = UserD.checkEmail(request.getParameter("email"));
			System.out.println("Flag : "+flag);
			if(flag == false) 
			{
				if(request.getParameter("password").equals(request.getParameter("cpassword")))
				{
					UserB u = new UserB();
					u.setFname(request.getParameter("fname"));
					u.setLname(request.getParameter("lname"));
					u.setEmail(request.getParameter("email"));
					u.setMobile(Long.parseLong(request.getParameter("mobile")));
					u.setAdress(request.getParameter("adress"));
					u.setPassword(request.getParameter("password"));
					
					UserD.signupUser(u);
					request.setAttribute("msg", "User Signup successfully");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else 
				{
					request.setAttribute("msg", "Password and Confirm Password does not matched");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
			}
			else 
			{
				request.setAttribute("msg", "Email already registered");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login"))
		{
			if(request.getParameter("email") != null || request.getParameter("password") != null)
			{
				UserB u = UserD.loginUser(request.getParameter("email"));
				if(u!=null)
				{
					if(u.getPassword().equals(request.getParameter("email")))
					{
						HttpSession session = request.getSession();
						session.setAttribute("u", u);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					else 
					{
						request.setAttribute("msg", "Incorrect password");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
				else 
				{
					request.setAttribute("msg", "Email not registered");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else 
			{
				request.setAttribute("msg", "Email or Password should not be empty");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
