package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Cart;
import com.bean.User;
import com.bean.Wishlist;
import com.dao.CartDao;
import com.dao.UserDao;
import com.dao.WishlistDao;


@WebServlet("/UserController")
public class UserController extends HttpServlet {

       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		ApplicationContext a=new ClassPathXmlApplicationContext("Beans.xml");
		UserDao userDao=a.getBean("userDao",UserDao.class);
		
		if(action.equalsIgnoreCase("signup"))
		{
			boolean flag=UserDao.checkEmail(request.getParameter("email"));
			if(flag==false)
			{
				User u = new User();
				u.setUsertype(request.getParameter("usertype"));
				u.setFirstName(request.getParameter("firstName"));
				u.setLastName(request.getParameter("lastName"));
				u.setEmail(request.getParameter("email"));
				u.setMobile(request.getParameter("mobile"));
				u.setPassword(request.getParameter("password"));
				u.setGender(request.getParameter("gender"));
				u.setProfile_pic(request.getParameter("profile_pic"));
				userDao.signupUser(u);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			else
			{
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("login"))
		{
			if(request.getParameter("email")!=null)
			{
				User u=UserDao.loginUser(request.getParameter("email"));
				if(u!=null)
				{
						if(u.getUsertype().equals("user"))
						{
							HttpSession session=request.getSession();
							List<User> list=UserDao.
							session.setAttribute("user_count", list.size());
							session.setAttribute("u", u);
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}
						else
						{
							HttpSession session=request.getSession();
							session.setAttribute("u", u);
							request.getRequestDispatcher("seller-index.jsp").forward(request, response);
						}
					}
					
				}
				
		}
	}

}
