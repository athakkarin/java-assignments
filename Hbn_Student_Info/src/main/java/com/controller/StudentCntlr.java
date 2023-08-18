package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.bean.StudentBean;
import com.dao.StudentDao;


@WebServlet("/StudentCntlr")
public class StudentCntlr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 * String fname = request.getParameter("fname"); String lname =
	 * request.getParameter("lname"); String email = request.getParameter("email");
	 * String mobile = request.getParameter("mobile"); String password =
	 * request.getParameter("password"); String gender =
	 * request.getParameter("gender");
	 */
		String action = request.getParameter("action");
		
		
		if(action.equalsIgnoreCase("signup"))
		{
			StudentBean s=new StudentBean();
			/*boolean isError = false;
			
			if(fname == null || fname.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("fnameError", "Please enter FirstName");
			}
			
			else if(fname.trim().length() <= 2)
			{
				isError = true;
				request.setAttribute("fnameError", "Please enter proper FirstName");
			}
			
			else if(fname.matches("[a-zA-Z]+")==false)
			{
				isError = true;
				request.setAttribute("fnameError", "Please enter valid FirstName");
				request.setAttribute("fnameValue", fname);
			}
			else
			{
				request.setAttribute("fnameValue", fname);
			}
			
			if(lname == null || lname.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("lnameError", "Please enter LastName");
			}
			
			else if(lname.trim().length() <= 2)
			{
				isError = true;
				request.setAttribute("lnameError", "Please enter proper LastName");
			}
			
			else if(lname.matches("[a-zA-Z]+")==false)
			{
				isError = true;
				request.setAttribute("lnameError", "Please enter valid LastName");
				request.setAttribute("lnameValue", lname);
			}
			else
			{
				request.setAttribute("lnameValue", lname);
			}
			
			if(email == null || email.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("emailError", "Please enter email");
			}

			else if(email.matches("^([A-za-z0-9])+@([A-Za-z])+\\.([a-zA-Z]){2,3}$")==false)
			{
				isError = true;
				request.setAttribute("emailError", "Please enter valid email");
				request.setAttribute("emailValue", email);
			}
			
			else
			{
				request.setAttribute("emailValue", email);
			}
			
			if(password == null || password.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("passwordError", "Please enter the Password");
			}
			else if(password.trim().length() <= 7)
			{
				isError = true;
				request.setAttribute("passwordError", "Please enter atleast 8 characters");
			}
			else if(password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}")==false)
			{
				isError = true;
				request.setAttribute("passwordError", "Please enter 1 Upper, Lower, Digit and special character");
			}
			else
			{
				request.setAttribute("passwordValue", password);
			}
			
			if(mobile == null || mobile.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("mobileError", "Please enter mobile");
			}
			
			else if(mobile.matches("^[0-9]{10}$")==false)
			{
				isError = true;
				request.setAttribute("mobileError", "Please enter 10 digit number");
				request.setAttribute("mobileValue", mobile);
			}
			else
			{
				request.setAttribute("mobileValue", mobile);
			}
			
			if(gender == null)
			{
				isError = true;
				request.setAttribute("genderError", "Please select gender");
			}
			else
			{
				request.setAttribute("genderValue", gender);
			}
			
			if(isError == true)
			{
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
*/			
				StudentDao.registerStudent(s);
				s.setFname(request.getParameter("fname"));
				s.setLname(request.getParameter("lname"));
				s.setEmail(request.getParameter("email"));
				s.setMobile(request.getParameter("mobile"));
				s.setPassword(request.getParameter("password"));
				s.setGender(request.getParameter("gender"));
				StudentDao.registerStudent(s);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		else if(action.equalsIgnoreCase("login"))
		{
			if(request.getParameter("email")!=null || request.getParameter("password")!=null)
			{
				StudentBean s=StudentDao.loginUser(request.getParameter("email"));
				if(s!=null)
				{
					if(s.getPassword().equals(request.getParameter("password")))
					{
							HttpSession session=request.getSession();
							session.setAttribute("s", s);
							request.getRequestDispatcher("viewuser.jsp").forward(request, response);
					}
					else
					{
						request.setAttribute("msg", "Incorrect Password");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
				else
				{
					request.setAttribute("msg", "Email Not Registered");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Email Or Password Should Not Be Empty");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
