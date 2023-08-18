package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.catalina.connector.Response;

import com.bean.Student;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String WebURL="http://localhost:8083/RestServer/";
	ClientConfig config=null;
	Client client=null;
	WebTarget target=null;
	Gson gson=new Gson();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		config=new ClientConfig();
		client=ClientBuilder.newClient(config);
		target=client.target(WebURL).path("rest");
		
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("insert"))
		{
			Student s=new Student();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(request.getParameter("mobile"));
			
			String student=gson.toJson(s);
			Response rs=target.path("student").path("insert").request().post(Entity.json(student));
			String result=rs.readEntity(String.class);
			if(rs.getStatus()==200)
			{
				showStudent(request, response);
			}
			else
			{
				System.out.println(result);
			}
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			Response rs=target.path("student").path("delete").queryParam("sid", id).request().get();
			if(rs.getStatus()==200)
			{
				showStudent(request, response);
			}
		}
	}
	protected void showStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Response rs=target.path("student").path("getall").request().get();
		String result=rs.readEntity(String.class);
		if(rs.getStatus()==200)
		{
			List<Student> list=gson.fromJson(result,new TypeToken<List<Student>>() {}.getType());
			request.setAttribute("list", list);
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}
	}

}
